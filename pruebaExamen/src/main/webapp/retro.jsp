<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>

<main role="main" class="container">
<h1>TOP 5</h1>

<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
<table class="table table-striped">

	<thead>
		<tr>
			<th>ID</th>
			<th>Título</th>
			<th>Plataforma</th>
			<th>Lanzamiento</th>
			<th>Imagen</th>
		</tr>
	</thead>

 
	<tbody>
		<c:forEach items="${retro}" var="cartucho">



			<tr>

				<td>${cartucho.id}</td>
				<td>${cartucho.titulo}</td>
				<td>${cartucho.plataforma}</td>
				<td>${cartucho.lanzamiento}</td>
				<td><img src="${cartucho.imagen}" width=200 height=220 alt="caratula"></td>

			</tr>

		</c:forEach>
	</tbody>
	
</table>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>