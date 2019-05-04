<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="GDPR - ISST G22 | Proyecto">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

  <title>GDPR - ISST G22 | Nombre Proyecto #</title>
  <jsp:include page="views/styles.jsp" />
</head>

<body id='body'>
  <jsp:include page="views/nav_user.jsp" />
  <div class="content">
    <section class="first container">
      <div class="row">
        <div class="col-sm-12 col-md-6">
          <h4>${sdao_id.titulo}</h4>
        </div>
        <div class="col-sm-12 col-md-6 d-flex justify-content-end">
          <c:if test="${sdao_id.estado == 1}">
            <h6><span class="badge badge-primary">En proceso</span></h6>
          </c:if>
          <c:if test="${sdao_id.estado == 2}">
            <h6><span class="badge badge-success">Aprobado</span></h6>
          </c:if>
          <c:if test="${sdao_id.estado == 3}">
            <h6><span class="badge badge-danger">Danger</span></h6>
          </c:if>
          <c:if test="${sdao_id.estado == 4}">
            <h6><span class="badge badge-warning">Se requiere info</span></h6>
          </c:if>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-sm-12 col-md-7">
          <div class="col-sm-12 d-flex justify-content-start align-items-start">
            <div class="card" style="height: fit-content; margin-bottom: 20px;">
              <div class="card-body">
                <h5 class="card-title d-flex text-truncate"><i
                    class="material-icons">attachment</i>&nbsp;fichero_original</h5>
                <div style="display: block;">
                  <small class="card-text text-monospace text-truncate" style="display: block;"><b>sha256:
                    </b>1ea14725149fb4fd462dddbc6f2bf9b7e2bfc7cd2691ca0c4d60635abd3ad926</small></div>
                <a href="#" class="card-link">Descargar</a>
              </div>
            </div>
          </div>
          <div class="col-sm-12 d-flex justify-content-start align-items-start">
            <div class="card" style="height: fit-content; margin-bottom: 20px;">
              <div class="card-body">
                <h5 class="card-title d-flex text-truncate"><i
                    class="material-icons">attachment</i>&nbsp;fichero_firmado</h5>
                <div style="display: block;">
                  <small class="card-text text-monospace text-truncate" style="display: block;"><b>sha256:
                    </b>4404f5b7a8836863b4bf63b9958024b6fc9074f0f0480ed8115e4168760e505e</small>
                </div>
                <a href="#" class="card-link">Descargar</a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-12 col-md-5">
          <blockquote class="blockquote text-right">
            <p class="text-justify text-sm cita">
              Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde natus laboriosam veniam nemo
              expedita consequatur iste a quibusdam ipsam aliquam voluptatibus praesentium culpa excepturi, sapiente
              atque sunt nobis error illum, molestias odio impedit at temporibus placeat. Nisi deserunt est non
              temporibus odio, vel, quidem architecto omnis quae quaerat minus ducimus!
            </p>
            <footer class="blockquote-footer"><b>COE</b></footer>
          </blockquote>
        </div>
      </div>
    </section>
    <section class="history container">
      <h6>Histórico</h6>
      <table class="table table-striped">
        <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Fecha</th>
            <th scope="col">Tipo</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>0</td>
            <td>01/02/2017</td>
            <td>Subido</td>
          </tr>
          <tr>
            <td>1</td>
            <td>02/02/2017</td>
            <td>Bajo estudio</td>
          </tr>
          <tr>
            <td>2</td>
            <td>04/02/2017</td>
            <td>Solicitud de info</td>
          </tr>
          <tr>
            <td>3</td>
            <td>04/02/2017</td>
            <td>Actualizado</td>
          </tr>
          <tr>
            <td>4</td>
            <td>06/02/2017</td>
            <td>Aprobado</td>
          </tr>
        </tbody>
      </table>
    </section>
    <br>
    <jsp:include page="views/footer_user.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
</body>

</html>