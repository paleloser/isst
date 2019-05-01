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
            <th scope="col" class="d-none d-sm-table-cell">Actualizado</th>
            <th scope="col">Estado</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Nombre del caso #1</td>
            <td class="d-none d-sm-table-cell">01/02/2017</td>
            <td class="d-none d-sm-table-cell">06/02/2017</td>
            <td class="text-success">Aprobado</td>
            <td class="open-case"><a href="/proyecto_ok.html"><i class="material-icons">chevron_right</i></a></td>
          </tr>
          <tr>
            <td>Nombre del caso #2</td>
            <td class="d-none d-sm-table-cell">02/03/2018</td>
            <td class="d-none d-sm-table-cell">07/03/2018</td>
            <td class="text-primary">En proceso</td>
            <td class="open-case"><a href="/proyecto_in.html"><i class="material-icons">chevron_right</i></a></td>
          </tr>
          <tr>
            <td>Nombre del caso #3</td>
            <td class="d-none d-sm-table-cell">14/06/2018</td>
            <td class="d-none d-sm-table-cell">19/06/2018</td>
            <td class="text-warning">Falta de datos</td>
            <td class="open-case"><a href="/proyecto_warn.html"><i class="material-icons">chevron_right</i></a></td>
          </tr>
          <tr>
            <td>Nombre del caso #4</td>
            <td class="d-none d-sm-table-cell">10/01/2019</td>
            <td class="d-none d-sm-table-cell">15/01/2019</td>
            <td class="text-danger">Denegado</td>
            <td class="open-case"><a href="/proyecto_err.html"><i class="material-icons">chevron_right</i></a></td>
          </tr>
          <tr>
            <td>Nombre del caso #5</td>
            <td class="d-none d-sm-table-cell">21/02/2019</td>
            <td class="d-none d-sm-table-cell">-</td>
            <td class="text-secondary">Pendiente</td>
            <td class="open-case"><a href="/proyecto_pen.html"><i class="material-icons">chevron_right</i></a></td>
          </tr>
        </tbody>
      </table>
    </section>
    <jsp:include page="views/footer_user.jsp" />
  </div>
  <jsp:include page="views/scripts.jsp" />
</body>

</html>