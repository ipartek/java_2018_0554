<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">
	<a href="privado/usuarios?op=2&id=-1">Crear nuevo registro</a>
	<h1>Usuarios</h1>
	<table class="table">


		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Email</th>
				<th scope="col">Password</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usu">
				<tr>
					<td>${usu.id}</td>
					<td><a href="privado/usuarios?op=2&id=${usu.id}&email=${usu.email}&password=${usu.password}">${usu.email}</a></td>
					<td>${usu.password}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</div>
</main>





<%@ include file="../includes/footer.jsp"%>
