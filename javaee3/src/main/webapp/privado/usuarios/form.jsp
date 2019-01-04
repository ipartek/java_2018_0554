<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>


    <main role="main" class="container">
	
	
		<form action="privado/usuarios" method="post">
		
			<div class="form-group">
			    <label for="id">Identificador</label>
			    <input type="text" name="id" value="${usuario.id}" readonly class="form-control">			    
			</div>	
			
			<div class="form-group">
			    <label for="email">Correo Electronico</label>
			    <input type="email" name="email" value="${usuario.email}" class="form-control" placeholder="tucorreo@electronico.com">			    
			</div>
			
			<div class="form-group">
			    <label for="password">Contraseña</label>
			    <input type="password" name="password" value="${usuario.password}" class="form-control" placeholder="minimo 5 maximo 50 caracteres">			    
			</div>
			
			<input type="hidden" name="op" value="3">
			<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
		</form>
		
		<c:if test="${usuario.id > 0}">
				
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
			        ¿ Estas seguro que deseas eliminar el registro ?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			        <a href="privado/usuarios?op=4&id=${usuario.id}" class="btn btn-danger">ELIMINAR</a>
			      </div>
			    </div>
			  </div>
			</div>
		
		</c:if>
		

	</main>				


<%@ include file="../../includes/footer.jsp" %> 