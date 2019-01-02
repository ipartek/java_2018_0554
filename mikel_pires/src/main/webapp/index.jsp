<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Examen</title>

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/login.css" rel="stylesheet">
</head>

<body class="text-center">


	<form novalidate action="login" method="post" class="form-signin">
		<img class="mb-4" src="https://upload.wikimedia.org/wikipedia/commons/8/89/Dog.svg"
			alt="" width="72" height="72">
			<h1>Inicia sesion para continuar</h1>
		<div class="form-group">
			<c:if test="${not empty mensaje}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">${mensaje}</div>
			</c:if>
		</div>

		<div class="form-group">
			<label for="email" class="sr-only">Correo Electronico:</label><input
				type="email" name="email" class="form-control"
				placeholder="Introduce email" required autofocus>
		</div>

		<div class="form-group">
			<label for="pass" class="sr-only">Contraseña</label> <input
				type="password" name="password" class="form-control"
				placeholder="Introduce contrasenya" required>
		</div>

		<div class="form-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				Entrar</button>
		</div>
	</form>





</body>
</html>

