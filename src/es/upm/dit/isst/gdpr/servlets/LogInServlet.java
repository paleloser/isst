package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet({ "/LogIn" })
@MultipartConfig
public class LogInServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/LogIn.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("correo");
    String passwd = req.getParameter("password");

    Subject currentUser = SecurityUtils.getSubject();
    if (!currentUser.isAuthenticated()) {
      UsernamePasswordToken token = new UsernamePasswordToken(email, passwd);
      try {
        currentUser.login(token);
        if (currentUser.hasRole("mcde")) {
          req.getSession().setAttribute("userType", "mcde");
          resp.sendRedirect(req.getContextPath() + "/CDEOverview?email=" + currentUser.getPrincipal());
        } else if (currentUser.hasRole("researcher")) {
          req.getSession().setAttribute("userType", "researcher");
          resp.sendRedirect(req.getContextPath() + "/InvestigadorOverview?email=" + currentUser.getPrincipal());
        } else {
          resp.sendRedirect(req.getContextPath() + "/LogIn");
        }
      } catch (Exception e) {
        resp.sendRedirect(req.getContextPath() + "/LogIn");
      }
    } else
      resp.sendRedirect(req.getContextPath() + "/LogIn");
  }
}
