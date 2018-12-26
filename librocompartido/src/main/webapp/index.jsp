<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<main role="main" class="container">
<div class="jumbotron">
	<p>
		<span class="badge badge-secondary">${pagina.autor}</span>
	</p>
	<textarea rows="10" cols="130" class="border border-secondary p-3"
		readonly placeholder="${pagina.placeholder}">${pagina.texto}</textarea>
	<hr>
	<p>Página ${paginaActual+1} / ${paginasTotal}</p>
	<nav aria-label="Page navigation">
	<%-- <c:if test="${paginaActual != 1}"> --%>
		<span class="float-left"><a class="page-link" href="libro?pagina=${paginaActual-1}">Anterior</a></span> 
	<%-- </c:if> --%>
	<%-- <c:if test="${paginaActual != paginasTotal}"> --%>
		<span class="float-right"><a class="page-link" href="libro?pagina=${paginaActual+1}">Siguiente</a></span>
	<%-- </c:if> --%>
	</nav>
	<%@include file="includes/mensajes.jsp"%>
</div>
</main>
<%@include file="includes/footer.jsp"%>