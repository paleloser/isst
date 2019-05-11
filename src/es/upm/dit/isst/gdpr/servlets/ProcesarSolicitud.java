package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.AnotacionDAO;
import es.upm.dit.isst.gdpr.dao.AnotacionDAOImplementation;
import es.upm.dit.isst.gdpr.dao.NotificacionDAOImplementation;
import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.Anotacion;
import es.upm.dit.isst.gdpr.model.Notificacion;
import es.upm.dit.isst.gdpr.model.Solicitud;

@WebServlet({ "/ProcesarSolicitud" })
public class ProcesarSolicitud extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String estado = req.getParameter("estado");
		SolicitudDAO solDAO = SolicitudDAOImplementation.getInstance();

		Solicitud solicitud = solDAO.read(titulo);
		int status = Integer.parseInt(estado);

		solicitud.setEstado(status);
		solDAO.update(solicitud);

		String email = solicitud.getInvestigador().getEmail();

		String asunto = "Se realizaron correcciones sobre su proyecto.";

		Notificacion notificacion = new Notificacion();
		notificacion.setUsuario(solicitud.getInvestigador());
		notificacion.setAsunto(asunto);

		String cuerpo = "";

		switch (estado) {
			case "1":
				break;
			case "2":
				notificacion.setTipo("Propuesta aprobada");
				cuerpo += "La solicitud con titulo " + titulo
						+ " ha sido aprobada. Puede acceder a la plataforma para descargar su certificado.";
				break;
			case "3":
				notificacion.setTipo("Propuesta denegada");
				cuerpo += "La solicitud con titulo " + titulo
						+ " ha sido denegada. Puede acceder a la plataforma para obtener mas informacion sobre el motivo de denegacion.";
				break;
			case "4":
				notificacion.setTipo("Falta informacion");
				String contenido = req.getParameter("anotacion");
				cuerpo += "Falta informacion respecto a la solicitud con titulo " + titulo + ":\n";
				if (contenido != null) {
					AnotacionDAO anotacionDAO = AnotacionDAOImplementation.getInstance();
					Anotacion anotacion = new Anotacion();
					anotacion.setContenido(contenido);
					anotacion.setSolicitud(solicitud);
					anotacionDAO.create(anotacion);
					cuerpo += contenido;
				}
				break;
			default:
				break;
		}

		notificacion.setContenido(cuerpo);
		NotificacionDAOImplementation.getInstance().create(notificacion);

		EmailHandler automail = EmailHandler.getInstance();
		automail.sendEmail(email, asunto, cuerpo);

		req.getSession().setAttribute("email", (String) req.getSession().getAttribute("email"));
		resp.sendRedirect(req.getContextPath() + "/CDEOverview");
	}

}
