<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>

<ol class="list-group">

	<c:forEach items="${videos}" var="v">
	<span class="border border-primary">
		
		<li class="list-group p-3">${v.id} + ${v.nombre} +  src="https://www.youtube.com/embed/${v.url}" </li>
			
		</span>
				</c:forEach>
			</ol>
			
			
<!-- //Integrar el carrito aqui -->
			
<%@ include file="../includes/footer.jsp"  %>  