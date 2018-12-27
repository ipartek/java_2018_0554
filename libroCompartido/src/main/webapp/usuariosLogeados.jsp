<%@include file="/includes/navbar.jsp"%>
<main role="main" class="container">
<div class="jumbotron">
	<h1><fmt:message key="usuariosLogeados.titulo"/></h1>
	<ul>
		<c:forEach items="${applicationScope.usuariosLogeados}" var="u">
			<li>${ u.usuario}</li>
		</c:forEach>
	</ul>
</div>
</main>
<%@include file="/includes/footer.jsp"%>