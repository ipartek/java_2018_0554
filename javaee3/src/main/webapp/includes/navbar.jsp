
 <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="privado/usuarios">
    <img src="imagenes/video.jpg" alt="logo" style="width:60px;">
  </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active"><a class="nav-link" href="privado/videos"><fmt:message key="navbar.videos"/></a></li>
          <li class="nav-item active">
            <a class="nav-link" href="privado/libro"><fmt:message key="navbar.libro"/></a>
          </li>  
           <li class="nav-item active">
            <a class="nav-link" href="privado/usuarios"><fmt:message key="navbar.usuario"/></a>
          </li>  
          <li class="nav-item active">
            <a class="nav-link" href="privado/disco"><fmt:message key="navbar.discos"/></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="privado/carrito.jsp"><fmt:message key="navbar.carrito"/></a>
          </li>                 
        </ul>
        <ul class="navbar-nav float-right">
        	<li><span class="badge badge-light mr-3">${usuario.email}</span></li>
        	<li><a href="logout" class="btn btn-outline-info"><fmt:message key="navbar.logout"/></a></li>
        </ul>
        
      </div>
    </nav>
    