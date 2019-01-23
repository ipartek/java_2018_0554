<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
					<h1 class="masthead-brand">
						<a href="${pageContext.request.contextPath}/privado/index.jsp"><img src="../img/fee64.png"></a><small>${sessionScope.agenteLogueado.nombre}</small>
					</h1>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarCollapse" aria-controls="navbarCollapse"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarCollapse">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item">
								<a class="btn btn-secondary btn-block m-2" href="${pageContext.request.contextPath}/privado/matricula">
									<span class="d-flex justify-content-center align-items-center">Multar
	    								<i class="material-icons" style="font-size:26px; margin-left:3px;">fiber_new</i>
	    							</span>
    							</a>
							</li>
							<li class="nav-item">
								<a class="btn btn-secondary btn-block m-2" href="${pageContext.request.contextPath}/privado/listado">
									<span class="d-flex justify-content-center align-items-center">Ver Multas
							      		<i class="material-icons" style="font-size:26px; margin-left:3px;">info_outline</i>
							      	</span>
     							 </a>
							</li>
							<li class="nav-item">
								<a class="btn btn-secondary btn-block m-2" href="${pageContext.request.contextPath}/privado/multa?op=4">
									<span class="d-flex justify-content-center align-items-center">Ver Multas Anuladas
							      		<i class="material-icons" style="font-size:26px; margin-left:3px;">info</i>
							      	</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="btn btn-danger btn-block m-2" href="${pageContext.request.contextPath}/logout">
									<span class="d-flex justify-content-center align-items-center">Cerrar sesión
							      		<i class="material-icons" style="font-size:26px; margin-left:3px;">exit_to_app</i>
							      	</span>
								</a>
							</li>
						</ul>
					</div>
				</nav>
			</div>
		</header>