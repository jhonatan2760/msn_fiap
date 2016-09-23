<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login CHATROPE</title>
<script type='text/javascript' src='js/ckeditor/ckeditor.js' ></script>
<script type='text/javascript' src='js/jquery-3.1.0.min.js'></script>
<link href='css/site.css' rel='stylesheet'></link>
</head>
<body id='full' >

<div id='containerLogo'>
		<div id='logo'>
			<img src='img/chatamizade.png' />
			<span id='legend'>Chatrope</span>
		</div>
	</div>
<form id='cad' name='cad' action='Login' method='post' >
	<div>
		<input class='redondo' type='text' name='login' placeholder='login'/>
	</div>
	<div>
		<input class='redondo' type='password' name='password' placeholder='senha'/>
	</div>
</form>

<div id='salvar'>
	<div id='save'>
		<span>Logar</span>
	</div>
	<div id='cadastro' >
		<span>Cadastrar-se</span>
	</div>
</div>
</body>
<script type="text/javascript">
	<%
	 if(request.getParameter("type") != null && request.getParameter("type").equals("err")){
	%>
		alert('Login/Senha incorreto(s)');
	<%}%>
jQuery('#save').click(function(event){
	event.preventDefault();
	jQuery('#cad').submit();

});

jQuery('#cadastro').click(function(event){
	window.location.href = 'cadastro.jsp';
});

</script>
</html>