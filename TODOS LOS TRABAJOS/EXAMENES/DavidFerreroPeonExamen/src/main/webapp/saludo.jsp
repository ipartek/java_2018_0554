<%@ include file="../includes/cabecera.jsp" %>
 
<head>

<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
<link href="signin.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.css" rel="stylesheet">
<title>Saludo</title>	
</head>


<main class="container">
<form action="saludo" method="post" class="form-signin">
	<fieldset>
		<legend>Introduce tus datos para saludo</legend>
		<p>Todos los campos con * son obligatorios</p>	 
	 	<p>
			<label for="nombre"><strong>*Nombre</strong></label>
			<input type="text" name="nombre" id="nombre" class="form-control"  />
		</p>
		<p>
			<label for="apellido1"><strong>*Apellido1</strong></label>
			<input type="text" name="apellido1" id="apellido1" class="form-control"  />
		</p>
		<p>
			<label for="apellido2"><strong>*Apellido2</strong></label>
			<input type="text" name="apellido2" id="apellido2" class="form-control"  />
		</p>
		<p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</p>
</main>		
		
		