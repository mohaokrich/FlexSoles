window.onload = inicio;

function inicio(){
	$('#login').on('shown.bs.modal', function () {
	  $('#login').trigger('focus')
	})
}