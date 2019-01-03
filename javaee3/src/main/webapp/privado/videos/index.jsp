<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container">
<%@ include file="../../includes/mensajes.jsp"%>
<a href="videos?op=2&id=-1" class="mb-4 btn btn-outline-success">Registrar Nuevo Vídeo</a>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col">Vídeo</th>
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
					<iframe width="250" height="250" src="https://www.youtube.com/embed/${v.codigo}" 
					frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
					allowfullscreen></iframe>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</main>
<%@ include file="../../includes/footer.jsp"%>