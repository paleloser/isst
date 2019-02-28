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
  $(".sliding-link").click(function (e) {
    e.preventDefault();
    let aid = $(this).attr("href");
    if (aid.indexOf("/") != -1) return;
    $('html,body').animate({ scrollTop: $(aid).offset().top }, 'slow', 'swing');
  });

  // Add slideDown animation to Bootstrap dropdown when expanding.
  $('.dropdown').on('show.bs.dropdown', function () {
    $(this).find('.dropdown-menu').first().stop(true, true).slideDown();
  });
  // Add slideUp animation to Bootstrap dropdown when collapsing.
  $('.dropdown').on('hide.bs.dropdown', function () {
    $(this).find('.dropdown-menu').first().stop(true, true).slideUp();
  });

  const header = $('nav');
  const range = 250;

  $(window).on('scroll', function () {

    let scroll = $(this).scrollTop();
    let height = header.outerHeight() / 2;
    let i = scroll*2 / (range + height);
    let bgColor = (scroll > (range + height) || i > 1) ? `rgba(242,242,242, 1)`: (scroll < height) ? `rgba(242,242,242, .0)` : `rgba(242,242,242, ${i})`;
    i *= 0.2;
    let shadow = (scroll > (range + height) || i > 0.2) ? `2px 2px 10px rgba(100,100,100, .2)`: (scroll < height) ? `2px 2px 10px rgba(100,100,100, .0)` : `2px 2px 10px rgba(100,100,100, ${i})`;
    header.css('background-color', bgColor);
    header.css('box-shadow', shadow);
    console.log(`Scroll: ${scroll}`)
    console.log(`Color: ${bgColor}`);
  });
});