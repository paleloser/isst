package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.model.Solicitud;

@WebServlet({ "/MuestraSolicitud" })
public class MuestraSolicitud extends HttpServlet {
	
	private final String[] AREAS = { "personal", "biomedica" };
	private String capitalize(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter("titulo");
		SolicitudDAO solDAO = SolicitudDAOImplementation.getInstance();
		Solicitud sol = solDAO.read(titulo);
		Map<String, String[]> parameters = sol.getForm();
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
		req.getSession().setAttribute("titulo", titulo);
		req.setAttribute("areas", areas);
		req.setAttribute("estado", sol.getEstado());
		getServletContext().getRequestDispatcher( "/CDEFormProyecto.jsp" ).forward( req, resp );
	}
}