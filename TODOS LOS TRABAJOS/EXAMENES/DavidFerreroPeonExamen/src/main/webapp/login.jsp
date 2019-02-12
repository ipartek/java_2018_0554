<!-- IDIOMAS -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="idioma" value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}" scope="session" /> <!--  CREAR VARIABLE -->
<fmt:setLocale value="${idioma}" />  <!-- SETEAR LOCALE -->
<fmt:setBundle basename="i18nmessages" /> <!-- CARGAR FICHERO PROPERTIES -->

<!doctype html>
<html lang="${idioma}"> 
<!-- FIN IDIOMAS -->

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Login</title>

<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
<link href="signin.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="CSS/login.css">
</head>


<body class="text-center"> 	


<form action="login" method="post" class="form-signin">
	<fieldset>
		<legend>INICIO DE SESION</legend>
		<p>Todos los campos con * son obligatorios</p>
	 
	 	<label for="idioma"><strong>Selecciona un Idioma</strong></label>
       	<select name="idioma" class="form-control mb-5">
       		<option value="eu_ES" selected>Euskera</option>
       		<option value="es_ES">Castellano</option>      	
       </select>
	
		<p>
			<label for="email"><strong>*Email</strong></label>
			<input type="text" name="email" id="email" class="form-control"  value="scobby" />
		</p>
		<p>
			<label for="password"><strong>*Password</strong></label>
			<input type="password" name="password" id="password" class="form-control"  value="galletas" />
		</p>
		<p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</p>
	
		<c:if test="${not empty msg}">	  
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  ${msg}			 
			</div>	 	
	 	</c:if>   		  
	</fieldset>
</form>

</body>
</html>
