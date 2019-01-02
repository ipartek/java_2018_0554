<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">

	<h1>Listado de perros</h1>

	<table class="table">


		<thead>
			<tr>
				<th scope="col">Nombre</th>
				<th scope="col">Raza</th>
				<th scope="col">Chip</th>
				<th scope="col">Ver mas datos...</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perros}" var="p">
				<tr>
					<th scope="row">${p.nombre}</th>
					<td>${p.raza}</td>
					<td>${p.chip}</td>
					<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${p.nombre}">
Ver ficha completa
</button></td>
				</tr>
				<div class="modal fade" id="${p.nombre}" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalCenterTitle"
					aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLongTitle">${p.nombre}</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
							<ul>
								<li><strong>Nombre:</strong> ${p.nombre}</li>
								<li><strong>Edad:</strong> ${p.edad} años</li>
								<li><strong>Raza:</strong> ${p.raza}</li>
								<li><strong>Peso:</strong> ${p.peso} kg</li>
								<li><strong>Apadrinado?:</strong> ${p.apadrinado}</li>
								<li><strong>N. chip:</strong> ${p.chip}</li>
								<li><strong>Ultima ubicacion:</strong> ${p.localizacion}</li>
							</ul>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Cerrar</button>

							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</tbody>
	</table>




</div>
</main>





<%@ include file="../includes/footer.jsp"%>
