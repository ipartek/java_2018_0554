<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>

<div class="container">
	<div class="jumbotron">
	<c:if test="${vacios != null}">
	<div class="alert alert-danger" role="alert">
  			${vacios}
		</div>
	</c:if>
		<form action="alta" method="POST">
			<div class="form-group">
   				<label for="nombre">Nombre</label>
    			<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del perro">
  			</div>
  			<div class="form-group">
   				<label for="edad">Edad</label>
    			<input type="number" class="form-control" id="edad" name="edad" placeholder="Edad del perro">
  			</div>
  			<div class="form-group">
   				<label for="apadrinado">Ha sido apadrinado?</label>
    			
  			</div>
  			<div class="form-group">
  				<input class="p-2 m-2" type="radio" id="apadrinado" name="apadrinado" value="No" checked>No
    			<input class="p-2 m-2" type="radio" id="apadrinado" name="apadrinado" value="Si">Si
  			</div>
  			<div class="form-group">
   				<label for="peso">Peso</label>
    			<input type="number" class="form-control" id="peso" name="peso" placeholder="Peso del perro">
  			</div>
  			<div class="form-group">
    			<label for="latitud">Latitud (Chip)</label>
    			<input type="text" class="form-control" id="latitud" name="latitud" placeholder="Latitud">
  			</div>
  			<div class="form-group">
    			<label for="longitud">Longitud (Chip)</label>
    			<input type="text" class="form-control" id="longitud" name="longitud" placeholder="Longitud">
  			</div>
  			<input class="btn btn-primary" type="submit" value="Enviar">
		</form>
	</div>
</div>

<%@ include file="../includes/pie.jsp" %>