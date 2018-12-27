
<%@include file="../includes/header.jsp" %>

    <main role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">Autor: ${usuario_logeado.email}</h1>
		<p>Esta logeado como autor para insertar nueva pagina</p>
      <p><a class="btn btn-danger btn-lg" href="logout" role="button">Logout</a></p>
    </div>
  </div>

<form method="post" action="paginas">
	<input type="hidden" value="${usuario_logeado.email}" name="usuario">
	
	<label for="autor">Autor</label>
	<input type="text" name="autor">
	
	<label for="textoinsertado">Texto</label>
	<textarea type="text" name="textoinsertado"></textarea>
	
	<button>Crear pagina</button>
</form>

</main>
<%@include file="../includes/footer.jsp" %>