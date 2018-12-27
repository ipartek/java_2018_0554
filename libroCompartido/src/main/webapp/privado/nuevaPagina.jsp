<%@include file="/includes/navbar.jsp" %>

<main role="main" class="container">
	<div class="jumbotron">
	<%@include file="/includes/mensajes.jsp" %>
<h2><fmt:message key="nuevaPagina.titulo"/></h2>
 		<form action="index" method="post">
 			<input type="text" name="autor" value="${sessionScope.usuarioLogeado.usuario}" class="form-control" ><br>
 			<textarea name="texto" placeholder="<fmt:message key="nuevaPagina.texto"/>" class="form-control" ></textarea><br>
 			<input type="submit" value="<fmt:message key="nuevaPagina.nueva"/>" class="btn btn-primary">
 		</form>
</div>
</main>
<%@include file="/includes/footer.jsp" %>