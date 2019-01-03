<%@ include file="../../include/header.jsp"  %>
<%@ include file="../../include/navbar.jsp"  %>
<%@ include file="../../include/mensajes.jsp"  %>

<main role="main" class="container">
	
	
		<form action="privado/cvideo" method="post">
		
			<div class="form-group">
			    <label for="id">Identificador</label>
			    <input type="text" name="id" value="${video.id}" readonly class="form-control">			    
			</div>	
			
			<div class="form-group">
			    <label for="titulo">Título del video</label> 
			    <input type="text" name="titulo" value="${video.titulo}" class="form-control" placeholder="minimo 5 maximo 150">			    
			</div>
			
			<div class="form-group">
			    <label for="codigo">Codigo</label>
			    <input type="text" name="codigo" value="${video.codigo}" class="form-control" placeholder="11 caracteres">			    
			</div>
			
			<input type="hidden" name="op" value="3">
			<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
		</form>
		
		<c:if test="${video.id > 0}">
				
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
			        ¿ Estas serguro que deseas eliminar el registro ?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			        <a href="privado/cvideo?op=4&id=${video.id}" class="btn btn-danger">ELIMINAR</a>
			      </div>
			    </div>
			  </div>
			</div>
		
		</c:if>
		

	</main>				
		


<%@ include file="../../include/footer.jsp"  %>  