<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <!-- META -->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="description" content="GDPR - ISST G22 | Mis casos">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

  <title>GDPR - ISST G22 | Nuevo Proyecto</title>
  <jsp:include page="views/styles.jsp" />
</head>

<body>
  <jsp:include page="views/nav_user.jsp" />
  <div class="content">
    <form class="container" action="EnviarFormulario" method="POST">
      <c:forEach items="${areas}" var="area">
        <div class="container">
          <h1>${area}</h1>
        </div>
        <br>
        <c:choose>
          <c:when test="${area == 'Personal' || area == 'Biomedica'}">
            <jsp:include page="views/form${area}.jsp" />
          </c:when>
          <c:otherwise>
            <div class="container">
              Esta plataforma sólo contempla aspectos que atañen al Reglamento General de Protección de Datos aprobado
              el 14
              de abril de 2016.
              Para aspectos de temática <b>${area}</b>, por favor consulte los formularios expuestos en la
              siguiente dirección: <a href="http://www.upm.es/Investigacion/soporte/ComiteEtica">UPM - Comité de
                ética</a>
            </div>
          </c:otherwise>
        </c:choose>
        <br>
      </c:forEach>
      <button class="btn btn-secondary submit">Continuar</button>
    </form>
    <br>
    <jsp:include page="views/footer_user.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
</body>

</html>