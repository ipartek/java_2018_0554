<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container"> 
<%@ include file="../../includes/mensajes.jsp"%>
<form action="videos" method="post">
	<c:choose>
		<c:when test="${video.id != -1}">
			<div class="form-group">
				<label for="id">Id</label> <input type="text" name="id"
					value="${video.id}" readonly class="form-control">
			</div>
		</c:when>
		<c:otherwise>
			<input type="hidden" name="id" value="${video.id}" readonly>
		</c:otherwise>
	</c:choose>
	<div class="form-group">
		<label for="email">Nombre</label> <input type="text"
			name="nombre" value="${video.nombre}" minlength="1" maxlength="150" class="form-control"
			placeholder="Min 1 / Max 150 caractéres">
	</div>

	<div class="form-group">
		<label for="password">Código</label> <input type="text"
			name="codigo" value="${video.codigo}" minlength="11" maxlength="11" class="form-control"
			placeholder="Obligatoriamente 11 caractéres">
	</div>

	<input type="hidden" name="op" value="3">
	<button type="submit" class="btn btn-outline-primary btn-block">GUARDAR</button>
</form>

	<c:if test="${video.id > 0}">
		<button type="button" class="btn btn-block btn-outline-danger mt-4"
			data-toggle="modal" data-target="#exampleModal">ELIMINAR</button>
	
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">¿Eliminar ${video.nombre} y todos sus
						datos?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<a href="videos?id=${video.id}&op=4" class="btn btn-danger">ELIMINAR</a>
					</div>
				</div>
			</div>
		</div>
	</c:if> 
</main>


<%@ include file="../../includes/footer.jsp"%>
