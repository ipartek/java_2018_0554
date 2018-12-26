<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<meta http-equiv="refresh" content="5; URL=usuariosLogueados.jsp">
<body>
	<main role="main" class="container">
	<table class="table table-hover">
		<thead class="thead-dark">
			<th>Usuario</th>
			<th>Contraseña</th>
		</thead>
		<tbody>
			<c:forEach items="${usuariosLogueados}" var="usuario">
				<tr>
					<td>${usuario.email}</td>
					<td>${usuario.password}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</main>
</body>

<%@include file="includes/footer.jsp"%>