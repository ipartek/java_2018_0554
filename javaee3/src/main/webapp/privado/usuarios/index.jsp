<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container">
<%@ include file="../../includes/mensajes.jsp"%>
<a href="usuarios?op=2&id=-1" class="mb-4 btn btn-outline-success">Crear Nuevo Registro</a>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">id</th>
			<th scope="col">Email</th>
			<th scope="col">Password</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<th>${u.id}</th>
				<td><a href="usuarios?op=2&id=${u.id}">${u.email}</a></td>
				<td>${u.password}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</main>
<%@ include file="../../includes/footer.jsp"%>