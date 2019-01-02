<%@include file="includes/header.jsp"%>
<body class="text-center">
	<form novalidate class="form-signin" action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Logueate</h1>
		<label for="usuario" class="sr-only">Usuario</label> <input
			type="text" id="usuario" name="usuario" class="form-control"
			placeholder="Tu@usuario" value="${usuario}" required autofocus>
		<label for="pass" class="sr-only">Password</label> <input
			type="password" id="pass" class="form-control"
			placeholder="Mínimo 6 caractéres" name="pass" value="${pass}"
			required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		<%@include file="includes/mensajes.jsp"%>
		<p class="mt-5 mb-3 text-muted">&copy; Héctor Serrano 2018</p>
	</form>
<%@include file="includes/footer.jsp"%>