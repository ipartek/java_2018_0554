<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>

<form class="form-signin" method="post" action="privado/perros">
	<legend>Insertar perro</legend>
	<label for="nombre" >Nombre</label>
	<input type="text" id="nombre" name="nombre" class="form-control" required >
	
	<label for="chip" >Chip</label>
	<input type="text" id="pass" name="chip" class="form-control" required>
	
	<label for="raza" >Raza</label>
	<input type="text" id="raza" name="raza" class="form-control" required>
	
	<button class="btn btn-lg btn-primary btn-block" type="submit">Insertar</button>
</form>