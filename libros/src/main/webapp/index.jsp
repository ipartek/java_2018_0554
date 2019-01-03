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


	<c:set var="cIdioma"
		value="${not empty cookie.cIdioma ? cookie.cIdioma.value : 'es_ES'}"
		scope="session" />

	<c:set var="cEmail"
		value="${not empty cookie.cEmail ? cookie.cEmail.value : ''}"
		scope="session" />

	<c:set var="cEmailTrue"
		value="${not empty cookie.cEmailTrue ? cookie.cEmailTrue.value : ''}"
		scope="session" />

	<c:set var="cUltimaVisita"
		value="${not empty cookie.cUltimaVisita ? cookie.cUltimaVisita.value : ''}"
		scope="session" />


	<form novalidate action="login" method="post" class="form-signin">
		<div class="form-group">
			<p>Tu ultima visita fue : ${cUltimaVisita}</p>
			<p>Idioma de la cookie ${cIdioma}</p>
			Idioma<select name="idioma" class="form-control form-control-sm">
				<option value="eu_ES" ${(cIdioma=="eu_ES")?"selected":""}>Euskera</option>
				<option value="es_ES" ${(cIdioma=="es_ES")?"selected":""}>Español</option>
				<option value="en_EN" ${(cIdioma=="en_EN")?"selected":""}>Ingles</option>
			</select>
		</div>

		<div class="form-group">
			<c:if test="${not empty alerta}">
				<div class="alert alert-${alerta.tipo} alert-dismissible fade show"
					role="alert">${alerta.texto}</div>
			</c:if>
		</div>

		<div class="form-group">
			<label for="email" class="sr-only">Correo Electronico:</label> Email<input
				type="email" name="email" class="form-control" value="${cEmail}"
				placeholder="tu@email.com" required autofocus>
		</div>

		<div class="form-group">
			<label for="pass" class="sr-only">Contraseña</label> Password<input
				type="password" name="pass" class="form-control"
				placeholder="minimo 6 caracteres" value="Pa$$w0rd" required>
		</div>

		<div class="form-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				<fmt:message key="login.boton" />
			</button>
		</div>
	</form>





</body>
</html>

