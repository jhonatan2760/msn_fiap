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
			return false;
	<%}else{%>
	</script>
	<script type='text/javascript' src='js/ckeditor/ckeditor.js' ></script>
	<script type='text/javascript' src='js/jquery-3.1.0.min.js'></script>
	<script type='text/javascript' src='js/jquery-ui.min.js'></script>
	<link href='css/site.css' rel='stylesheet'></link>
	<link href='css/jquery-ui.min.css' rel='stylesheet'></link>
	<link href='css/jquery-ui.structure.css' rel='stylesheet'></link>
	<link href='css/jquery-ui.theme.css' rel='stylesheet'></link>
</head>
<body id='full'>
	<div class='mainContainer'>
		<div class='usuarios'>
			<div class='topUsers'>
				<img src='img/ende.png' />
				<span id='users'> Usuários:</span> <img class='logout' src='img/logout-icon.png' />
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
// 			ex.printStackTrace();
		}
	%>
	
	
	jQuery(document).ready(function(event){
		var editor = CKEDITOR.replace('texto');
		getMessages();
		startLoadMessage();
	});
	
function getMessages(){
	jQuery.getJSON('Send', {} , function(data){
		console.log('Consulta de mensagens');
		jQuery.each(data, function(index, value){
			jQuery('.caixaMensagens').append("<div class='msg'><p><b>"+value.user.nick+"</b></p><span class='msgbody'>"+ value.mensagem+"<img src='"+ value.user.avatar +"' /> <span class='calendar' >"+value.data+"</span></span></div>");
		});
		rolarTela();
		setListener();
	});
}
	
	function rolarTela(){
		jQuery('.caixaMensagens').animate({ scrollTop : jQuery('.caixaMensagens').prop('scrollHeight')}, 600);
	}
	
	jQuery.getJSON('UserHandler', {}, function(data){
		console.log(data);
		
		
		jQuery.each(data, function(index, value){
			jQuery('.usuarios').append("<div class='user hidden'><img class='avatar' src='"+value.avatar+"' /><b class='nickName' >"+value.usuario+"</b></div>");
		});
		
		jQuery('.user').fadeIn(600);
	});
	
	jQuery('.logout').click(function(event){
		logout();
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

function logout(){
	console.log('in');
	jQuery.ajax({
		url : 'Logout',
		dataType : 'text/html',
		method : 'POST',
		data : {logout : true},
		succes : function(data){
			
		}
	});
	
	window.location.href = 'login.jsp';
}

function startLoadMessage(){

setInterval(function(){
console.log('update');
	getMessages();
},300000);

}
jQuery('#sender').click(function(event){
	sendMensagem();
	hiddeMessages();
	getMessages();
	showMessages();
});

function showMessages(){
	jQuery('.user').fadeIn(600);
}

function hiddeMessages(){
	jQuery('.caixaMensagens .msg').fadeOut(300).remove();
}

function setListener(){
	jQuery('p').on('click', function(event){

		jQuery(this).parent().dialog();
	
	});
}
</script>
<%}	 %>
</html>