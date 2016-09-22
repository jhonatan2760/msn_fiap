<%@page import="br.com.jhonatan2760.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHATROPE</title>
	<script type='text/javascript'>
	<%
		if(request.getSession().getAttribute("login") == null){
	%>
			window.location.href = 'login.jsp';
	<%}%>
	</script>
	<script type='text/javascript' src='js/ckeditor/ckeditor.js' ></script>
	<script type='text/javascript' src='js/jquery-3.1.0.min.js'></script>
	<link href='css/site.css' rel='stylesheet'></link>
</head>
<body id='full'>
	<div class='mainContainer'>
		<div class='usuarios'>
			<div class='topUsers'>
				<img src='img/ende.png' />
				<span id='users'> Usuários:</span>
			</div>
		</div>
		<div class='caixaMensagens'>
			
		</div>
		<div class='child'>
			<textarea id='texto'></textarea>
		</div>
		<div class='btnEnviar' id='sender'>
			<span>Enviar</span>
		</div>
	</div>
</body>
<script type='text/javascript'>	

	<%
		try{		
			Usuario user = (Usuario) request.getAttribute("logado");
			System.out.println(" nick : "+user.getNick());
			%>
<%-- 			alert('<%= user.getNick() %>'); --%>
	<%
		}catch(Exception ex){
			ex.printStackTrace();
		}
	%>
	jQuery(document).ready(function(event){
		var editor = CKEDITOR.replace('texto');
	});
	
	jQuery.getJSON('Send', {} , function(data){
		jQuery.each(data, function(index, value){
			console.log(value.user);
			jQuery('.caixaMensagens').append("<div class='msg'><p><b>"+value.user.nick+"</b></p><span class='msgbody'>"+ value.mensagem+"<img src='"+ value.user.avatar +"' /> <span class='calendar' >"+value.data+"</span></span></div>");
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