<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>

  

<main role="main" class="container">
	<div class="jumbotron">
		<ul>
			<c:forEach items="${videos}" var="v">
				<li>${v.id} + ${v.nombre}</li>
			</c:forEach>
		</ul>
	</div>
</main>



  
<%@ include file="../includes/footer.jsp"  %>  