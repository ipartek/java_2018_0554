<%@include file="../includes/header.jsp"%>
<body>
<main>
	<caption><span class="container h3 mb-4">Detalles de ${nombre}</span></caption>
		<table class="mb-4 table table-borderless">
			<thead class="thead-light">
				<tr>
					<th>Chip</th>
					<th>Coordenadas</th>
					<th>Edad</th>
					<th>Raza</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${chip}</td>
					<td>${coordenadas}</td>
					<td>${edad}</td>
					<td>${raza}</td>
				</tr>
			</tbody>
		</table>
	</body>
</main>
<%@include file="../includes/footer.jsp" %>
