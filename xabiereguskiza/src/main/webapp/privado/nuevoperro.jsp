<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>


<h1>Nuevo Perro</h1>

<form action="perros" method ="post" class="form-inline" role="form">
	<label for="nombre" class="mb-2 mr-sm-2">Nombre:</label>
	<input type="text" class="form-control mb-2 mr-sm-2" name="nombre" required autofocus>
	
	<label for="chip" class="mb-2 mr-sm-2">Chip:</label>
	<input type="text"  class="form-control mb-2 mr-sm-2" name="chip" placeholder="dd-dddd-aaaa" required>
	
	<label for="raza" class="mb-2 mr-sm-2">Raza:</label>
	<input type="text" class="form-control mb-2 mr-sm-2" name="raza" required>
	
	<input type="submit" name="Nuevo" value="Nuevo">
	
	</form>

<%@ include file="../includes/footer.jsp"%>