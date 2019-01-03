<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container">


<table class="table table-hover">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Prev.</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${videos}" var="v">
			<tr>
				<th scope="row">${v.id }</th>
				<td><a href="privado/videos?op=2&id=${v.id }">${v.nombre }</a></td>
				<td><iframe width="280" height="160" src="https://www.youtube.com/embed/${v.codigo }" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
			</tr>
		</c:forEach>


	</tbody>
</table>
<p><a href="privado/videos?op=2&id=-1" class="btn btn-primary"> Nuevo video </a></p>

</main>


<%@ include file="../../includes/footer.jsp"%>
