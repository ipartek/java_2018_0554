<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Inicia sesion para continuar...</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/style_index.css" rel="stylesheet">
</head>

<body class="text-center">
	<form novalidate class="form-signin" action="login" method="post">
		<img class="mb-4"
			src="https://upload.wikimedia.org/wikipedia/commons/4/4f/SVG_Logo.svg"
			alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Iniciar Sesion</h1>
		<label for="inputEmail" class="sr-only">Email</label> <input
			type="email" name="email" value="${emailValue}" id="inputEmail"
			class="form-control" placeholder="Inserta email" required autofocus>
		<label for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="pass" value="${passwordValue}"
			id="inputPassword" class="form-control"
			placeholder="Inserta password" required>

		<div class="checkbox mb-3">
			<label> <input type="checkbox" name="recordar" value="yes">
				Recuerdame
			</label>
		</div>


		<button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar
			sesion</button>
		<%
			//=request.getAttribute("error") != null ? request.getAttribute("error") : ""
		%>

			 <div class="alert alert-danger" role="alert">
			 ${errores} <br>
			 ${error}
		</div>

	
		
		

	</form>
</body>
</html>
