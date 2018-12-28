    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="#">Opciones</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="btn btn-outline-primary mr-3" href="saludars?met=post">Saludar POST</a>
      </li>
      <li class="nav-item active">
        <a class="btn btn-outline-primary mr-3" href="saludars?met=get">Saludar GET </a>
      </li>
      <li class="nav-item active">
        <a class="btn btn-outline-primary mr-3" href="perros">Listar </a>
      </li>
      <li class="nav-item active">
        <a class="btn btn-outline-primary " href="privado/nuevoperro.jsp">Nuevo Perro </a>
      </li>
    </ul>
    		<ul class="navbar-nav float-right align-middle">
			<li><span class="badge badge-light mr-3 ">${usuario.usuario}</span></li>
			<c:choose>
				<c:when test="${usuario.usuario!=null}">
					<li><a href="logout" class="btn btn-outline-danger">LOGOUT</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="index.jsp" class="btn btn-outline-success">LOGIN</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
  </div>
</nav>