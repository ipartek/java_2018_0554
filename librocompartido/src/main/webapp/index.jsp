<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<p>Autor: ${pagina.autor}</p>
<textarea rows="20" cols="50" readonly placeholder="${pagina.placeholder}">${pagina.texto}</textarea>
<c:if test="${usuarioLogueado.email != null}">
	<a href="mantenimiento?accion=insertar&autor=${usuarioLogueado.email}">Insertar</a>
</c:if>
<c:if test="${usuarioLogueado.email == pagina.autor}">
	<a href="mantenimiento?accion=editar&pagina=${paginaActual}&texto=${pagina.texto}&autor=${pagina.autor}">Editar</a>
	<a href="mantenimiento?accion=borrar&pagina=${paginaActual}">Borrar</a>
</c:if>

Página:
<a href="libro?pagina=${paginaActual-1}"> < </a>
${paginaActual+1} / ${paginasTotal}
<a href="libro?pagina=${paginaActual+1}"> > </a>
<%@include file="includes/footer.jsp"%>