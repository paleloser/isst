<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
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
      <a class="nav-link" href="CDEOverview">Mis Casos</a>
    </li>
    <c:if test="${not empty sessionScope.isAdmin}">
      <c:if test="${sessionScope.isAdmin}">
          <li class="nav-item">
            <form action="RegistroCDE" method="POST">
              <button type="submit" class="icon-button nav-link">Generar Token</button>
            </form>
          </li>
      </c:if>
    </c:if>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
        aria-haspopup="true" aria-expanded="false">
        <img src="${pageContext.request.contextPath}/img/coe.png" height="40px" style="border-radius: 100%;">
      </a>
      <div class="dropdown-menu dropdown-menu-right " aria-labelledby="navbarDropdown">
        <a class="dropdown-item" href="#">Configuración</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="LogOut">Log Out</a>
      </div>
    </li>
  </ul>
</nav>