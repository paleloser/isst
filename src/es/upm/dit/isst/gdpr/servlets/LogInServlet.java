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

    // If the user is not authenticated try to do so
    if (!currentUser.isAuthenticated()) {
      UsernamePasswordToken token = new UsernamePasswordToken(email, passwd);
      try {
        currentUser.login(token);
      } catch (Exception e) {
        System.out.println("Login fallido: redireccionando a vista de login...");
        getServletContext().getRequestDispatcher("/LogIn.jsp").forward(req, resp);
        return;
      }
    } 
    
    // If the user IS authenticated...
    if (currentUser.hasRole("mcde")) {
      if (!email.equals("admin@cde.upm.es")) {
        req.getSession().setAttribute("isAdmin", false);
      } else {
        req.getSession().setAttribute("isAdmin", true);
      }
      // Set primary session attributes
      req.getSession().setAttribute("userType", "mcde");
      req.getSession().setAttribute("email", currentUser.getPrincipal());

      System.out.println("Usuario reconocido: redireccionando a servlet de CDE...");
      resp.sendRedirect(req.getContextPath() + "/CDEOverview");
    } else if (currentUser.hasRole("investigador")) {
      // Set primary session attributes
      req.getSession().setAttribute("userType", "investigador");
      req.getSession().setAttribute("email", currentUser.getPrincipal());

      System.out.println("Usuario reconocido: redireccionando a servlet de Investigador...");
      resp.sendRedirect(req.getContextPath() + "/InvestigadorOverview");
    } else {
      System.out.println("Usuario no reconocido: redireccionando a servlet de LogIn...");
      getServletContext().getRequestDispatcher("/LogIn.jsp").forward(req, resp);
    }
  }
}
