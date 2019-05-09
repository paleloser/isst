package es.upm.dit.isst.gdpr.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import es.upm.dit.isst.gdpr.dao.AnotacionDAO;
import es.upm.dit.isst.gdpr.dao.AnotacionDAOImplementation;
import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.Anotacion;
import es.upm.dit.isst.gdpr.model.Solicitud;
import es.upm.dit.isst.gdpr.model.Usuario;

/**
 * Servlet implementation class NuevaMemoriaServlet
 */
@WebServlet("/NuevaMemoriaServlet")
@MultipartConfig
public class NuevaMemoriaServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		AnotacionDAO adao = AnotacionDAOImplementation.getInstance();
		String titulo = req.getAttribute("titulo").toString();
		Part filePart = req.getPart("file");
	    InputStream fileContent = filePart.getInputStream();
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[10240];
	    for (int length = 0; (length = fileContent.read(buffer)) > 0;)
	      output.write(buffer, 0, length);
	    Solicitud solicitud = sdao.read(titulo);
	    solicitud.setInvestigacion(output.toByteArray());
	    sdao.update(solicitud);
	    
	    ArrayList<Anotacion> anotaciones = (ArrayList<Anotacion>) adao.readAll();
	    ArrayList<Anotacion> misAnotaciones = new ArrayList<Anotacion>();
	    for(Anotacion anotacion: anotaciones) {
	    	if (anotacion.getSolicitud().getTitulo().equals(titulo)) {
	    		misAnotaciones.add(anotacion);
	    	}
	    }
	    for(Anotacion anotacion: misAnotaciones) {
	    	if (!anotacion.isAtendida()) {
	    		anotacion.setAtendida(true);
	    		adao.update(anotacion);
	    	}
	    }
	    
	    resp.sendRedirect(req.getContextPath() + "/InvestigadorOverview");
	    
	    
	}

}
