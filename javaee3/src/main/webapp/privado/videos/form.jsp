<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
    
    <c:if test="${video.id>0 }">
	
	<div class="row">
	
		<div class="col-6"}>
	</c:if>	
	
			<form action="privado/videos" method="post">
			
				<div class="form-group">
				    <label for="id">Identificador</label>
				    <input type="text" name="id" value="${video.id}" readonly class="form-control">			    
				</div>	
				
				<div class="form-group">
				    <label for="nombre">Nombre</label>
				    <input type="text" name="nombre" value="${video.nombre}" class="form-control" placeholder="minimo 5 letras" minlength="5" maxlength="150">
				    <small id="nombre" class="form-text text-muted">minimo 5 letras, maximo 150</small>				    
				</div>
				
				<div class="form-group">
				    <label for="codigo">Código</label>
				    <input type="text" name="codigo" value="${video.codigo}" class="form-control" placeholder="11 caracteres">
				    <small id="codigo" class="form-text text-muted">11 caracteres</small>			    
				</div>
				
				
				<div class="form-group">
					<label for="id_usuario">Selecciona Usuario</label>
					<select class="form-control" name="id_usuario">
				<c:forEach items="${usuarios }" var="u">
						<option value="${u.id }" ${(u.id==video.usuario.id)?"selected":"" }>${u.email }</option>
					</c:forEach> 
					</select>
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
				        <a href="privado/videos?op=4&id=${video.id}" class="btn btn-danger">ELIMINAR</a>
				      </div>
				    </div>
				  </div>
				</div>
			
			</c:if>
		<c:if test="${video.id>0 }">
		</div>
		<!-- .col-6 -->	
		
		<div  class="col-6" >
			<iframe width="560" height="315" src="https://www.youtube.com/embed/${video.codigo}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</div>	
		
			
		
	</div>
	</c:if>
	<!-- .row -->	
		

	</main>				


<%@ include file="../../includes/footer.jsp"  %>  