package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gdpr.dao.TokenDAO;
import es.upm.dit.isst.gdpr.dao.TokenDAOImplementation;
import es.upm.dit.isst.gdpr.dao.UsuarioDAO;
import es.upm.dit.isst.gdpr.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.gdpr.model.Token;
import es.upm.dit.isst.gdpr.model.Usuario;

@WebServlet({ "/RegistroCDE" })
public class RegistroCDE extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userType = (String) req.getSession().getAttribute("userType");
    
    if (userType != null) {
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
      return;
    }

    if (req.getParameter("t") == null) {
      resp.sendRedirect(req.getContextPath() + "/");
    }

    String t = req.getParameter("t");
    TokenDAO tokenDAO = TokenDAOImplementation.getInstance();
    Token token = tokenDAO.read(t);

    if (token == null) {
      resp.sendRedirect(req.getContextPath() + "/");
    }

    if (!token.getValido()) {
      resp.sendRedirect(req.getContextPath() + "/");
    }
    
    req.setAttribute("token", token.getId());

    getServletContext().getRequestDispatcher("/SignInCDE.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String userType = (String) req.getSession().getAttribute("userType");
    String email = (String) req.getSession().getAttribute("email");
    
    // If someone unknown is GETing the path we redirect him to login
    if (userType == null || email == null) 
      getServletContext().getRequestDispatcher("/Index.jsp").forward(req, resp);

    // If the person is a researcher then we redirect him to his page
    if (userType == "investigador") 
      resp.sendRedirect(req.getContextPath() + "/InvestigadorOverview");

    UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
    Usuario user = udao.read(email);

    Token token = new Token();
    token.setEmitidoPor(user);
    TokenDAO tdao = TokenDAOImplementation.getInstance();
    token = tdao.create(token);

    if (token != null) {
      req.setAttribute("token", token.getId());
    } else {
      req.setAttribute("token", "Hubo un error al generar el token.");
    }
    
    getServletContext().getRequestDispatcher("/ShowToken.jsp").forward(req, resp);
  }
}