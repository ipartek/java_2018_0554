<%@include file="includes/header.jsp"%>
<body class="text-center">
	<form novalidate class="form-signin" action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">
			Logueate
		</h1>
		<label for="usuario" class="sr-only">Usuario
				</label> 
				<input type="text" id="usuario"
			name="usuario" class="form-control" placeholder="Usuario"
			value="${usuario}" required autofocus>
			<label for="password" class="sr-only">
			Contraseña:</label> 
			<input type="password" id="password" class="form-control" placeholder="Contraseña" name="password" value="${password}"
			required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Enviar
		</button>
		<%@include file="includes/mensajes.jsp"%>
		<p class="mt-5 mb-3 text-muted">&copy; Héctor Serrano 2018</p>
	</form>
<%@include file="includes/footer.jsp"%>