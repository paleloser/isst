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
      <h6><span class="badge badge-warning">Faltan datos</span></h6>
    </div>
  </div>
  <hr>
  <div class="row">
    <div class="col-sm-12 col-md-5 justify-content-start align-items-start">
      <div class="col-sm-12 d-flex justify-content-center align-items-center">
        <div class="card" style="height: fit-content; margin-bottom: 20px;">
          <div class="card-body">
            <h5 class="card-title d-flex text-truncate"><i class="material-icons">attachment</i>&nbsp;Memoria Original
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
      <div class="col-sm-12 d-flex justify-content-center align-items-center flex-wrap">
        <form action="NuevaMemoriaServlet" method="POST" enctype="multipart/form-data">
          <input type="text" name="titulo" id="titulo" value="${sdao_id.titulo}" hidden>
          <div class="row align-items-center justify-content-center">
            <h6>Subir memoria del proyecto</h6>
          </div>
          <div class="row align-items-center justify-content-center">
            <div class="form-group flex-column justify-content-center align-items-center">
              <input type="file" name="file" id="file" class="inputfile" required />
              <label for="file">
                <i class="material-icons">
                  cloud_upload
                </i>
              </label>
              <small>Formatos admitidos: pdf, txt, zip, tar, gz, doc, docx</small>
              <button class="btn btn-secondary submit" type="submit">Continuar</button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <div class="col-sm-12 col-md-7">
      <c:forEach items="${anotaciones}" var="anotacion">
        <c:if test="${not anotacion.atendida}">
          <p class="alert alert-warning text-justify">${anotacion.contenido}</p>
        </c:if>
      </c:forEach>
    </div>
  </div>
</section>