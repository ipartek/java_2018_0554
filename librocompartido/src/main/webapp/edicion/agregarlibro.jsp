<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/navbar.jsp" %>
<%@ include file="../includes/mensajes.jsp" %>
<main>
	<form action="nuevapag" class="respira" method="post">
	  <div class="form-group">
	    <p>Nueva página de ${usuario.nombre}</p>
	    <p></p>
	    <p>Texto de página</p>
	   	<textarea name="texto" cols="115" rows="20"></textarea>
	  </div>
	  <button type="submit" class="btn btn-primary">Enviar</button>
	</form>
</main>
<%@ include file="../includes/footer.jsp" %>