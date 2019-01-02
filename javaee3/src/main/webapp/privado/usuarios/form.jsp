<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container"> ${usuario }
<form action="privado/usuarios" method="post">
	<div class="form-group">
		<label for="exampleInputEmail1">Usuario (id)</label> <input
			type="number" class="form-control" id="exampleInputEmail1"
			name="id" value="${usuario.id }" readonly>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Usuario (email)</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			name="email" value="${usuario.email }"  placeholder="tu@email.com">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Contraseña</label> <input
			type="password" class="form-control" id="exampleInputPassword1"
			name="password" value="${usuario.password }" placeholder="Contraseña">
	</div>
	<input type="hidden" name="op" value="3">
	<button type="submit" class="btn btn-primary">Nuevo</button>
</form>
<c:if test="${usuario.id==-1 }">
<a href="#" class="btn btn-primary">Eliminar</a>
</c:if>

</main>


<%@ include file="../../includes/footer.jsp"%>