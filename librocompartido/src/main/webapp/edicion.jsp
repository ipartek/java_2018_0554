<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>


<p>Autor: ${pagina.autor}</p>
<textarea cols="100" rows="20">
   ${pagina.texto}	
</textarea>

<a href="libro?pagina=${paginaActual-1}">Anterior</a>
<a href="libro?pagina=${paginaActual+1}">Siguiente</a>


<%@ include file="includes/footer.jsp"%>