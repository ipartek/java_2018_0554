<body>
		
  <nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">Logo</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="privado/videos">Videos</a></li>
		<li><a href="#">Inicio</a></li>
		<li><a href="privado/usuarios">Usuarios</a></li>
      </ul>
	  
	  <ul class="right hide-on-med-and-down orange">
        <li>${sessionScope.usuario_logueado.email }</li>
      </ul>

      <ul id="nav-mobile" class="sidenav">
		<li class=" center orange">${sessionScope.usuario_logueado.email }</li>
        <li><a href="privado/videos">Videos</a></li>
		<li><a href="#">Inicio</a></li>
		<li><a href="privado/usuarios">Usuarios</a></li>
      </ul>
      <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
  </nav>