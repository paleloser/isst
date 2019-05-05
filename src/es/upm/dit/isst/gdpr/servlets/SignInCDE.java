package es.upm.dit.isst.gdpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.gdpr.dao.TokenDAO;
import es.upm.dit.isst.gdpr.dao.TokenDAOImplementation;
import es.upm.dit.isst.gdpr.dao.UsuarioDAO;
import es.upm.dit.isst.gdpr.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.gdpr.model.Token;
import es.upm.dit.isst.gdpr.model.Usuario;

@WebServlet("/SignInCDE")
public class SignInCDE extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String t = req.getParameter("token");
    TokenDAO tdao = TokenDAOImplementation.getInstance();
    Token token = tdao.read(t);

    if (token == null)
      resp.sendRedirect(req.getContextPath() + "/");

    if (!token.getValido())
      resp.sendRedirect(req.getContextPath() + "/");

    token.setValido(false);
    tdao.update(token);

    String nombre = req.getParameter("nombre").trim();
    String apellidos = req.getParameter("apellidos").trim();
    String correo = req.getParameter("correo").trim();
    String dni = req.getParameter("dni").trim();
    String password = req.getParameter("password");
    Usuario usuario = new Usuario();
    usuario.setName(nombre);
    usuario.setSurname(apellidos);
    usuario.setEmail(correo);
    usuario.setDNI(dni);
    usuario.setMcde(true);
    usuario.setCdi("");
    usuario.setPassword(new Sha256Hash(password).toString());

    UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
    udao.create(usuario);

    req.getSession().setAttribute("userType", "mcde");
    req.getSession().setAttribute("email", correo);

    resp.sendRedirect(req.getContextPath() + "/CDEOverview");
  }
}
