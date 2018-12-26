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
	<a href="usuariosLogueados.jsp">Usuarios Conectados</a>
	<hr>
	<p>Página ${paginaActual+1} / ${paginasTotal}</p>
	<form class="float-right" action="libro" method="get">
		<input type="text" name="pagina" value="${paginaActual+1}" required>
		<input type="submit" value="buscar">
	</form>
	<nav aria-label="Page navigation">
		<span class="float-left"><a class="page-link"
			href="libro?pagina=${paginaActual-1}">Anterior</a></span> <span
			class="float-right"><a class="page-link"
			href="libro?pagina=${paginaActual+1}">Siguiente</a></span>
		<ul>
			<c:if test="${logueado.email != null}">
				<li class="nav-item active"><a class="nav-link"
					href="mantenimiento?accion=insertar&autor=${logueado.email}">Insertar</a></li>
			</c:if>
			<c:if test="${logueado.email == pagina.autor}">
				<li class="nav-item active"><a class="nav-link"
					href="mantenimiento?accion=editar&pagina=${paginaActual}&texto=${pagina.texto}&autor=${logueado.email}">Editar</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="mantenimiento?accion=borrar&pagina=${paginaActual}">Borrar</a>
				</li>
			</c:if>
		</ul>
	</nav>
	<%@include file="includes/mensajes.jsp"%>
</div>
</main>
<%@include file="includes/footer.jsp"%>