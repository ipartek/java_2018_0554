 <body class=container>
  
    <nav class="navbar navbar-expand-md navbar-light  fixed-top bg-light ">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/login">APP</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item">
        <a class="nav-link" href="privado/saludarpost">Saludar Post</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="privado/saludarget">Saludar Get</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="privado/perros">Listar Perros</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="privado/nuevoperro.jsp">Nuevo Perro</a>
      </li>
    </ul>
    <a href="logout">${usuario_logeado.email} - LOGOUT</a>
	      </div>
  </div>
</nav>