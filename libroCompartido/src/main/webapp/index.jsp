<%@ include file="includes/cabecera.jsp" %>
<%@ include file="includes/menu.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>Libro Compartido</h1>
		<h3>Autor: ${pagina.autor }</h3>
		<p>${pagina.texto }</p>
	</div>
	<p class="text-right">Página: ${paginaActual } / ${totalPaginas }</p>
	<!-- Center-aligned -->
<ul class="pagination justify-content-center pagination-lg">
	<c:choose>
    <c:when test="${paginaActual=='1'}">
    <li class="page-item"><a class="page-link disabled">Primera página</a></li>   
     <li class="page-item"><a class="page-link disabled">Página anterior</a></li>   
    </c:when>    
    <c:otherwise>
     <li class="page-item"><a class="page-link" href="libro?pagina=1">Primera página</a></li>
     <li class="page-item"><a class="page-link" href="libro?pagina=${paginaActual - 1 }">Página anterior</a></li>
    </c:otherwise>
	</c:choose>
	<c:choose>
    <c:when test="${paginaActual==totalPaginas}">
     <li class="page-item"><a class="page-link disabled">Siguiente página</a></li>   
    </c:when>    
    <c:otherwise>
     <li class="page-item"><a class="page-link" href="libro?pagina=${paginaActual + 1 }">Siguiente página</a></li>
    </c:otherwise>
	</c:choose>  
	<c:choose>
    <c:when test="${paginaActual==totalPaginas}">
     <li class="page-item"><a class="page-link disabled">Última página</a></li>   
    </c:when>    
    <c:otherwise>
     <li class="page-item"><a class="page-link" href="libro?pagina=${totalPaginas }">Última página</a></li>
    </c:otherwise>
	</c:choose>
</ul>
</div>
<%@ include file="includes/pie.jsp" %>