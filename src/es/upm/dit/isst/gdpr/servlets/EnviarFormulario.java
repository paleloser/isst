package es.upm.dit.isst.gdpr.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.Solicitud;

@WebServlet({ "/EnviarFormulario" })
@MultipartConfig
public class EnviarFormulario extends HttpServlet {

	private final String[] AREAS = { "personal", "biomedica" };

	private String capitalize(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
  }
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

  /**
   * This method should receive on the request:
   *    - "titulo": project title
   *    - "fecha": project starting date
   *    - "area\d+": form fields
   *    - "file": project resume
   */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String titulo = req.getParameter("titulo");
		String fecha = req.getParameter("fecha");
		
		Solicitud solicitud = new Solicitud();
		solicitud.setFecha(fecha);
		solicitud.setTitulo(titulo);
		
		Part filePart = req.getPart( "file" );
		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for(int length=0; (length = fileContent.read(buffer)) > 0;) output.write(buffer,0,length);
		
		solicitud.setInvestigacion(output.toByteArray());
		
		
  // How to get the area\d+ input fields:
    Map<String, String[]> parameters = req.getParameterMap();
		ArrayList<String> areas = new ArrayList<>();
    for (String key : parameters.keySet()) {
      for (String area : AREAS) {
        Pattern p = Pattern.compile(area + "\\d+"); // We want to match params like "personal12"
        Matcher m = p.matcher(key);
        if (m.matches()) {
					if(!areas.contains(capitalize(area))) areas.add(capitalize(area));
          // If the param has a single value better send it instead of a single-item array
          if (parameters.get(key).length >  1) {
            // Remember this is done to test CdE views. On real servlet this should be changed
		        req.setAttribute(key, parameters.get(key));
          } else {
            // Remember this is done to test CdE views. On real servlet this should be changed
		        req.setAttribute(key, parameters.get(key)[0]);
          }
        }
      }
    }
    
    solicitud.setForm(parameters);
    solicitud.setEstado(1);
    
    
    
    SolicitudDAO solDAO = SolicitudDAOImplementation.getInstance();
	solDAO.create(solicitud);
	
    // Remove the fields of the project we dont need anymore
    req.getSession().removeAttribute("titulo");
    req.getSession().removeAttribute("fecha");
    req.getSession().removeAttribute("areas");
    // Following lines are written only to test the CdE view
		req.setAttribute("areas", areas);
		req.setAttribute("id", solicitud.getId());
		getServletContext().getRequestDispatcher("/CDEFormProyecto.jsp").forward(req, resp);
  }
}
