<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">¡Libros Compartidos!</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse text-white" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
		</ul>
		<ul class="navbar-nav">
			<li class="text-white">${usuarioLogueado.email}</li>
		</ul>
		<c:choose>
			<c:when test="${usuarioLogueado.email == null}">
				<a class="btn btn-outline-primary"
					href="${pageContext.request.contextPath}/login">LOGIN</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn-outline-primary"
					href="${pageContext.request.contextPath}/logout">LOGOUT</a>
			</c:otherwise>
		</c:choose>
	</div>
</nav>