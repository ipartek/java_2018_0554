<%@ include file="../includes/cabecera.jsp" %>
<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/mensajes.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>Libro Compartido</h1>
<form action="pagina" method="POST">
  <div class="form-group">
    <label for="autor">Autor</label>
    <input type="text" class="form-control" id="autor" name="autor" placeholder="Nombre del autor" value="${sessionScope.usuario_logueado.email}">
  </div>
  <div class="form-group">
    <label for="texto">Texto de la página</label>
    <textarea class="form-control" placeholder="Mínimo 50 caracteres" id="texto" name="texto" rows="3"></textarea>
  </div>
  <input class="btn btn-primary" type="submit" value="Guardar">
</form>
</div>
</div>
<%@ include file="../includes/pie.jsp" %>