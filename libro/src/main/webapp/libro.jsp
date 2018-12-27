<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
<main role="main" class="container">
		<p>Autor: ${pagina.autor}</p>
	<div class="jumbotron">
		<p>Texto: ${pagina.texto}</p>
		
		
	</div>
		<p>Página: ${pagActual+1} / ${pagTotal}</p>
		<a href="libros?pagina=${pagActual}">Página anterior</a>
		<form action="libros" method="get">
	      	<input type="number" name="pagina" >
	      	<input type="submit" value="ir a la página">
      	</form>
		<a href="libros?pagina=${pagActual+2}">Página siguiente</a>
		
		<!--  <h2>Escribir nueva Página</h2>
		<form action="libros" method="post">
			<input type="text" name="autor" value="${usuario.email}"><br>
			<textarea name="texto" placeholder="minimo 50 caracteres"></textarea><br>
			<input type="submit" value="Nueva página">
		</form>-->
		<a href="${pageContext.request.contextPath}/privado/escribir.jsp">Escribir nueva página</a>
</main>
<%@ include file="../includes/footer.jsp"  %>