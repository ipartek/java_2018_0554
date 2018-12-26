<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">¡Libros Compartidos!</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse text-white" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<c:if test="${logueado.email != null}">
				<li><a class="btn btn-outline-light"
					href="usuariosLogueados">Usuarios Conectados</a></li>
				<li><a class="btn btn-outline-light"
					href="mantenimiento?accion=insertar&autor=${logueado.email}">Insertar</a></li>
			</c:if>
			<c:if test="${logueado.email == pagina.autor}">
				<li><a class="btn btn-outline-light"
					href="mantenimiento?accion=editar&pagina=${paginaActual}&texto=${pagina.texto}&autor=${logueado.email}">Editar</a></li>
				<li><a class="btn btn-outline-light"
					href="mantenimiento?accion=borrar&pagina=${paginaActual}">Borrar</a>
				</li>
			</c:if>
		</ul>
		<%-- <c:if test="${paginasTotales > 0}"> --%>
			<form action="libro" method="get">
				<input type="number" name="buscar" required>
				<input type="submit" value="Ir">
			</form>
		<%-- </c:if> --%>
		<ul class="navbar-nav">
			<li class="text-white">${logueado.email}</li>
		</ul>
		<c:choose>
			<c:when test="${logueado.email == null}">
				<a class="btn btn-outline-success"
					href="${pageContext.request.contextPath}/login">LOGIN</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn-outline-danger"
					href="${pageContext.request.contextPath}/logout">LOGOUT</a>
			</c:otherwise>
		</c:choose>
	</div>
</nav>