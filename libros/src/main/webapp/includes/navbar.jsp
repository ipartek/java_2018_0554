  
  <nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="privado/videos"><fmt:message key="navbar.videos"/></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="privado/libro"><fmt:message key="navbar.libro"/></a>
          </li>  
           <li class="nav-item active">
            <a class="nav-link" href="privado/listado.jsp"><fmt:message key="navbar.listado"/></a>
          </li>          
        </ul>
           <div class="btn-group" role="group">
    <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      ${usuario.email}
    </button>
    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      <a class="dropdown-item" href="logout"><fmt:message key="navbar.cerrarsesion"/></a>

    </div>
  </div>
      
        
      </div>
    </nav>
