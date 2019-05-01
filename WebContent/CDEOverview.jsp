<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="GDPR - ISST G22 | Mis casos">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
  <title>GDPR - ISST G22 | Mis casos</title>
  <link href="https://fonts.googleapis.com/css?family=Montserrat|Roboto|Playfair+Display|Roboto+Slab:100,300"
    rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
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
        <a class="nav-link sliding-link" href="#body"><b>Casos pendientes</b></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/coe_personal.html">Mis casos</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
          <img src="img/coe.png" height="40px" style="border-radius: 100%;">
        </a>
        <div class="dropdown-menu dropdown-menu-right " aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Configuración</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/index.html">Log Out</a>
        </div>
      </li>
    </ul>
  </nav>
  <div class="content">
    <section class="first container">
      <h4>Casos pendientes</h4>
      <hr>
      <table class="table table-striped table-responsive-sm casos-investigador">
        <thead class="thead-dark">
          <tr>
            <th scope="col" class="">Caso</th>
            <th scope="col" class="d-none d-sm-table-cell">Investigador</th>
            <th scope="col" class="">Subido</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Nombre del caso #1</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #1</td>
            <td class="">02/03/2018</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
          <tr>
            <td>Nombre del caso #2</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #2</td>
            <td class="">14/06/2018</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
          <tr>
            <td>Nombre del caso #3</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #3</td>
            <td class="">10/01/2019</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
          <tr>
            <td>Nombre del caso #4</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #4</td>
            <td class="">21/02/2019</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
        </tbody>
      </table>
      <small>
        <div><i class="material-icons" style="font-size: 14pt;">chevron_right</i>&nbsp; Auto-asignar caso de investigación.</div>
      </small>
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
                <a class="link sliding-link" href="#body">Mis Casos</a>
                |<a class="link" href="#">Configuración</a>
                |<a class="link" href="/index.html">Log Out</a>
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
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script src="js/script.js"></script>
</body>

</html>
