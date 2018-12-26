<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<meta http-equiv="refresh" content="5; URL=usuariosLogueados.jsp">
<body>
	<main role="main" class="container"> 
	<table>
		<tbody>
			<c:forEach items="${usuariosLogueados}" var="usuario">
				<td>${usuario.email}</td>
				<td>${usuario.autor}</td>
			</c:forEach>
		</tbody>
	</table>
	</main>
</body>

<%@include file="includes/footer.jsp"%>