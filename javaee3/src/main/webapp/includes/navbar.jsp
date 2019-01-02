<link href="https://getbootstrap.com/docs/4.2/examples/navbar-fixed/navbar-top-fixed.css" rel="stylesheet">
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">APP</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse text-white" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/videos">Videos</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/albumes">Albumes</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/privado/usuarios">Usuarios</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="list-unlisted text-white">${usuarioLogueado.email}</li>
		</ul>
		<c:choose>
			<c:when test="${usuarioLogueado.email != null}">
				<li><a class="btn btn-outline-danger"
					href="${pageContext.request.contextPath}/logout">LOGOUT</a></li>
			</c:when>
			<c:otherwise>
				<li><a class="btn btn-outline-primary"
					href="${pageContext.request.contextPath}/login">LOGIN</a></li>
			</c:otherwise>
		</c:choose>
	</div>
</nav>