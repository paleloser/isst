<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="GDPR - ISST G22">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
  <title>GDPR - ISST G22</title>
  <jsp:include page="views/styles.jsp" />
</head>

<body id='body'>
  <nav class="navbar navbar-expand-lg sticky-top justify-content-between">
    <a class="navbar-brand logo sliding-link" href="#body">
      GDPR
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <i class="material-icons nav-icon">layers</i>
    </button>
    <ul class="nav collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
      <li class="nav-item">
        <a class="nav-link sliding-link" href="#info">Info</a>
      </li>
      <li class="nav-item">
        <a class="nav-link login" href="LogIn">Log In</a>
      </li>
    </ul>
  </nav>
  <div class="content">
    <section class="first">
      <div class="container">
        <div class="row">
          <div class="col col-2 quote">
            <img src="img/quote.png" width="20px" height="17px">
          </div>
          <div class="col col-8 cita">
            La protección de las personas físicas en relación con el tratamiento de datos personales es un derecho
            fundamental. El artículo 8, apartado 1, de la Carta de los Derechos Fundamentales de la Unión Europea («la
            Carta») y el artículo 16, apartado 1, del Tratado de Funcionamiento de la Unión Europea (TFUE) establecen
            que
            toda persona tiene derecho a la protección de los datos de carácter personal que le conciernan.
          </div>
        </div>
      </div>
    </section>
    <section class="second">
      <div class="container">
        <div class="row">
          <form class="col col-sm-12 col-md-5 col-lg-3" method="POST" action="SignIn">
            <h6 class="title">REGISTRO INVESTIGADOR</h6>
            <input class="col col-md-12 col-sm-12" type="text" name="nombre" placeholder="Nombre" required>
            <input class="col col-md-12 col-sm-12" type="text" name="apellidos" placeholder="Apellidos" required>
            <input class="col col-md-12 col-sm-12" type="email" name="correo" placeholder="Correo" required>
            <input class="col col-md-12 col-sm-12" type="text" name="dni" placeholder="DNI" required>
            <div class="input-group justify-content-between">
              <input class="col col-md-10 col-sm-10" type="password" name="password" id="passwd"
                placeholder="Contraseña" required>
              <div class="input-group-append content-center">
                <i class="material-icons" id="togglePasswd">visibility</i>
              </div>
            </div>
            <button class="btn btn-primary btn-sm float-right submit" type="submit">ACCEDER</button>
          </form>
        </div>
      </div>
    </section>
    <section class="info" id="info">
      <div class="container">
        <div class="row">
          <div class="col-1 col-md-2"></div>
          <div class="col-10 col-md-12 col-lg-4  d-flex flex-column justify-content-between">
            <h4>
              Sobre la aplicación
            </h4>
            <p>
              La aprobación hace unos meses del Reglamento General de Protección de Datos impone a
              cualquier organización que maneje datos personales la necesidad de tratarlos
              cuidadosamente para mantener la privacidad.
            </p>
            <p>
              Esto exige a las organizaciones que manejan datos personales a organizar los procesos que
              aseguren que se mantiene dicha privacidad.
            </p>
          </div>
          <div class="col-1 d-md-none"></div>
          <div class="col-1 d-md-none"></div>
          <div class="col-10 col-md-12 col-lg-4">
            <p>En el caso de las universidades tecnológicas en
              las que se realizan proyectos de investigación científico-técnica que a menudo necesitan
              tratar datos personales privados muy sensibles (información genética, información sobre
              movimientos de personas en espacios públicos), se establece un Comité de Ética, compuesto
              por expertos en privacidad, que evalúa –antes de que comience- el riesgo de cualquier
              actividad de investigación que maneje datos sensibles.
            </p>
          </div>
        </div>
      </div>
    </section>
    <footer class="footer content-center">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-4 content-center item">
            <div class="row">
              <div class="col-12 content-center">
                <a class="title">GDPR</a>
              </div>
              <div class="col-12 content-center justify-content-between">
                <a class="link sliding-link" href="#body">Inicio</a>
                |<a class="link sliding-link" href="#info">Info</a>
              </div>
            </div>
          </div>
          <div class="col-sm-12 col-md-4 content-center item">
            <a href="https://www.upm.es"><img src="img/upm.png" alt="logo upm" height="130px"></a>
          </div>
          <div class="col-sm-12 col-md-4 content-center item">
            <img src="img/cc.png" alt="copyright" height="40px">
          </div>
        </div>
      </div>
    </footer>
  </div>
  <jsp:include page="views/scripts.jsp" />
</body>

</html>