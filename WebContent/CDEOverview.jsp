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
  <jsp:include page="views/cde_nav.jsp" />
  <div class="content">
    <section class="first container">
      <h4>Casos pendientes</h4>
      <hr>
      <table class="table table-striped table-responsive-sm casos-investigador">
        <thead class="thead-dark">
          <tr>
            <th scope="col" class="">Caso</th>
            <th scope="col" class="d-none d-sm-table-cell">Investigador</th>
            <th scope="col" class="">Subido</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Nombre del caso #1</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #1</td>
            <td class="">02/03/2018</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
          <tr>
            <td>Nombre del caso #2</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #2</td>
            <td class="">14/06/2018</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
          <tr>
            <td>Nombre del caso #3</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #3</td>
            <td class="">10/01/2019</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
          <tr>
            <td>Nombre del caso #4</td>
            <td class="d-none d-sm-table-cell">Nombre del investigador #4</td>
            <td class="">21/02/2019</td>
            <td class="open-case d-flex flex-row justify-content-end">
              <a href="/coe_proyecto_pen.html"><i class="material-icons">chevron_right</i></a>
            </td>
          </tr>
        </tbody>
      </table>
      <small>
        <div><i class="material-icons" style="font-size: 14pt;">chevron_right</i>&nbsp; Auto-asignar caso de investigación.</div>
      </small>
    </section>
    <jsp:include page="views/cde_footer.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
  <script src="${pageContext.request.contextPath}/js/coe.js"></script>
</body>

</html>
