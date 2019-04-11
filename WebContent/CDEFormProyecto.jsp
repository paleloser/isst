<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="GDPR - ISST G22 | Revisión Proyecto">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

  <title>GDPR - ISST G22 | Revisión Proyecto</title>
  <jsp:include page="views/styles.jsp" />
</head>

<body>
  <jsp:include page="views/cde_nav.jsp" />
  <div class="content">
    <section class="first container">
      <c:forEach items="${areas}" var="area">
        <div class="container">
          <h1>${area}</h1>
        </div>
        <br>
        <jsp:include page="views/cde_form${area}.jsp" />
        <br>
      </c:forEach>
      <form class="container" action="ServirInvestigacionServlet" method="POST">
        <input type="text" name="titulo" value="${titulo}" hidden>
        <button class="btn btn-primary submit">Descargar Memoria</button>
        <br>
      </form>
      <form action="AprobarFormulario" class="container">
        <button class="btn btn-primary submit">Aprobar</button>
      </form>
      <form action="RevisarFormulario" class="container">
        <button class="btn btn-secondary submit">Solicitar Info</button>
      </form>
      <form action="DenegarFormulario" class="container">
        <button class="btn btn-danger submit">Denegar</button>
      </form>
    </section>
    <br>
    <jsp:include page="views/cde_footer.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
  <script src="${pageContext.request.contextPath}/js/coe.js"></script>
</body>

</html>