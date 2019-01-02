<%@ include file="../../includes/cabecera.jsp" %>
<%@ include file="../../includes/menu.jsp" %>
<%@ include file="../../includes/mensajes.jsp" %>

	<main role="main" class="container">
	${usuario}
		<form action="privado/usuarios" method="POST">
			
			<div class="form-group">
			    <label for="id">Identificador</label>
			    <input type="text" class="form-control" 
			    		id="id" name="id" value="${usuario.id}" readonly>
			</div>
			
			<div class="form-group">
			    <label for="email">Correo Electrónico</label>
			    <input type="email" class="form-control" 
			    		id="email" name="email" value="${usuario.email}" 
			    		placeholder="nombre@email.com">
			</div>
			
			<div class="form-group">
			    <label for="password">Contraseña</label>
			    <input type="password" class="form-control" 
			    		id="password" name="password" value="${usuario.password}"
			    		placeholder="Mínimo 6 y Máximo 50 caracteres">
			</div>
			
			<input type="hidden" name="op" value="3">
			<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
		</form>
		
		<c:if test="${usuario.id > 0}">
			<a class="btn btn-danger btn-block mt-4" href="#TODO#">ELIMINAR</a>
		</c:if>
	
	</main>

<%@include file="../../includes/pie.jsp"%>