<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>


<main role="main" class="container">
<div class="jumbotron">
<h3>
		Página <span class="badge badge-secondary">${paginaActual+1} /
			${paginasTotal}</span>
	</h3>
		<form action="privado/libro" method="get" class="form-inline">
	 <div class="input-group">
    <div class="input-group-prepend">
      <div class="input-group-text" id="btnGroupAddon">Nº</div>
    </div>
    		<input class="form-control mr-sm-2" type="search" placeholder="Buscar por nº pagina..."
			aria-label="Search" name="pagina"  aria-label="Input group example" aria-describedby="btnGroupAddon" required> <!-- value="${paginaActual+1}" -->
 		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
	</form>
  </div>

 



	<hr>
	<p>
		<h2><span class="badge badge-primary">${pagina.autor}</span></h2>
	</p>
	<div class="border border-secondary p-4">${pagina.texto}</div>
	<hr>
	
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="privado/libro?pagina=${paginaActual}">Anterior</a></li>
			<li class="page-item"><a class="page-link"
				href="privado/libro?pagina=${paginaActual+2}">Siguiente</a></li>
		</ul>
	</nav>




</div>

<hr>

<h2>Escribir nueva pagina</h2>

<form action="privado/libro" method="post">
<div class="form-group">	
		Autor<input type="text" class="form-control" id="exampleInputEmail1"
		aria-describedby="emailHelp" name="autor" value="${usuario.email}">
</div>

<div class="form-group">
	Texto
	<textarea class="form-control" name="texto"
		id="exampleFormControlTextarea1" placeholder="minimo 50 caracteres"
		rows="3"></textarea>
</div>

<div class="form-group">
	<button type="submit" class="btn btn-primary btn-block">Nueva pagina</button>
</div>
</form>
</main>


<%@ include file="../includes/footer.jsp"%>
