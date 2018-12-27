<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="language"
	value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}"
	scope="session" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="i18nmessages" />

<!doctype html>
<html lang="${idioma}">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Videos</title>

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/login.css" rel="stylesheet">
</head>

<body class="text-center">







	<form novalidate action="login" method="post" class="form-signin">
	<div class="form-group">
		Idioma<select name="idioma" class="form-control form-control-sm">
			<option value="eu_ES">Euskera</option>
			<option value="es_ES">Español</option>
			<option value="en_EN">Ingles</option>
		</select>
	</div>
	
	<div class="form-group">
		<c:if test="${not empty mensaje}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">${mensaje}</div>
		</c:if>
	</div>
	
	<div class="form-group">
		<label for="email" class="sr-only">Correo Electronico:</label> Email<input
			type="email" name="email" class="form-control"
			value="xabier@ipartek.com" placeholder="tu@email.com" required
			autofocus> 
	</div>
	
	<div class="form-group">
			<label for="pass" class="sr-only">Contraseña</label>
		Password<input type="password" name="pass" class="form-control"
			value="Pa$$w0rd" placeholder="minimo 6 caracteres" required>
	</div>
	
	<div class="form-group">
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			<fmt:message key="login.boton" />
		</button>
	</div>
	</form>





</body>
</html>

