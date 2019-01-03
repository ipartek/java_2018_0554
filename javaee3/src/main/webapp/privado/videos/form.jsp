<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>

<h1>Nuevo Video</h1>

<main role="main" class="container">
	
		${listado}
	
		<form action="privado/videos" method="post">
		
			<div class="form-group">
			    <label for="id">Identificador</label>
			    <input type="text" name="id" value="${listado.id}" readonly class="form-control">			    
			</div>	
			
			<div class="form-group">
			    <label for="nombre">Nombre del Video</label>
			    <input type="text" name="nombre" value="${listado.nombre}" class="form-control" placeholder="título del vídeo">			    
			</div>
			
			<div class="form-group">
			    <label for="codigo">Codigo</label>
			    <input type="text" name="codigo" value="${listado.codigo}" class="form-control" placeholder="código youtube (11 caracteres)">			    
			</div>
			
			<input type="hidden" name="op" value="3">
			<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
		</form>
		
		<c:if test="${listado.id > 0}">
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
        ¿Estas seguro de que deseas eliminar este vídeo?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		<a href="privado/videos?op=4&id=${listado.id}" class="btn btn-danger">ELIMINAR</a>
      </div>
    </div>
  </div>
</div>
		</c:if>

	</main>				

<%@ include file="../../includes/footer.jsp"%>
