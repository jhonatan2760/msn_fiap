<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fiap chat</title>
	<script type='text/javascript' src='js/ckeditor/ckeditor.js' ></script>
	<script type='text/javascript' src='js/jquery-3.1.0.min.js'></script>
	<link href='css/site.css' rel='stylesheet'></link>
</head>
<body>
	<div class='mainContainer'>
		<div class='caixaMensagens'>
			
		</div>
		<div class='child'>
			<textarea id='texto'></textarea>
		</div>
		<div class='btnEnviar' id='sender'>
			<span>Enviar Mensagem</span>
		</div>
	</div>
</body>
<script type='text/javascript'>	
	jQuery(document).ready(function(event){
		var editor = CKEDITOR.replace('texto');
	});
	
	jQuery.getJSON('Send', {} , function(data){
		jQuery.each(data, function(index, value){
			console.log(value.mensagem);
			jQuery('.caixaMensagens').append('<div class=\'msg\'><span>'+ index + " - " + value.mensagem+' - '+value.data+'</span></div>');
		});
	});
function sendMensagem(){
	jQuery.ajax({
		url : 'Send',
		dataType : 'text/html',
		method : 'POST',
		data : {'Nick' : 'Web', 'mensagem' : CKEDITOR.instances.texto.getData()},
		succes : function(data){
			alert(data);
		}
	});
}	

jQuery('#sender').click(function(event){

	sendMensagem();

});
</script>
</html>