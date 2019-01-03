<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">

	<h1>Editar ${videos}</h1>
	<form action="privado/videos" method="post">
		<div class="form-group">
			<input type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="id" value="${video.id}"
				readonly>
		</div>

		<div class="form-group">
			<input type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="nombre" placeholder="nombre video" value="${video.nombre}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="url video"name="codigo"
				value="${video.codigo}">
		</div>

		<div class="form-group">
			<input type="hidden" name="op" value="3">
			<button type="submit" class="btn btn-primary btn-block">Guardar</button>
		</div>
		<c:if test="${video.id > 0 }">
			

			<!-- Button trigger modal -->
			<button type="button" class="btn btn-danger btn-block" data-toggle="modal"
				data-target="#exampleModal">Eliminar</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Estas seguro?</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">Estas a punto de eliminar el registro</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Cerrar</button>
							<a href="privado/videos?op=4&id=${video.id}"
				class="btn btn-danger btn-danger">Eliminar</a>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</form>

</div>
</main>





<%@ include file="../includes/footer.jsp"%>
