<%@ include file="../../includes/cabecera.jsp" %>
<%@ include file="../../includes/menu.jsp" %>
<%@ include file="../../includes/mensajes.jsp" %>

	<main role="main" class="container">

	<div class="row">
	
		<div class="col-6">
	<h2>Información del vídeo</h2>
		<form action="privado/videos" method="POST">
			
			<div class="form-group">
			    <label for="id">Identificador</label>
			    <input type="text" class="form-control" 
			    		id="id" name="id" value="${video.id}" readonly>
			</div>
			
			<div class="form-group">
			    <label for="nombre">Nombre</label>
			    <input type="text" class="form-control" 
			    		id="nombre" name="nombre" value="${video.nombre}"
			    		minlength="5" maxlength="150" 
			    		placeholder="Título del vídeo">
			</div>
			
			<div class="form-group">
			    <label for="codigo">Codigo</label>
			    <input type="text" class="form-control" 
			    		id="codigo" name="codigo" value="${video.codigo}"
			    		minlength="11" maxlength="11"
			    		placeholder="Código de 11 dígitos de YouTube">
			</div>
			
			<div class="form-group">
				<label for="id_usuario">Seleccionar Usuario</label>
				<select name="id_usuario" id="id_usuario">
					<c:forEach items="${usuarios}" var="u">
					<option value="${u.id}">${u.email}</option>
					</c:forEach>
				</select>
			</div>
			
			<input type="hidden" name="op" value="3">
			
			<div class="btn-group btn-group-lg" role="group">
			
			<button type="submit" class="btn btn-outline-primary">GUARDAR</button>
		</form>
		
				<c:if test="${video.id > 0}">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#exampleModal">
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
					        ¿ Estás seguro de que deseas eliminar el registro ?
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					        <a href="privado/videos?op=4&id=${video.id}" class="btn btn-danger">ELIMINAR</a>
					      </div>
					    </div>
					  </div>
					</div>
				</c:if>
			</div>
			</div>
			<div class="col-6">
				<iframe width="560" height="315" src="https://www.youtube.com/embed/${video.codigo}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>

	</main>

<%@include file="../../includes/pie.jsp"%>