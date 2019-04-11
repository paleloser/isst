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

@WebServlet({ "/ServirInvestigadorServlet" })
public class ServirInvestigacionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		SolicitudDAO solDAO = SolicitudDAOImplementation.getInstance();
		
		Solicitud solicitud = solDAO.read(Integer.parseInt(id));
		
		resp.setContentLength(solicitud.getInvestigacion().length);
		resp.getOutputStream().write(solicitud.getInvestigacion());
	}

}
