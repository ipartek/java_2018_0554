<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>

<h1>Nuevo Usuario</h1>

<form action="" method ="post" class="form-inline" role="form">
	<label for="email" class="mb-2 mr-sm-2">Email:</label>
	<input type="email" class="form-control mb-2 mr-sm-2" name="email" required autofocus>
	
	<label for="password" class="mb-2 mr-sm-2">Contraseña:</label>
	<input type="password"  class="form-control mb-2 mr-sm-2" name="password" placeholder="password" required>
	
	
	
	<input type="submit" name="Nuevo" value="Nuevo">
	
	</form>


<%@ include file="../../includes/footer.jsp"  %>  