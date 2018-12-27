<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>


<main role="main" class="container">
<div class="jumbotron">
<h3>
		<fmt:message key="libro.pagina"/> <span class="badge badge-secondary">${paginaActual+1} /
			${paginasTotal}</span>
	</h3>
		<form action="privado/libro" method="get" class="form-inline">
	 <div class="input-group">
    <div class="input-group-prepend">
      <div class="input-group-text" id="btnGroupAddon"><fmt:message key="libro.numero"/></div>
    </div>
    		<input class="form-control mr-sm-2" type="search" placeholder="<fmt:message key="libro.placeholderbusc"/>"
			aria-label="Search" name="pagina"  aria-label="Input group example" aria-describedby="btnGroupAddon" required> <!-- value="${paginaActual+1}" -->
 		<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><fmt:message key="libro.buscar"/></button>
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
				href="privado/libro?pagina=${paginaActual}"><fmt:message key="libro.anterior"/></a></li>
			<li class="page-item"><a class="page-link"
				href="privado/libro?pagina=${paginaActual+2}"><fmt:message key="libro.siguiente"/></a></li>
		</ul>
	</nav>




</div>

<hr>

<h2><fmt:message key="libro.escribirnueva"/></h2>

<form action="privado/libro" method="post">
<div class="form-group">	
		<fmt:message key="libro.autor"/><input type="text" class="form-control" id="exampleInputEmail1"
		aria-describedby="emailHelp" name="autor" value="${usuario.email}">
</div>

<div class="form-group">
	<fmt:message key="libro.texto"/>
	<textarea class="form-control" name="texto"
		id="exampleFormControlTextarea1" placeholder="<fmt:message key="libro.placeholderform"/>"
		rows="3"></textarea>
</div>

<div class="form-group">
	<button type="submit" class="btn btn-primary btn-block"><fmt:message key="libro.botonsubmit"/></button>
</div>
</form>
</main>


<%@ include file="../includes/footer.jsp"%>
