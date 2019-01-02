<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container">


<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Mail</th>
			<th scope="col">Contraseña</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${usuarios}" var="u">
			<tr>
				<th scope="row">${u.id }</th>
				<td><a href="privado/usuarios?op=2&id=${u.id }">${u.email }</a></td>
				<td>${u.password }</td>
			</tr>
		</c:forEach>


	</tbody>
</table>
<p><a href="privado/usuarios?op=2&id=-1" class="btn btn-primary"> Nuevo usuario </a></p>

</main>


<%@ include file="../../includes/footer.jsp"%>
