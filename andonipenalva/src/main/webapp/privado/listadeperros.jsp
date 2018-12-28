<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>

<main role="main" class="container">
<h1>Lista de nuestros perros</h1>

<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
<table class="table table-striped">

	<thead>
		<tr>
			<!-- <th>Chip</th> -->
			<th>Chip</th>
			<th>Nombre</th>
			<th>Raza</th>
			
		</tr>
	</thead>

 
	<tbody>
		<c:forEach items="${perro}" var="canes">



			<tr>

				<%-- <td>${canes.chip}</td> --%>
				<td>${canes.chip}</td>
				<td>${canes.nombre}</td>
				<td>${canes.raza}</td>
				
			</tr>

		</c:forEach>
	</tbody>
	
</table>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>