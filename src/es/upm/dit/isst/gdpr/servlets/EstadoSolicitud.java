package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.AnotacionDAOImplementation;
import es.upm.dit.isst.gdpr.dao.NotificacionDAOImplementation;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.Anotacion;
import es.upm.dit.isst.gdpr.model.Notificacion;
import es.upm.dit.isst.gdpr.model.Solicitud;

@WebServlet({ "/EstadoSolicitud" })
public class EstadoSolicitud extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Solicitud sol = SolicitudDAOImplementation.getInstance().read(req.getParameter("solicitud"));
		req.setAttribute("sdao_id", sol);

		Collection<Anotacion> anotaciones = AnotacionDAOImplementation.getInstance().readAllBySolicitud(sol);
		req.setAttribute("anotaciones", anotaciones);

		Collection<Notificacion> notificaciones = NotificacionDAOImplementation.getInstance().readAllOrderedByDate();
		ArrayList<Notificacion> mList = new ArrayList<>();
		for (Notificacion notificacion : notificaciones) {
			if (notificacion.getSolicitud().getTitulo().equals(sol.getTitulo())) {
				mList.add(notificacion);
			}
		}
		req.setAttribute("notificaciones", mList);

		getServletContext().getRequestDispatcher("/Proyecto.jsp").forward(req, resp);

	}
}