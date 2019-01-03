<%@ include file="../../includes/cabecera.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container p-3 ">
 <%@ include file="../../includes/mensajes.jsp" %>

<div class="jumbotron">

	<form action="privado/usuarios" method="post">
		<div class="form-group">
	    	<label for="id">Identificador</label>
	   		<input type="text" class="form-control" id="id"name="id" value="${usuario.id}" readonly>
	  	</div>
		<div class="form-group">
		    <label for="email">Email</label>
		    <input type="email" class="form-control" id="email"name="email"  value="${usuario.email}" placeholder="tucorreo@electronico.com">
		</div>
	  	<div class="form-group">
	    	<label for="password">Password</label>
	    	<input type="password" class="form-control" id="password"name="password" value="${usuario.password}"placeholder="Mínimo 5 Máximo 50 carácteres">
	  	</div>
		<div class="form-group">
	    	<input type="hidden" class="form-control" id="op" name="op" value="3">
	  	</div>
		
	  <button type="submit" class="btn btn-primary btn-block">Guardar</button>
	</form>
	<c:if test="${usuario.id > 0}">
		<button type="button" class="btn btn-outline-danger btn-block mt-4" data-toggle="modal" data-target="#exampleModal">
 			Eliminar
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
		        ¿Estas seguro que deseas eliminar el registro?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
		       <a href="privado/usuarios?op=4&id=${usuario.id}" class="btn btn-danger ">Eliminar</a>
		      </div>
		    </div>
		  </div>
		</div>
	
	
		
	</c:if>
</div>
</main>

<%@ include file="../../includes/footer.jsp"%>