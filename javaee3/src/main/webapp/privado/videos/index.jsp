<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container">
<%@ include file="../../includes/mensajes.jsp"%>
<a href="videos?op=2&id=-1" class="mb-4 btn btn-outline-success">Registrar nuevo vídeo</a>
<a href="videos?&id=0" class="mb-4 btn btn-outline-success">Ver mis vídeos</a>
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col">Código</th>
			<th scope="col">Usuario</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${videos}" var="v">
			<tr>
				<th>${v.id}</th>
				<td>
					<a href="videos?op=2&id=${v.id}">${v.nombre}</a>
				</td>
				<td>
					${v.codigo}
				</td>
				<td>
					${v.usuario.email}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</main>
<%@ include file="../../includes/footer.jsp"%>