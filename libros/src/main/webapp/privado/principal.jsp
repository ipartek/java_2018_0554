<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">

	<ul>
		<c:forEach items="${videos}" var="v">
			<li>${v.id}+ ${v.nombre}</li>
			
					<iframe width="560" height="315" src="//www.youtube.com/embed/${v.url}" allowfullscreen=""></iframe>


		
		</c:forEach>
	</ul>
	</div>
	
</main>


<%@ include file="../includes/footer.jsp"%>
