package es.upm.dit.isst.gdpr.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.gdpr.dao.NotificacionDAO;
import es.upm.dit.isst.gdpr.dao.NotificacionDAOImplementation;
import es.upm.dit.isst.gdpr.dao.SolicitudDAO;
import es.upm.dit.isst.gdpr.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.gdpr.dao.UsuarioDAO;
import es.upm.dit.isst.gdpr.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.gdpr.model.Notificacion;
import es.upm.dit.isst.gdpr.model.Solicitud;
import es.upm.dit.isst.gdpr.model.Usuario;

@WebServlet({ "/EnviarFormulario" })
@MultipartConfig
public class EnviarFormulario extends HttpServlet {

  private final String[] AREAS = { "personal", "biomedica" };

  private String capitalize(final String line) {
    return Character.toUpperCase(line.charAt(0)) + line.substring(1);
  }

  Random rand = new Random();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }

  /**
   * This method should receive on the request: - "titulo": project title -
   * "fecha": project starting date - "area\d+": form fields - "file": project
   * resume
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String titulo = req.getSession().getAttribute("titulo").toString();
    String fecha = req.getSession().getAttribute("fecha").toString();
    String email = (String) req.getSession().getAttribute("email");

    UsuarioDAO idao = UsuarioDAOImplementation.getInstance();
    Usuario investigador = idao.read(email);

    Solicitud solicitud = new Solicitud();
    solicitud.setFecha(fecha);
    solicitud.setTitulo(titulo);
    solicitud.setInvestigador(investigador);

    Part filePart = req.getPart("file");
    InputStream fileContent = filePart.getInputStream();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    byte[] buffer = new byte[10240];
    for (int length = 0; (length = fileContent.read(buffer)) > 0;)
      output.write(buffer, 0, length);


    solicitud.setHmac(new Sha256Hash(output.toByteArray()).toString());
    solicitud.setInvestigacion(output.toByteArray());

    // How to get the area\d+ input fields:
    Map<String, String[]> parameters = req.getParameterMap();
    ArrayList<String> areas = new ArrayList<>();
    for (String key : parameters.keySet()) {
      for (String area : AREAS) {
        Pattern p = Pattern.compile(area + "\\d+"); // We want to match params like "personal12"
        Matcher m = p.matcher(key);
        if (m.matches()) {
          if (!areas.contains(capitalize(area)))
            areas.add(capitalize(area));
          // If the param has a single value better send it instead of a single-item array
          if (parameters.get(key).length > 1) {
            // Remember this is done to test CdE views. On real servlet this should be
            // changed
            req.setAttribute(key, parameters.get(key));
          } else {
            // Remember this is done to test CdE views. On real servlet this should be
            // changed
            req.setAttribute(key, parameters.get(key)[0]);
          }
        }
      }
    }

    solicitud.setForm(parameters);
    solicitud.setEstado(1);
    solicitud = asignarMCDE(areas, solicitud);

    SolicitudDAO solDAO = SolicitudDAOImplementation.getInstance();
    solDAO.create(solicitud);

    // Remove the fields of the project we dont need anymore
    req.getSession().removeAttribute("titulo");
    req.getSession().removeAttribute("fecha");
    req.getSession().removeAttribute("areas");
    req.getSession().setAttribute("email", solicitud.getInvestigador().getEmail());
    resp.sendRedirect(req.getContextPath() + "/InvestigadorOverview");
  }

  private Solicitud asignarMCDE(ArrayList<String> especialidades, Solicitud solicitud) {

    Usuario mcde;
    Collection<Usuario> mcdes = new ArrayList<Usuario>();
    ArrayList<Usuario> mcdeFinal = new ArrayList<Usuario>();
    Collection<Usuario> users = new ArrayList<Usuario>();
    int min = Integer.MAX_VALUE;

    UsuarioDAO udao = UsuarioDAOImplementation.getInstance();
    users = udao.readAll();

    NotificacionDAO ndao = NotificacionDAOImplementation.getInstance();

    // Comprobar las especialidades de la solicitud y despues hacer una lista con
    // los mcde adecuados.
    for (Usuario user : users) {
      if (user.getMcde()) {
        if (especialidades.size() == 1) {
          if (user.getEspecialidades().split(";").length == 2) {
            mcdes.add(user);
            if (user.getSolicitudes().size() < min) {
              min = user.getSolicitudes().size();
            }
          } else {
            if (user.getEspecialidades().split(";")[0].trim().equals(especialidades.get(0).toUpperCase().trim())) {
              mcdes.add(user);
              if (user.getSolicitudes().size() < min) {
                min = user.getSolicitudes().size();
              }
            }
          }
        } else if (especialidades.size() == 2) {
          if ((user.getEspecialidades().split(";").length == 2)) {
            mcdes.add(user);
            if (user.getSolicitudes().size() < min) {
              min = user.getSolicitudes().size();
            }
          }

        } else {
          mcdes.add(user);
          if (user.getSolicitudes().size() < min) {
            min = user.getSolicitudes().size();
          }
        }

      }
    }

    // Buscar los mcde con menos solicitudes
    for (Usuario amcde : mcdes) {
      if (amcde.getSolicitudes().size() == min) {
        mcdeFinal.add(amcde);
      }
    }
    // Asignar la solicitud al que menos tenga o a uno aleatorio dentro de esto si
    // es m�s de uno
    if (mcdeFinal.size() > 1) {
      int n = rand.nextInt(mcdeFinal.size());
      mcde = mcdeFinal.get(n);
    } else {
      mcde = mcdeFinal.get(0);
    }

    // Asignarlo al mcde y enviarle un email
    Collection<Solicitud> soli = mcde.getSolicitudes();
    soli.add(solicitud);
    mcde.setSolicitudes(soli);
    udao.update(mcde);
    solicitud.setMiembroCDE(mcde);

    String emailMCDE = mcde.getEmail();
    String asunto = "Se le ha asignado un nuevo proyecto";
    String cuerpo = "Se le ha asginado un nuevo proyecto titulado " + solicitud.getTitulo() + " creado por "
        + solicitud.getInvestigador().getName() + " " + solicitud.getInvestigador().getSurname() + ".";

    Notificacion notificacion = new Notificacion();
    notificacion.setUsuario(mcde);
    notificacion.setAsunto(asunto);
    notificacion.setContenido(cuerpo);
    notificacion.setTipo("Propuesta subida");
    ndao.create(notificacion);

    EmailHandler automail = EmailHandler.getInstance();
    automail.sendEmail(emailMCDE, asunto, cuerpo);

    return solicitud;

  }
}
