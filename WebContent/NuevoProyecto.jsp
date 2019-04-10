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
  <meta name="description" content="GDPR - ISST G22 | Mis casos">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
  <title>GDPR - ISST G22 | Nuevo Proyecto</title>
  <jsp:include page="views/styles.jsp" />
</head>

<body>
  <!-- TODO: implement roles -->
  <jsp:include page="views/nav_user.jsp" />
  <div class="content">
    <section class="first container">
      <h3>Nuevo proyecto para validación</h3>
      <hr>
      <form class="container" action="FormServlet" method="POST">
        <!-- Info Principal del Proyecto (común para todas las areas) -->
        <div class="from-group">
          <label for="titulo">Título</label>
          <input type="text" class="form-control" name="titulo" required>
        </div>
        <br>
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
              <input class="form-check-input" name="personal" type="radio" value="no"  checked>
              <label class="form-check-label" for="personal">No</label>
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
              <input class="form-check-input" name="biomedica" type="radio" value="no"  checked>
              <label class="form-check-label" for="biomedica">No</label>
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
              <input class="form-check-input" name="animales" type="radio" value="no"  checked>
              <label class="form-check-label" for="animales">No</label>
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
              <input class="form-check-input" name="quimicos" type="radio" value="no"  checked>
              <label class="form-check-label" for="quimicos">No</label>
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
              <input class="form-check-input" name="genetica" type="radio" value="no"  checked>
              <label class="form-check-label" for="genetica">No</label>
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
              <input class="form-check-input" name="radiactiva" type="radio" value="no"  checked>
              <label class="form-check-label" for="radiactiva">No</label>
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
              <input class="form-check-input" name="medioambiental" type="radio" value="no"  checked>
              <label class="form-check-label" for="medioambiental">No</label>
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
    <jsp:include page="views/footer_user.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
</body>

</html>