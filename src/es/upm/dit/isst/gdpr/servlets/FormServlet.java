package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/FormServlet" })
public class FormServlet extends HttpServlet {

	private final String[] AREAS = { "personal", "biomedica", "animales", "quimicos", "genetica", "radiactiva",
			"medioambiental", "otro" };

	private String capitalize(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> areas = new ArrayList<>();
		for (String area : AREAS) {
			if (req.getParameter(area) != null) {
				if (req.getParameter(area).equals("si")) {
					areas.add(capitalize(area));
				}
			}
		}
		// We need those on the next servlet to make the CREATE query
		req.getSession().setAttribute("titulo", req.getParameter("titulo"));
		req.getSession().setAttribute("fecha", req.getParameter("fecha"));
		req.getSession().setAttribute("areas", areas);
		getServletContext().getRequestDispatcher("/FormProyecto.jsp").forward(req, resp);
	}
}
