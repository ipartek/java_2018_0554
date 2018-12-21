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
				href="videos">Videos</a></li>
		</ul>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="albumes">Albumes</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="text-white">${usuarioLogueado.email}</li>
		</ul>
		<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/logout">LOGOUT</a>
	</div>
</nav>