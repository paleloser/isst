package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/InvestigadorOverview", })
public class InvestigadorOverview extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String userType = (String) req.getSession().getAttribute("userType");
    String email = (String) req.getSession().getAttribute("email");
    
    // If someone unknown is GETing the path we redirect him to login
    if (userType == null || email == null) 
      getServletContext().getRequestDispatcher("/Index.jsp").forward(req, resp);

    // If the person is a CDE member then we redirect him to his page
    if (userType == "mcde") 
      resp.sendRedirect(req.getContextPath() + "/CDEOverview");

    getServletContext().getRequestDispatcher("/InvestigadorOverview.jsp").forward(req, resp);
  }
  
}
