<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">

	<div class="row">
	
		<div class="col-6"}>

	
			<form action="privado/categorias" method="post">
			
				<div class="form-group">
				    <label for="id">Identificador</label>
				    <input type="text" name="id" value="${categoria.id}" readonly class="form-control">			    
				</div>	
				
				<div class="form-group">
				    <label for="nombre">Nombre</label>
				    <input type="text" name="nombre" value="${categoria.nombre}" class="form-control" placeholder="minimo 5 letras" minlength="5" maxlength="150">
				    <small id="nombre" class="form-text text-muted">minimo 5 letras, maximo 150</small>				    
				</div>
				
					
				<input type="hidden" name="op" value="3">
				<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
			</form>
			
			<c:if test="${categoria.id > 0}">
					
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
				        ¿ Estas serguro que deseas eliminar la categoria ?
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				        <a href="privado/categorias?op=4&id=${categoria.id}" class="btn btn-danger">ELIMINAR</a>
				      </div>
				    </div>
				  </div>
				</div>
			
			</c:if>
		</div>
<!-- .col-6 -->	
		
	</div>

	<!-- .row -->	
		

	</main>				


<%@ include file="../../includes/footer.jsp"  %>  