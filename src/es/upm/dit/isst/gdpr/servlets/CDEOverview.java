package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.UsuarioDAO;
import es.upm.dit.isst.gdpr.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.gdpr.model.Solicitud;
import es.upm.dit.isst.gdpr.model.Usuario;

@WebServlet({ "/CDEOverview", })
public class CDEOverview extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String userType = (String) req.getSession().getAttribute("userType");
    String email = (String) req.getSession().getAttribute("email");
    
    // If someone unknown is GETing the path we redirect him to login
    if (userType == null || email == null) 
      getServletContext().getRequestDispatcher("/Index.jsp").forward(req, resp);

    // If the person is a researcher then we redirect him to his page
    if (userType == "investigador") 
      resp.sendRedirect(req.getContextPath() + "/InvestigadorOverview");

    UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
    Usuario u = udao.read(email);
    Collection<Solicitud> solicitudes = u.getSolicitudes();
    Collection<Solicitud> solicitudesFinal = new ArrayList<Solicitud>();
    for (Solicitud sol : solicitudes) {
    	Solicitud solicitudIncompleta = new Solicitud();
    	solicitudIncompleta.setTitulo(sol.getTitulo());
    	solicitudIncompleta.setFecha(sol.getFecha());
    	solicitudIncompleta.setEstado(sol.getEstado());
    	solicitudesFinal.add(solicitudIncompleta);
    }
    
    req.setAttribute("solicitudes", solicitudesFinal);
    getServletContext().getRequestDispatcher("/CDEOverview.jsp").forward(req, resp);
  }
  
}
