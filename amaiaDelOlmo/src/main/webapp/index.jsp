<%@ include file="../includes/header.jsp"  %>
<main role="main" class="container en-dos">
	<div class="jumbotron">
		<form class="form-signin" action="login" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Regístrate</h1>
			<label class="sr-only">Usuario</label>
			<input type="text" name="usuario" class="form-control mb-3" value="scobby" placeholder="usuario" required autofocus>
			<label class="sr-only">Contraseña</label>
			<input type="password" name="pass" class="form-control mb-3" value="galletas" placeholder="Contraseña" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
			<p class="error">${mensaje}</p>
		</form>
	</div>
</main>
<%@ include file="../includes/footer.jsp"  %>