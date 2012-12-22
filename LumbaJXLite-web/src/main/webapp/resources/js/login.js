
$ = jQuery;
$(document).ready(function() {
    jQuery('.loginform button').hover(function(){
        jQuery(this).stop().switchClass('default','hover');
    },function(){
        jQuery(this).stop().switchClass('hover','default');
    });
	
    jQuery('#username, #password').keypress(function(){
        jQuery('.nopwd, .noaktif, .nouser').slideUp();
    });
}); 


function gagalPwd() {
    jQuery('.nopwd').slideDown();
}
function gagalAktif() {
    jQuery('.noaktif').slideDown();
}
function gagalUser() {
    jQuery('.nouser').slideDown();
}
