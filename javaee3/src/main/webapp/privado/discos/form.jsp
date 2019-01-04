<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>

<h1>Nuevo Disco</h1>

<main role="main" class="container">
	
		${disco}
	
		<form action="privado/disco" method="post">
		
			<div class="form-group">
			    <label for="id">Identificador</label>
			    <input type="text" name="id" value="${disco.id}" readonly class="form-control">			    
			</div>	
			
			<div class="form-group">
			    <label for="titulo">Título del disco</label>
			    <input type="text" name="titulo" value="${disco.titulo}" class="form-control" placeholder="título">			    
			</div>
			
			<div class="form-group">
			    <label for="artista">Artista</label>
			    <input type="text" name="artista" value="${disco.artista}" class="form-control" placeholder="artista">			    
			</div>
			
			<div class="form-group">
			    <label for="portada">Portada</label>
			    <input type="text" name="portada" value="${disco.portada}" class="form-control" placeholder="url de la portada">			    
			</div>
			
			<div class="form-group">
			    <label for="year">Año</label>
			    <input type="text" name="year" value="${disco.year}" class="form-control" placeholder="año de publicación">			    
			</div>
			
			<input type="hidden" name="op" value="3">
			<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
		</form>
		
		<c:if test="${disco.id > 0}">
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
        ¿Estas seguro de que deseas eliminar este disco?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		<a href="privado/disco?op=4&id=${disco.id}" class="btn btn-danger">ELIMINAR</a>
      </div>
    </div>
  </div>
</div>
		</c:if>

	</main>				

<%@ include file="../../includes/footer.jsp"%>
