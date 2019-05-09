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

  <title>GDPR - ISST G22 | ${sdao_id.titulo}</title>
  <jsp:include page="views/styles.jsp" />
</head>

<body id='body'>
  <jsp:include page="views/nav_user.jsp" />
  <div class="content">
    <c:if test="${sdao_id.estado == 1}">
      <jsp:include page="views/proyecto_in.jsp" />
    </c:if>
    <c:if test="${sdao_id.estado == 2}">
      <jsp:include page="views/proyecto_ok.jsp" />
    </c:if>
    <c:if test="${sdao_id.estado == 3}">
      <jsp:include page="views/proyecto_err.jsp" />
    </c:if>
    <c:if test="${sdao_id.estado == 4}">
      <jsp:include page="views/proyecto_warn.jsp" />
    </c:if>
    <c:if test="${not empty notificaciones}">
      <section class="history container">
        <h6>Histórico de actividad</h6>
        <table class="table table-striped">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Fecha</th>
              <th scope="col">Tipo</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${notificaciones}" var="notificacion" varStatus="i">
              <tr>
                <td>${i.index}</td>
                <td>${notificacion.date}</td>
                <td>${notificacion.tipo}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </section>
    </c:if>
    <br>
    <jsp:include page="views/footer_user.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
</body>

</html>