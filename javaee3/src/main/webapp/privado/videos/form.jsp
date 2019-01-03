<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container"> 
<form action="privado/usuarios" method="post">
	<div class="form-group">
		<label for="exampleInputEmail1">Id</label> <input
			type="number" class="form-control" id="exampleInputEmail1"
			name="id" value="${video.id }" readonly>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Nombre</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			name="nombre" value="${video.nombre }"  placeholder="Titulo">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Codigo</label> <input
			type="password" class="form-control" id="exampleInputPassword1"
			name="codigo" value="${video.codigo }" placeholder="11 caracteres">
	</div>
	<input type="hidden" name="op" value="3">
	<button type="submit" class="btn btn-primary btn-block"><c:if test="${video.id>0 }">Modificar</c:if><c:if test="${video.id<0 }">Nuevo</c:if></button>
</form>
<c:if test="${video.id>0 }">
<!-- Button trigger modal -->
			<button type="button" class="btn btn-outline-danger btn-block mt-4" data-toggle="modal" data-target="#exampleModal">
			  ELIMINAR
			</button>
	
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Atención</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        ¿ Estas serguro que deseas eliminar el video ?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			        <a href="privado/videos?op=4&id=${video.id}" class="btn btn-danger">ELIMINAR</a>
			      </div>
			    </div>
			  </div>
			</div>

</c:if>

</main>


<%@ include file="../../includes/footer.jsp"%>