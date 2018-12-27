<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
<main role="main" class="container">		
		<h2>Escribir nueva Página</h2>
		<form action="libros" method="post">
			<input type="text" name="autor" value="${usuario.email}"><br>
			<textarea name="texto" placeholder="minimo 50 caracteres"></textarea><br>
			<input type="submit" value="Nueva página">
		</form>
</main>
<%@ include file="../includes/footer.jsp"  %>