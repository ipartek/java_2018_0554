<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<h1>perros</h1>
<table  class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Nombre</th>
				<th scope="col">Raza</th>
				<th scope="col">Chip</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perros}" var="p">
				<tr>
					<th scope="row">${p.nombre}</th>
					<td>${p.raza}</td>
					<td>${p.chip}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<%@ include file="../includes/footer.jsp"  %>