$(document).ready(() => {
  // Password eye view toggler
  const togglePasswd = $("#togglePasswd");
  const passwdInput = $("#passwd");
  let showingPasswd = false;
  togglePasswd.click(() => {
    if (passwdInput.val().length == 0) return;
    if (!showingPasswd) {
      togglePasswd.text('visibility_off');
      passwdInput.attr('type', 'text');
      passwdInput.css('letter-spacing', '2px');
    } else {
      togglePasswd.text('visibility');
      passwdInput.attr('type', 'password');
      passwdInput.css('letter-spacing', '6px');
    }
    showingPasswd = !showingPasswd;
  });
  passwdInput.keydown(() => {
    passwdInput.val().length <= 1 ? passwdInput.css('letter-spacing', '1px') : passwdInput.css('letter-spacing', '6px');
  });
  // Nice scrolling :)
  $(".sliding-link").click(function(e) {
    e.preventDefault();
    let aid = $(this).attr("href");
    $('html,body').animate({scrollTop: $(aid).offset().top}, 'slow', 'swing');
  });
});