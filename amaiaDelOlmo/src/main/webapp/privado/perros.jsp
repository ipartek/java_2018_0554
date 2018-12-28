<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<main role="main" class="container en-dos">
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
	<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
	<div class="btn-group" role="group" aria-label="Third group">
		<a href="privado/nuevoperro.jsp" class="btn btn-secondary">Nuevo perro</a>
	  </div>
	  </div>

    </main>
<%@ include file="../includes/footer.jsp"  %>