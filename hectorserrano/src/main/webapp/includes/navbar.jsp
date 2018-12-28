<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">Examen</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse text-white" id="navbarCollapse">
		<ul class="nav">
			<li class="nav-item text-white">Bienvenido ${logueado.usuario}</li>
		</ul>
		<ul class="nav">
			<li class="text-white btn btn-outline-primary disabled"><a class="nav-item" href="#">Saludos</a></li>
		</ul>
		<ul class="nav">
			<li class="text-white btn btn-outline-primary disabled"><a class="nav-item" href="#">Perros</a></li>
		</ul>
		<c:choose>
			<c:when test="${logueado.usuario == null}">
				<a class="btn btn-outline-success float-right"
					href="${pageContext.request.contextPath}/login">LOGIN</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn-outline-danger float-right"
					href="${pageContext.request.contextPath}/logout">LOGOUT</a>
			</c:otherwise>
		</c:choose>
	</div>
</nav>