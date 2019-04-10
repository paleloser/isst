<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container">
  <h3>RECOGIDA Y PROTECCIÓN DE DATOS PERSONALES DE LOS PARTICIPANTES</h3>
  <hr>
  <div>
    <!-- RADIO BUTTON TEMPLATE -->
    <div class="row">
      <div class="col-sm-12 col-md-8">
        ¿Los datos de la investigación provienen de este proyecto?
      </div>
      <div class="col-sm-12 col-md-4">
        <c:if test="${personal0 == 'si'}">
          <div class="form-check form-check-inline">
            <input class="form-check-input" name="personal0" type="radio" checked disabled>
            <label class="form-check-label" for="personal">Sí</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" name="personal0" type="radio" disabled>
            <label class="form-check-label" for="personal">No</label>
          </div>
        </c:if>
        <c:if test="${personal0 == 'no'}">
          <div class="form-check form-check-inline">
            <input class="form-check-input" name="personal0" type="radio" disabled>
            <label class="form-check-label" for="personal">Sí</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" name="personal0" type="radio" checked disabled>
            <label class="form-check-label" for="personal">No</label>
          </div>
        </c:if>
      </div>
    </div>
    <br>
    <!-- TEXT INPUT / TEXTAREA TEMPLATE -->
    <div class="from-group">
      <label for="personal">Procedimiento de captación de las personas participantes:</label>
      <input type="text" class="form-control" name="personal2" placeholder="${personal2}" disabled>
    </div>
    <br>
    <!-- CHECKBOX TEMPLATE -->
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Se solicitará formalmente y por escrito el consentimiento a las personas participantes del trabajo de campo que
        formarán parte de la investigación.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal3}">
              <input class="form-check-input" type="checkbox" name="personal3" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal3" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Los participantes disponen de raciocinio para voluntariamente y libremente participar en el estudio.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal4}">
              <input class="form-check-input" type="checkbox" name="personal4" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal4" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Los sujetos participantes disponen de suficiente información sobre el estudio.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal5}">
              <input class="form-check-input" type="checkbox" name="personal5" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal5" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Explique los sistemas de información previstos para garantizar este hecho y si los participantes dispondrán de
        una
        hoja informativa en la que quede claramente indicada esta información.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal6}">
              <input class="form-check-input" type="checkbox" name="personal6" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal6" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Se les informará de que su participación es voluntaria y libre, así como de que pueden retirarse en todo
        momento,
        con la consecuente e inmediata eliminación de todos sus registros generados hasta ese momento.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal7}">
              <input class="form-check-input" type="checkbox" name="personal7" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal7" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Se les informará de los cambios que en el experimento supone su actividad académica y del esfuerzo que conlleva,
        así como de los posibles inconvenientes y/o beneficios de participar en la investigación.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal8}">
              <input class="form-check-input" type="checkbox" name="personal8" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal8" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Se dará a conocer el contacto del comité de Ética a todos los participantes
        (secretaria.adjunto.vinvestigacion@upm.es).
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal9}">
              <input class="form-check-input" type="checkbox" name="personal9" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal9" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        En el caso de investigación de entornos virtuales, se informará a los participantes de que su comunicación o
        comportamiento será registrado y será susceptible de análisis.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal10}">
              <input class="form-check-input" type="checkbox" name="personal10" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal10" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Se respetará la confidencialidad.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal11}">
              <input class="form-check-input" type="checkbox" name="personal11" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal11" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Se respetará el anonimato. La identidad no será relevada si no es bajo consentimiento explícito o bien en el
        caso
        de que los datos ya sean públicos, y se informará claramente a los participantes de cómo se respetará tal
        anonimato. Explicitar el procedimiento estipulado para salvaguardar el anonimato y la confidencialidad.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal12}">
              <input class="form-check-input" type="checkbox" name="personal12" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal12" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-sm-12 col-md-8">
        Una vez finalizado el proyecto está previsto informar de los resultados obtenidos a los participantes del mismo.
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="form-check form-check-inline">
          <c:choose>
            <c:when test="${not empty personal13}">
              <input class="form-check-input" type="checkbox" name="personal13" checked disabled>
            </c:when>
            <c:otherwise>
              <input class="form-check-input" type="checkbox" name="personal13" disabled>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <br>
  </div>
  <br>
  <h3>GESTIÓN Y CUSTODIA DE LOS DATOS RECOGIDOS.</h3>
  <hr>
  <!-- Input Field Template -->
  <div>
    <div class="from-group">
      <label for="titulo">
        ¿Está previsto un plan para el tratamiento, la custodia y la conservación de los datos recogidos
        en el trabajo de campo?</label>
      <input type="text" class="form-control" name="personal14" placeholder="${personal14}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Qué datos personales se colectan, almacenan y procesan?</label>
      <input type="text" class="form-control" name="personal15" placeholder="${personal15}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Se da de alta la existencia de dichos repositorios de datos personales en la Agencia Española
        de Protección de Datos?</label>
      <input type="text" class="form-control" name="personal16" placeholder="${personal16}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Cuándo se colectan los datos personales?</label>
      <input type="text" class="form-control" name="personal17" placeholder="${personal17}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿En qué formato se almacenan esos datos personales? (ficheros office, Excel, comprimidos
        ZIP/RAR, bases de datos, copias en papel, fotografías, registros multimedia, etc.)</label>
      <input type="text" class="form-control" name="personal18" placeholder="${personal18}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Se hacen copias de los ficheros conteniendo datos personales? ¿Cuántas copias se hacen y cómo
        se gestionan? ¿Cómo se detecta la perdida de alguna copia y como se reacciona ante ese hecho?</label>
      <input type="text" class="form-control" name="personal19" placeholder="${personal19}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿En qué lugar o lugares se almacenan los datos personales y cuáles son sus soportes físicos?
        (PC
        fijo o portátil, equipo off-line, servidor en red, repositorio en la nube, discos magnéticos removibles,
        memorias
        USBs, DVD/CDs, papel, etc.)</label>
      <input type="text" class="form-control" name="personal20" placeholder="${personal20}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Cómo se recuperan los datos? (acceso directo al ordenador, conexión remota, obtención de
        copias, etc.)</label>
      <input type="text" class="form-control" name="personal21" placeholder="${personal21}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Se pueden recuperar los datos personales a través de una red o a través de Internet?</label>
      <input type="text" class="form-control" name="personal22" placeholder="${personal22}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Dónde se ubican los servidores o repositorios que guardan los datos personales? (Intalaciones
        particulares, de la UPM, en España o en la Unión Europea, otros países)</label>
      <input type="text" class="form-control" name="personal23" placeholder="${personal23}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Cuándo se recuperan datos y para qué fin?</label>
      <input type="text" class="form-control" name="personal24" placeholder="${personal24}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Quién o quienes están autorizados a recuperar los datos y cómo demuestran que son los que
        pretenden ser? (tipos de usuarios, identificación, autenticación, contraseñas, tarjetas de identificación,
        biometría, registro de actividad en logs, etc.)</label>
      <input type="text" class="form-control" name="personal25" placeholder="${personal25}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Para qué se recuperan los datos personales y cómo se procesan?</label>
      <input type="text" class="form-control" name="personal26" placeholder="${personal26}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Los resultados que se obtiene de su procesado, pueden considerarse a su vez datos personales
        según la ley?</label>
      <input type="text" class="form-control" name="personal27" placeholder="${personal27}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Qué registros indelebles generan las operaciones de almacenamiento y recuperación? (sistema
        de
        log o bitácoras)</label>
      <input type="text" class="form-control" name="personal28" placeholder="${personal28}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Qué medidas anti-modificación tienen esos registros de actividad? ¿Qué impide que alguien
        pueda
        cambiarlos o impedir que se generen?</label>
      <input type="text" class="form-control" name="personal29" placeholder="${personal29}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Dónde y cómo se almacenan los registros de acceso a los datos personales?</label>
      <input type="text" class="form-control" name="personal30" placeholder="${personal30}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">Indicar con detalle cómo se hacen anónimos los datos personales recolectados o los derivados
        de
        ellos.</label>
      <input type="text" class="form-control" name="personal31" placeholder="${personal31}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Cómo se transportan los datos personales en su comunicación a los usuarios o servicios que
        los
        procesen?</label>
      <input type="text" class="form-control" name="personal32" placeholder="${personal32}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Cómo se identifican a los destinatarios de dichas transferencias?</label>
      <input type="text" class="form-control" name="personal33" placeholder="${personal33}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Qué medidas concretas se toman para evitar fugas de información?</label>
      <input type="text" class="form-control" name="personal34" placeholder="${personal34}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Si se utilizan repositorios de información conectados a Internet es necesario saber cómo se
        protege la confidencialidad de su contenido, su integridad y cómo se controla quién y cuándo accede a los
        mismos?
        (Dropbox, Google Drive, Amazon S3, Azure, iCloud, Box, etc.)</label>
      <input type="text" class="form-control" name="personal35" placeholder="${personal35}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Qué operaciones de salvaguardia (backup) se realizan y cómo se protege la integridad y
        confidencialidad de esas copias de seguridad?</label>
      <input type="text" class="form-control" name="personal36" placeholder="${personal36}" disabled>
    </div>
    <br>
    <div class="from-group">
      <label for="titulo">¿Cómo se destruyen las copias con datos personales cuando dejan de ser necesarias o se termina
        el proyecto? ¿Cómo se asegura la destrucción de todas las copias?</label>
      <input type="text" class="form-control" name="personal37" placeholder="${personal37}" disabled>
    </div>
  </div>
</div>