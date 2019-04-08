$(document).ready(() => {
  let selectOk = $("#coe-select-ok");
  let selectWarn = $("#coe-select-warn");
  let selectErr = $("#coe-select-err");
  let selectForm = $("#coe-select-form");

  selectOk.click(() => {
    selectForm.attr('action', 'coe_select_ok');
    selectForm.submit();
  });

  selectWarn.click(() => {
    selectForm.attr('action', 'coe_select_warn.html');
    selectForm.submit();
  });

  selectOk.click(() => {
    selectForm.attr('action', 'coe_select_err');
    selectForm.submit();
  });

  /**
   * Funciones destinadas al funcionamiento de los botones de detalles.
   * Por un lado el botón que añade detalle: autogenera el código para subir hasta 10 detalles
   * Por otro lado el botón que borra el detalle: elimina el código del detalle en cuestión, actualizando los índices
   * del resto de detalles; se actualizan los índices mayores al del borrado.
   * @type {jQuery}
   */
  let detallesAnadidos = $(".btn-del").length; // Por cada detalle añadido vamos a poner un botón de borrado.
  let detallesForm =$("#detalles-form");
  // Añadir detalle.
  $("#btn-add").click(function () {
    detallesAnadidos++;
    /**
     * Cada detalle lleva asociado:
     *      Input (+label) para nombre de detalle
     *      Input (+label) para valor de detalle
     *      Input (type: button) para quitar el detalle
     *      Div a modo de blank para rellenar la row
     */
    $(".last-detalle").after("<div class=\"col-2 detalle blank-" + (detallesAnadidos - 1) + "\"></div>\n" +
      "<div class=\"col-2 compDetalle align-self-end\">\n" +
      "<input type=\"button\" name=\"btn-del\" value=\"Quitar\" class=\"detalle btn btn-light btn-del\" data-valor=\"" + (detallesAnadidos - 1) + "\">\n" +
      "</div>\n" +
      "<div class=\"col-sm-3 col-md-2 compDetalle\">\n" +
      "<label for=\"\">Página referida</label>\n" +
      "<input type=\"number\" name=\"detalles[" + detallesAnadidos + "][pagina]\" id=\"detalles[" + detallesAnadidos + "][pagina]\" class=\"form-control detalle\">\n" +
      "</div>\n" +
      "<div class=\"col-sm-3 col-md-2 compDetalle\">\n" +
      "<label for=\"\">Párrafo referido</label>\n" +
      "<input type=\"number\" name=\"detalles[" + detallesAnadidos + "][parrafo]\" id=\"detalles[" + detallesAnadidos + "][parrafo]\" class=\"form-control detalle\">\n" +
      "</div>\n" +
      "<div class=\"col-sm-3 col-md-2 compDetalle\">\n" +
      "<label for=\"\">Artículo requerido</label>\n" +
      "<input type=\"number\" name=\"detalles[" + detallesAnadidos + "][articulo]\" id=\"detalles[" + detallesAnadidos + "][articulo]\" class=\"form-control detalle\">\n" +
      "</div>\n" +
      "<div class=\"col-sm-3 col-md-2 compDetalle last-detalle\">\n" +
      "<label for=\"\">Sección del artículo</label>\n" +
      "<input type=\"number\" name=\"detalles[" + detallesAnadidos + "][seccion]\" id=\"detalles[" + detallesAnadidos + "][seccion]\" class=\"form-control detalle\">\n" +
      "</div>\n");
    // Al que antes fuese el último detalle, le quitamos esa clase (sólo puede existir un último detalle)
    $(".last-detalle:first").removeClass("last-detalle");
  });

  // Borrado de detalle.
  $(document).on('click', '.btn-del', function () {
    /**
     * Cada detalle lleva asociado:
     *      Input (+label) para nombre de detalle. Contenidos en div padre.
     *      Input (+label) para valor de detalle Contenidos en div padre.
     *      Input (type: button) para quitar el detalle. Contenido en div padre.
     *      Div a modo de blank para rellenar la row
     * Habrá que borrar todos ellos.
     */
    let index = $(this).attr('data-valor'); // Sacamos del boton de borrado el índice en cuestión.
    $("#detalles\\[" + index + "\\]\\[pagina\\]").parent().remove();
    $("#detalles\\[" + index + "\\]\\[parrafo\\]").parent().remove();
    $("#detalles\\[" + index + "\\]\\[articulo\\]").parent().remove();
    $("#detalles\\[" + index + "\\]\\[seccion\\]").parent().remove();
    $(".blank-" + index).remove();
    $(this).parent().remove();

    // Sobreescribimos los indices actualizados.
    let detalle = $(".detalle");
    let size = detalle.length;
    detallesAnadidos--;
    let j = 0;
    for (let i = 0; i < size; i += 6) {
      detalle.eq(i).attr('id', 'detalles[' + j + '][pagina]');
      detalle.eq(i + 1).attr('id', 'detalles[' + j + '][parrafo]');
      detalle.eq(i + 2).attr('id', 'detalles[' + j + '][articulo]');
      detalle.eq(i + 3).attr('id', 'detalles[' + j + '][seccion]');
      detalle.eq(i).attr('name', 'detalles[' + j + '][pagina]');
      detalle.eq(i + 1).attr('name', 'detalles[' + j + '][parrafo]');
      detalle.eq(i + 2).attr('name', 'detalles[' + j + '][articulo]');
      detalle.eq(i + 3).attr('name', 'detalles[' + j + '][seccion]');
      detalle.eq(i + 4).attr('class', 'col-2 detalle blank-' + j);
      detalle.eq(i + 5).attr('data-valor', j);
      j++;
    }
  });
});