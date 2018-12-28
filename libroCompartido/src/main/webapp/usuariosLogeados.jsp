<%@include file="/includes/navbar.jsp"%>
<main role="main" class="container">
<div class="jumbotron">
	<h1>
		<fmt:message key="usuariosLogeados.titulo" />
	</h1>
	
		<table class="table">
			<thead class="thead-dark">
				<tr>
					
					<th>Nombre</th>
					
				</tr>
			</thead>
			<tbody class="bg-success">
				<c:forEach items="${applicationScope.usuarios_logueados}"
					var="entry">
					<tr>
						<td><c:out value="${entry.key}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
</div>
</main>
<%@include file="/includes/footer.jsp"%>