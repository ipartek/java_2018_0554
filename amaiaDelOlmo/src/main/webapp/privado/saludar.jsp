<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<main role="main" class="container en-dos">
	<div class="jumbotron">
		<form class="form-signin" action="saludar" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Ingresa tu nombre y tus apellidos</h1>
			<label class="sr-only">Nombre</label>
			<input type="text" name="nombre" class="form-control mb-3" placeholder="Nombre" required autofocus>
			<label class="sr-only">Apellidos</label>
			<input type="text" name="apellidos" class="form-control mb-3" placeholder="Apellidos" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
			<p class="error">${mensaje}</p>
		</form>
		<a href="saludar?nombre=Amaia&apellidos=Del%20Olmo">Saludar por get</a>
	</div>
</main>
<%@ include file="../includes/footer.jsp"  %>