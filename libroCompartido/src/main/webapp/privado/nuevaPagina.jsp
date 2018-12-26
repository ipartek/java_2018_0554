<%@include file="/includes/navbar.jsp" %>

<main role="main" class="container">
	<div class="jumbotron">
	<%@include file="/includes/mensajes.jsp" %>
<h2>Escribe una nueva página para el libro</h2>
 		<form action="index" method="post">
 			<input type="text" name="autor" value="${sessionScope.usuarioLogeado.usuario}" class="form-control" ><br>
 			<textarea name="texto" placeholder="minimo 50 caracteres" class="form-control" ></textarea><br>
 			<input type="submit" value="Nueva" class="btn btn-primary">
 		</form>
</div>
</main>
<%@include file="/includes/footer.jsp" %>