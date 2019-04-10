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

@WebServlet({ "/EnviarFormulario" })
public class EnviarFormulario extends HttpServlet {

	private final String[] AREAS = { "personal", "biomedica" };

	private String capitalize(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
  }
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO: for test purposes, resend the info to the CdE view
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
		        req.getSession().setAttribute(key, parameters.get(key));
          } else {
		        req.getSession().setAttribute(key, parameters.get(key)[0]);
          }
        }
      }
    }
		req.getSession().setAttribute("areas", areas);
		getServletContext().getRequestDispatcher("/CDEFormProyecto.jsp").forward(req, resp);
  }
}
