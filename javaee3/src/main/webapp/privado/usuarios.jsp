<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>


<meta http-equiv="refresh" content="5; URL=${pageContext.request.contextPath}/privado/usuarios.jsp">

<main role="main" class="container">
	<p>*recargamos esta pagina cada 5 segundos mediantes etiqueta <b>http-equiv="refresh"</b> </p>
	
	<ul class="list-group">
	<c:forEach items="${usuariosLogeados}" var="u">
		<li class="list-group-item">${u}</li>
	</c:forEach>
	</ul>
	
</main>	


<%@ include file="../includes/footer.jsp"  %>  