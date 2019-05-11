<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<section class="first container">
  <div class="row">
    <div class="col-sm-12 col-md-6">
      <h4>${sdao_id.titulo}</h4>
    </div>
    <div class="col-sm-12 col-md-6 d-flex justify-content-end">
      <h6><span class="badge badge-success">Aprobado</span></h6>
    </div>
  </div>
  <hr>
  <div class="row">
    <div class="col-sm-12 col-md-7">
      <div class="col-sm-12 d-flex justify-content-start align-items-start">
        <div class="card" style="height: fit-content; margin-bottom: 20px;">
          <div class="card-body">
            <h5 class="card-title d-flex text-truncate"><i class="material-icons">attachment</i>&nbsp;Memoria Evaluada
            </h5>
            <div style="display: block;">
              <small class="card-text text-monospace text-truncate" style="display: block;">
                <b>sha256: </b>${sdao_id.hmac}
              </small>
            </div>
            <hr>
            <form class="container" action="ServirInvestigacionServlet" method="POST" target="_blank">
              <input type="text" name="titulo" value="${sdao_id.titulo}" hidden>
              <button class="btn card-link">Descargar Memoria</button>
              <br>
            </form>
          </div>
        </div>
      </div>
      <div class="col-sm-12 d-flex justify-content-start align-items-start">
        <div class="card" style="height: fit-content; margin-bottom: 20px;">
          <div class="card-body">
            <h5 class="card-title d-flex text-truncate"><i class="material-icons">attachment</i>&nbsp;Certificado
            </h5>
            <div style="display: block;" hidden>
              <small class="card-text text-monospace text-truncate" style="display: block;">
                <b>sha256: </b>4404f5b7a8836863b4bf63b9958024b6fc9074f0f0480ed8115e4168760e505e
              </small>
            </div>
            <form class="container" action="ServirCertificadoServlet" method="POST" target="_blank">
              <input type="text" name="titulo" value="${sdao_id.titulo}" hidden>
              <button class="btn card-link">Descargar Certificado</button>
              <br>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="col-sm-12 col-md-5">
      <blockquote class="blockquote text-right">
        <p class="text-justify text-sm cita">
          El Comité de Ética de la Universidad Politécnica de Madrid determina que la investigación con título
          ${sdao_id.titulo} y su memoria, cumplen con los requisitos establecidos por el Reglamento General de 
          Protección de Datos (RGPD) y es apta para su publicación, conforme a la revisión del 14 de Abril de 
          2016.
        </p>
        <footer class="blockquote-footer"><b>COE</b></footer>
      </blockquote>
    </div>
  </div>
</section>