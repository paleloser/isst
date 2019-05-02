package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;

@WebServlet({ "/EstadoSolicitud" })
public class EstadoSolicitud extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
        req.setAttribute("sdao_id", sdao.read(req.getParameter("email")));

		getServletContext().getRequestDispatcher( "/Proyecto.jsp" ).forward( req, resp );
		
	}
}