<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
<main role="main" class="container en-dos">
	<div class="jumbotron">
		<form class="form-signin" action="login" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Regístrate</h1>
			<label for="inputEmail" class="sr-only">Email</label>
			<input type="email" name="email" class="form-control mb-3" value="maria@gmail.com" placeholder="Email" required autofocus>
			<label for="inputPassword" class="sr-only">Contraseña</label>
			<input type="password" name="pass" class="form-control mb-3" value="12345678" placeholder="Contraseña" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
			<p class="error">${mensaje}</p>
		</form>
	</div>
	<div class="jumbotron">
		<a href="${pageContext.request.contextPath}/libros" class="btn btn-lg btn-primary btn-block">Ver el libro</a>
	</div>
</main>