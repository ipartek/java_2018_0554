<%@ include file="includes/header.jsp" %>
<body>
<h1>Bienvenido ${usuario}</h1>

<!--  Página 'actual' de 'total'-->
<p> ${paginaActual} / ${totalPaginas}</p><br>
<!--  -->
	
	<p>${pagina.autor}</p>
	<p>${pagina.texto}</p>
	
	<!-- Navegación de páginas -->
	<a href="libro?pagina=${paginaActual-1}">Anterior</a> <a href="libro?pagina=${paginaActual+1}">Siguiente</a>
	<!--  -->
	
	
	<!--  enlace a herramienta de edicion edicion.jsp-->
</body>
</html>