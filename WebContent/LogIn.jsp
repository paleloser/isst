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
  <shiro:guest>
    <nav class="navbar navbar-expand-lg sticky-top justify-content-between">
      <a class="navbar-brand logo" href="index">
        GDPR
      </a>
    </nav>
    <div class="content">
      <section class="first">
        <div class="container">
          <div class="row justify-content-center">
            <form class="col col-sm-12 col-md-5 col-lg-4" method="POST" action="LogIn"
              style="background-color: white; padding: 15px; box-shadow: 2px 2px 5px rgba(0,0,0,0.2);">
              <h6 class="title">ACCESO</h6>
              <div class="col"><br></div>
              <input class="col col-md-12 col-sm-12" type="email" name="correo" placeholder="Correo" required>
              <div class="col"><br></div>
              <div class="input-group justify-content-between">
                <input class="col" type="password" name="password" id="passwd" placeholder="Contraseña" required>
              </div>
              <button class="btn btn-primary btn-sm float-right submit" type="submit">ACCEDER</button>
            </form>
          </div>
        </div>
      </section>
      <footer class="footer content-center">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 col-md-4 content-center item">
              <div class="row">
                <div class="col-12 content-center">
                  <a class="title" href="index">GDPR</a>
                </div>
                <div class="col-12 content-center justify-content-between">
                  <a class="link" href="index#body">Inicio</a>
                  |<a class="link" href="index#info">Info</a>
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
  </shiro:guest>
</body>

</html>