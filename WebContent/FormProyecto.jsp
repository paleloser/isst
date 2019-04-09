<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <!-- META -->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="description" content="GDPR - ISST G22 | Mis casos">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

  <title>GDPR - ISST G22 | Nuevo Proyecto</title>

  <!-- FONTS -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat|Roboto|Playfair+Display|Roboto+Slab:100,300"
    rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <!-- BS4 -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
  <!-- Stylesheet -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>

<body>
  <nav class="navbar navbar-expand-lg sticky-top justify-content-between">
    <a class="navbar-brand logo" href="/">
      GDPR
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <i class="material-icons nav-icon">layers</i>
    </button>
    <ul class="nav collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
      <li class="nav-item">
        <a class="nav-link" href="/Proyectos">Mis Casos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/NuevoProyecto" data-toggle="tooltip" data-placement="top" title="Subir proyecto">
          <i class="material-icons">add</i>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
          <img src="${pageContext.request.contextPath}/img/profile.jpg" height="40px" style="border-radius: 100%;">
        </a>
        <div class="dropdown-menu dropdown-menu-right " aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Proyectos">Mis Casos</a>
          <a class="dropdown-item" href="/Configuracion">Configuración</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/LogOut">Log Out</a>
        </div>
      </li>
    </ul>
  </nav>
  <div class="content">
    <jsp:include page="/WEB-INF/tags/formPersonal_ul.jsp" />
  </div>
  
  <!-- SCRIPTS -->
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</body>

</html>