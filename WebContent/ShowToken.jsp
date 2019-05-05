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
  <title>GDPR - ISST G22 | Generar Token</title>
  <jsp:include page="views/styles.jsp" />
</head>

<body id='body'>
  <jsp:include page="views/cde_nav.jsp" />
  <div class="content">
    <section class="first container">
      <h4>Token</h4>
      <hr>
      <p>${token}</p>
      <hr>
      <p class="text.justify"
        >En caso de que el token se haya generado correctamente, la url para poder registrarse como miembro del Comité de Ética de la página web será:
        <a href="#">http://www.gdpr.es/RegistroCDE?t=&lt;token&gt;</a>
      </p>
    </section>
    <jsp:include page="views/cde_footer.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
  <script src="${pageContext.request.contextPath}/js/coe.js"></script>
</body>

</html>
