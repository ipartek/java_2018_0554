

<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container"> ${usuario}

<form action="privado/usuarios" method="post">

	<!-- Maquetar formulario -->

	<div class="form-group">
		<label for="id">Identificador</label> <input type="text" name="id"
			value="${usuario.id}" readonly class="form-control">
	</div>

	<div class="form-group">
		<label for="email">Correo Electornico</label> <input type="email"
			name="email" value="${usuario.email}" class="form-control"
			placeholder="tucorreo@electronico.com">
	</div>

	<div class="form-group">
		<label for="password">Contraseña</label> <input type="password"
			name="password" value="${usuario.password}" class="form-control"
			placeholder="minimo 5 maximo 50 caracteres">
	</div>

	<input type="hidden" name="op" value="3">
	<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
</form>

<c:if test="${usuario.id > 0}">
	<a href="#TODO#" class="btn btn-danger btn-block mt-4">ELIMINAR</a>
</c:if> </main>


<%@ include file="../../includes/footer.jsp"%>
