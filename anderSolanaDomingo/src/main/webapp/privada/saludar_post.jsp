<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>

<div class="container">
	<div class="jumbotron">
		<form action="privada/saludar" method="POST">
			<div class="form-group">
   				<label for="nombre">Nombre</label>
    			<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" value="${sessionScope.usuario_logueado.nombre }">
  			</div>
  			<div class="form-group">
    			<label for="apellido">Apellido</label>
    			<input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido">
  			</div>
  			<input class="btn btn-primary" type="submit" value="Enviar">
		</form>
	</div>
</div>

<%@ include file="../includes/pie.jsp" %>