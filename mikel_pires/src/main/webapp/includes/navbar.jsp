
<nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<div class="btn-group" role="group">
			<button id="btnGroupDrop1" type="button"
				class="btn btn-outline-info dropdown-toggle" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">
				${usuario_logeado.email}</button>
			<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				<a class="dropdown-item" href="privado/principal.jsp">Volver al
					inicio<a>
						<div class="dropdown-divider"></div> <a class="dropdown-item"
						href="logout">Cerrar sesion</a>
			</div>
		</div>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="privado/saludar_datos.jsp">Saludar (Get y Post)</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="privado/listado.jsp">Listar perros (y + detalles)</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="privado/nuevo.jsp">Nuevo perro</a></li>

		</ul>



	</div>
</nav>
