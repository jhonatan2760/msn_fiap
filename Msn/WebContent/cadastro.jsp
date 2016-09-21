<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
<script type='text/javascript' src='js/ckeditor/ckeditor.js' ></script>
<script type='text/javascript' src='js/jquery-3.1.0.min.js'></script>
<link href='css/site.css' rel='stylesheet'></link>
</head>
<body id='full'>
	<div id='containerLogo'>
		<div id='logo'>
			<img src='img/chatamizade.png' />
			<span id='legend'>Chatrope</span>
		</div>
	</div>
<form id='cad' name='cad' action='cadastro.do' method='post' >
	<div>
		<input class='redondo' type='text' name='usuario' placeholder='login'/>
	</div>
	<div>
		<input class='redondo' type='text' name='nick' placeholder='Apelido'/>
	</div>
	<div>
		<input class='redondo' type='password' name='senha' placeholder='Senha'/>
	</div>

	<div class='cornColor' >
		<span class='fontPattern'>Selecione seu avatar:</span>
	</div>
	<input type='hidden' name='avatar' value='' />
</form>	
	<div id='avatar'>
		<img class='avatarImg' src='img/avatar/Artie Ziff.png' />
		<img class='avatarImg' src='img/avatar/Bart.png' />
		<img class='avatarImg' src='img/avatar/Bartina.png' />
		<img class='avatarImg' src='img/avatar/Bartman.png' />
		<img class='avatarImg' src='img/avatar/Barto Picasso.png' />
		<img class='avatarImg' src='img/avatar/Blinky.png' />
		<img class='avatarImg' src='img/avatar/Bob Hope.png' />
		<img class='avatarImg' src='img/avatar/Caveman.png' />
		<img class='avatarImg' src='img/avatar/Chef Bart.png' />
		<img class='avatarImg' src='img/avatar/Cool Bart.png' />
		<img class='avatarImg' src='img/avatar/Duff beer.png' />
		<img class='avatarImg' src='img/avatar/French Bart.png' />
		<img class='avatarImg' src='img/avatar/Herb Powell.png' />
		<img class='avatarImg' src='img/avatar/Homer.png' />
		<img class='avatarImg' src='img/avatar/Herman.png' />
		<img class='avatarImg' src='img/avatar/Lisa.png' />
		<img class='avatarImg' src='img/avatar/Marge.png' />
		<img class='avatarImg' src='img/avatar/Ms Melan.png' />
		<img class='avatarImg' src='img/avatar/Nuclear plant.png' />
		<img class='avatarImg' src='img/avatar/Snake.png' />
		<img class='avatarImg' src='img/avatar/Space Mutant.png' />
	</div>

	<div id='salvar'>
		<div>
			<span>Cadastrar</span>
		</div>
	</div>
	
	<script type='text/javascript'>
		jQuery('#salvar').click(function(event){
// 			alert('Clicou!');
			jQuery('#cad').submit();
		});
		
		jQuery('#avatar img').click(function(event){
			jQuery(this).toggleClass('avatarImgSelecionado');
			jQuery('input[name=avatar]').val(jQuery(this).attr('src'));
		});
	</script>
</body>
</html>