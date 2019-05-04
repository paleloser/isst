package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.Solicitud;

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
		System.out.println(status);
		solicitud.setEstado(status);
		solDAO.update(solicitud);
		req.getSession().setAttribute("email", (String) req.getSession().getAttribute("email"));
		resp.sendRedirect(req.getContextPath() + "/CDEOverview");
	}

}
