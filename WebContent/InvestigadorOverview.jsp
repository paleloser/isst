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
  <jsp:include page="views/styles.jsp" />
</head>
<body id='body'>
  <jsp:include page="views/nav_user.jsp" />
  <div class="content">
    <section class="first container">
      <table class="table table-striped table-responsive-sm casos-investigador">
        <thead class="thead-dark">
          <tr>
            <th scope="col" class="">Nombre</th>
            <th scope="col" class="d-none d-sm-table-cell">Subido</th>
            <th scope="col">Estado</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${solicitudes}" var="sol">
        	<tr>
        		<td>${sol.titulo}</td>
        		<td class="d-none d-sm-table-cell">${sol.fecha}</td>
        		<c:if test="${sol.estado == 1}">
        				<td class="text-primary">
							En proceso
						</td>
					</c:if>
					<c:if test="${sol.estado == 2}">
						<td class="text-success">
							Aprobado
							</td>
					</c:if>
					<c:if test="${sol.estado == 3}">
						<td class="text-danger">
							Denegado
							</td>
					</c:if>
					<c:if test="${sol.estado == 4}">
						<td class="text-warning">
							Se requiere más información
							</td>
					</c:if>
        		<td class="open-case">
        			<form method="post" action="SERVLETQUEMUESTRASOLICITUD">
        				<input type="hidden" name="solicitud" value="${sol.titulo}"/>
              			<button type="submit"><i class="material-icons">chevron_right</i></button>
              		</form></td>
        	</tr>
        </c:forEach>
        </tbody>
      </table>
    </section>
    <jsp:include page="views/footer_user.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
</body>

</html>