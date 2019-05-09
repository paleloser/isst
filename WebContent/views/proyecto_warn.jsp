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
            <div style="display: block;" hidden>
              <small class="card-text text-monospace text-truncate" style="display: block;">
                <b>sha256: </b>7349a876ddf6f1d6fb44146e0d1a826c9fabfcf8e96b48d0619d1c83cc6ad6bf
              </small>
            </div>
            <a href="#" class="card-link">Descargar Memoria</a>
          </div>
        </div>
      </div>
      <div class="col-sm-12 d-flex justify-content-center align-items-center">
        <h6>Subir memoria del proyecto</h6>
        <div class="form-group flex-column">
          <input type="file" name="file" id="file" class="inputfile" required />
          <label for="file">
            <i class="material-icons">
              cloud_upload
            </i>
          </label>
          <small>Formatos admitidos: pdf, txt, zip, tar, gz, doc, docx</small>
        </div>
      </div>
    </div>
    <div class="col-sm-12 col-md-7">
      <c:forEach items="${anotaciones}" var="anotacion">
        <c:if test="${not anotacion.atendida}">
          <p class="alert alert-danger text-justify">${anotacion}</p>
        </c:if>
      </c:forEach>
    </div>
  </div>
</section>