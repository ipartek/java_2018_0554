
<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/mensajes.jsp"%>


<main role="main" class="container"> ${usuario}

<form action="privado/videos" method="post">

	<!-- Maquetar formulario -->

	<div class="form-group">
		<label for="id">Identificador</label> <input type="text" name="id"
			value="${video.id}" readonly class="form-control">
	</div>

	<div class="form-group">
		<label for="nombre">Correo Electornico</label> <input type="text"
			name="nombre" value="${video.nombre}" class="form-control"
			placeholder="tucorreo@electronico.com">
	</div>

	<div class="form-group">
		<label for="codigo">Contraseña</label> <input type="text"
			name="codigo" value="${video.codigo}" class="form-control"
			placeholder="minimo 5 maximo 50 caracteres">
	</div>

	<input type="hidden" name="op" value="3">
	<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
</form>

<c:if test="${video.id > 0}">
	<a href="#TODO#" class="btn btn-danger btn-block mt-4">ELIMINAR</a>
</c:if> </main>


<%@ include file="../../includes/footer.jsp"%>
