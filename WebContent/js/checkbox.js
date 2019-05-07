$(document).ready(function () {
  $('#submitform').click(function () {
    checked = $("input[type=checkbox]:checked").length;

    if (!checked) {
      alert("Debes seleccionar al menos una especialidad.");
      return false;
    }
  });
});