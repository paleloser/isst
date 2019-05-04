package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Index", "/", "/index" })
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String userType = (String) req.getSession().getAttribute("userType");
    
    if (userType == null) {
      getServletContext().getRequestDispatcher("/Index.jsp").forward(req, resp);
      return;
    }

    switch (userType) {
      case "mcde":
        resp.sendRedirect(req.getContextPath() + "/CDEOverview");
        break;
      case "investigador":
        resp.sendRedirect(req.getContextPath() + "/InvestigadorOverview");
        break;
      default:
        getServletContext().getRequestDispatcher("/Index.jsp").forward(req, resp);
        break;
    }
  }
  
}
