package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.AnotacionDAO;
import es.upm.dit.isst.gdpr.dao.AnotacionDAOImplementation;
import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.*;

@WebServlet({ "/ProcesarSolicitud" })
public class ProcesarSolicitud extends HttpServlet{
	
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
		EmailHandler automail = EmailHandler.getInstance();
		
		if (estado == "2"){
			automail.sendEmail(email, "Estado De Investigacion", "Estimado/a "+solicitud.getInvestigador().getName() + " " + solicitud.getInvestigador().getSurname()+" su solicitud para comenzar el proyecto"+ titulo +"ha sido rechazada por el GDPR.");
		}
		else if(estado=="3"){
			automail.sendEmail(email, "Estado De Investigacion", "Estimado/a "+solicitud.getInvestigador().getName() + " " + solicitud.getInvestigador().getSurname()+" su solicitud para comenzar el proyecto"+ titulo +"ha sido rechazada por el GDPR.");

		}
		
		else if (estado == "4") {
			String contenido = req.getParameter("anotacion");
			if (contenido != null) {
				AnotacionDAO anotacionDAO = AnotacionDAOImplementation.getInstance();
				Anotacion anotacion = new Anotacion();
				anotacion.setContenido(contenido);
				anotacion.setSolicitud(solicitud);
				anotacionDAO.create(anotacion);
				automail.sendEmail(email, "Estado De Investigacion", "Estimado/a "+solicitud.getInvestigador().getName() + " " + solicitud.getInvestigador().getSurname()+"se requieren mas datos para proceder con la evaluacion de su solicitud");
			}
		}

		// TODO: send notification

		req.getSession().setAttribute("email", (String) req.getSession().getAttribute("email"));
		resp.sendRedirect(req.getContextPath() + "/CDEOverview");
	}

}
