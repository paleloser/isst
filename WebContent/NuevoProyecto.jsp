<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="areaForm" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="GDPR - ISST G22 | Mis casos">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
  <title>GDPR - ISST G22 | Nuevo Proyecto</title>
  <link href="https://fonts.googleapis.com/css?family=Montserrat|Roboto|Playfair+Display|Roboto+Slab:100,300"
    rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>

<body>
  <shiro:lacksRole name="investigador">
    No tienes permiso para ver el contenido de esta página
    <div class="content">
      <footer class="footer content-center">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 col-md-4 content-center item">
              <div class="row">
                <div class="col-12 content-center">
                  <a class="title">GDPR</a>
                </div>
                <div class="col-12 content-center justify-content-between">
                  <a class="link" href="/">Index</a>
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
  </shiro:lacksRole>
  <shiro:hasRole name="investigador">
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
            <% if ( img != null ) { %>
            <img src="img/<%= img %>" height="40px" style="border-radius: 100%;">
            <% } else { %>
            <img src="img/profile.jpg" height="40px" style="border-radius: 100%;">
            <% } %>
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
      <section class="first container">
        <h3>Subir proyecto para validación</h3>
        <hr>
        <form class="container" action="/SelectAreas">
          <!-- Info Principal del Proyecto (común para todas las areas) -->
          <div class="from-group">
            <label for="titulo">Título</label>
            <input type="text" class="form-control" name="titulo" required>
          </div>
          <div class="form-group">
            <label for="titulo">Fecha inicio/fin</label>
            <input type="date" class="form-control" name="fecha" required>
          </div>
          <!-- Areas del Proyecto -->
          <br>
          <h6>Áreas del proyecto de investigación</h6>
          <hr>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              Protección de datos personales
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="personal" type="radio" value="si">
                <label class="form-check-label" for="personal">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="personal" type="radio" value="no">
                <label class="form-check-label" for="personal">No</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="personal" type="radio" value="ns" checked>
                <label class="form-check-label" for="personal">No se</label>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              Investigación biomédica con humanos o con muestras de origen humano
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="biomedica" type="radio" value="si">
                <label class="form-check-label" for="biomedica">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="biomedica" type="radio" value="no">
                <label class="form-check-label" for="biomedica">No</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="biomedica" type="radio" value="ns" checked>
                <label class="form-check-label" for="biomedica">No se</label>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              Investigación con animales
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="animales" type="radio" value="si">
                <label class="form-check-label" for="animales">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="animales" type="radio" value="no">
                <label class="form-check-label" for="animales">No</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="animales" type="radio" id="checkbox-idk" value="ns" checked>
                <label class="form-check-label" for="animales">No se</label>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              Investigación con agentes químicos
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="quimicos" type="radio" value="si">
                <label class="form-check-label" for="quimicos">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="quimicos" type="radio" value="no">
                <label class="form-check-label" for="quimicos">No</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="quimicos" type="radio" id="checkbox-idk" value="ns" checked>
                <label class="form-check-label" for="quimicos">No se</label>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              Investigación con organismo modificados genéticamente
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="genetica" type="radio" value="si">
                <label class="form-check-label" for="genetica">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="genetica" type="radio" value="no">
                <label class="form-check-label" for="genetica">No</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="genetica" type="radio" id="checkbox-idk" value="ns" checked>
                <label class="form-check-label" for="genetica">No se</label>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              Investigación con sustancias radiactivas
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="radiactiva" type="radio" value="si">
                <label class="form-check-label" for="radiactiva">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="radiactiva" type="radio" value="no">
                <label class="form-check-label" for="radiactiva">No</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="radiactiva" type="radio" id="checkbox-idk" value="ns" checked>
                <label class="form-check-label" for="radiactiva">No se</label>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              Riesgos medioambientales
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="medioambiental" type="radio" value="si">
                <label class="form-check-label" for="medioambiental">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="medioambiental" type="radio" value="no">
                <label class="form-check-label" for="medioambiental">No</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="medioambiental" type="radio" id="checkbox-idk" value="ns" checked>
                <label class="form-check-label" for="medioambiental">No se</label>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-12 col-md-8">
              ¿El proyecto contiene otro tipo de datos que considera necesario revisar?
            </div>
            <div class="col-sm-12 col-md-4">
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="otro" type="radio" value="si">
                <label class="form-check-label" for="otro">Sí</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" name="otro" type="radio" value="no" checked>
                <label class="form-check-label" for="otro">No</label>
              </div>
            </div>
          </div>
          <div class="form-check form-check-inline" style="margin: 10px 0;">
            <textarea name="other" id="nuevo-proy-textarea" cols="2000" rows="2" style="width: 100%; padding: 5px;"
              placeholder="Indique cuál/es (en caso de haber marcado 'Sí')"></textarea>
          </div>
          <button class="btn btn-secondary submit">Continuar</button>
        </form>
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
                  <a class="link" href="/Proyectos">Mis Casos</a>
                  |<a class="link" href="/Configuracion">Configuración</a>
                  |<a class="link" href="/LogOut">Log Out</a>
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
  </shiro:hasRole>
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script src="js/script.js"></script>
</body>

</html>