<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container"> ${usuario} <%@ include
	file="../../includes/mensajes.jsp"%>
<form action="usuarios" method="post">
	<c:choose>
		<c:when test="${usuario.id != -1}">
			<div class="form-group">
				<label for="id">Id</label> <input type="text" name="id"
					value="${usuario.id}" readonly class="form-control">
			</div>
		</c:when>
		<c:otherwise>
			<input type="hidden" name="id" value="${usuario.id}" readonly>
		</c:otherwise>
	</c:choose>
	<div class="form-group">
		<label for="email">Correo Electornico</label> <input type="email"
			name="email" value="${usuario.email}" class="form-control"
			placeholder="tucorreo@electronico.com">
	</div>

	<div class="form-group">
		<label for="password">Contraseña</label> <input type="password"
			name="password" value="${usuario.password}" class="form-control"
			placeholder="minimo 5 maximo 50 caracteres">
	</div>

	<input type="hidden" name="op" value="3">
	<button type="submit" class="btn btn-outline-primary btn-block">GUARDAR</button>
</form>

	<c:if test="${usuario.id > 0}">
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
					<div class="modal-body">¿Eliminar ${usuario.email} y todos sus
						datos?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<a href="usuarios?id=${usuario.id}&op=4" class="btn btn-danger">ELIMINAR</a>
					</div>
				</div>
			</div>
		</div>
	</c:if> 
</main>


<%@ include file="../../includes/footer.jsp"%>
