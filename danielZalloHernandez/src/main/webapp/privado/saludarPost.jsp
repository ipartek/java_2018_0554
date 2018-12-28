<%@include file="/includes/navbar.jsp"%>
<main role="main" class="container">
<div class="jumbotron">
	<%@include file="/includes/mensajes.jsp"%>
	<form action="privado/saludarPost" method="post">
		<h1>Rellena los siguientes campos</h1>
		<div class="form-group">
			<label for="nombre"> Introduce tu nombre: 
			<input type="text" id="nombre" name="nombre" class="form-control" />
			</label>
		</div>
		<div class="form-group">
			<label for="apellido">Introduce tu apellido o tus apellidos:
			<input type="text" id="apellido" name="apellido" class="form-control" />
			</label>
		</div>

		<button type="submit" class="btn btn-primary">Login</button>
	</form>
</div>
</main>
<%@include file="/includes/footer.jsp"%>



