<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container">


<table class="table table-hover">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Codigo</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${videos}" var="v">
			<tr>
				<th scope="row">${v.id }</th>
				<td><a href="privado/videos?op=2&id=${v.id }">${v.nombre }</a></td>
				<td>${v.codigo }</td>
			</tr>
		</c:forEach>


	</tbody>
</table>
<p><a href="privado/usuarios?op=2&id=-1" class="btn btn-primary"> Nuevo video </a></p>

</main>


<%@ include file="../../includes/footer.jsp"%>
