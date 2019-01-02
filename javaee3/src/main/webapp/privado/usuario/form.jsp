<%@ include file="../../includes/cabecera.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container p-3 ">
 <%@ include file="../../includes/mensajes.jsp" %>
 ${usuario}
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
		<a href="privado/usuarios?op=4&id=${usuario.id}" class="btn btn-danger btn-block mt-4">Eliminar</a>
	</c:if>
</div>
</main>

<%@ include file="../../includes/footer.jsp"%>