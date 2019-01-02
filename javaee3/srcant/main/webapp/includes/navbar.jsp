
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="pral">Perrito perrón</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="pral">Catálogo <span class="sr-only">(current)</span></a>
          </li>
         <!--  <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li> -->
        </ul>
        <ul class="navbar-nav float-right">
        	<li><span class="badge badge-light mr-3">${usuario_logueado.email}</span></li>
        	<li><a href="logout" class="btn btn-outline-danger">SALIR</a></li>
        </ul>
      </div>
    </nav>

