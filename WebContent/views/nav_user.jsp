<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg sticky-top justify-content-between">
  <a class="navbar-brand logo" href="index">
    GDPR
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <i class="material-icons nav-icon">layers</i>
  </button>
  <ul class="nav collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
    <li class="nav-item">
      <a class="nav-link" href="Proyectos">Mis Casos</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="NuevoProyecto" data-toggle="tooltip" data-placement="top" title="Subir proyecto">
        <i class="material-icons">add</i>
      </a>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
        aria-haspopup="true" aria-expanded="false">
        <img src="${pageContext.request.contextPath}/img/profile.jpg" height="40px" style="border-radius: 100%;">
      </a>
      <div class="dropdown-menu dropdown-menu-right " aria-labelledby="navbarDropdown">
        <a class="dropdown-item" href="Proyectos">Mis Casos</a>
        <a class="dropdown-item" href="Configuracion">Configuración</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="LogOut">Log Out</a>
      </div>
    </li>
  </ul>
</nav>