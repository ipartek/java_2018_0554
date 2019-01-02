<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">


	
	<form novalidate action="saludar" method="post" class="form-signin">
	
			<h1>Introduce los datos correspondientes</h1>

		<div class="form-group">
			<label for="email" class="sr-only">Nombre</label><input
				type="email" name="nombre" class="form-control"
				placeholder="Introduce tu nombre" required autofocus>
		</div>

		<div class="form-group">
			<label for="pass" class="sr-only">Apellidos</label> <input
				type="password" name="apellido" class="form-control"
				placeholder="Introduce tu apellido" required>
		</div>

		<div class="form-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				Enviar</button>
		</div>
	</form>





</body>
</html>





</div>
</main>
		




<%@ include file="../includes/footer.jsp"%>
