<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="#"><fmt:message key="navbar.videos"/></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="login">
						Inicio
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active">
				<a class="nav-link" href="privada/saludar_post.jsp">Saludar.POST</a>
				</li>
				<li class="nav-item active">
				<a class="nav-link" href="privada/saludar_get.jsp">Saludar.GET</a>
				</li>
				<li class="nav-item active">
				<a class="nav-link" href="privada/perros">Listar</a>
				</li>
			</ul>
			<ul class="navbar-nav mr-auto border border-success">
			<li class="nav-item">
            <i class="fa fa-user-o fa-2x text-success" aria-hidden="true"></i>
          	</li>
          	<li class="nav-item">
          	<span class="text-warning">${sessionScope.usuario_logueado.nombre }</span>
          	</li>
			</ul>
			<c:choose>
			    <c:when test="${sessionScope.usuario_logueado!=null}">
			    <a href="privada/alta.jsp" class="btn btn-outline-primary my-2 my-sm-0">Nuevo Perro</a>
			    <form class="form-inline mt-2 mt-md-0" action="logout" method="POST">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerrar Sesión</button>
				</form>   
				</c:when>    
			</c:choose>
		</div>
	</nav>