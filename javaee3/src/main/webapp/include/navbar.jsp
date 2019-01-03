
	<header>
	      <nav class="navbar navbar-expand-md navbar-dark  bg-dark fixed-top">
      <a class="navbar-brand" href="privado/principal">JAVAEE3</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
         <li class="nav-item active">
            <a class="nav-link" href="privado/usuarios"><fmt:message key="navbar.usuarios"/></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="privado/video"><fmt:message key="navbar.videos"/></a>
          </li>
          
          
        </ul>
        <ul class="navbar-nav float-right">
        	<li><span class="badge badge-info mr-3 font-weight-normal">${sessionScope.usuario_logeado.email}</span></li>
        	<li><a href="logout" class="btn btn-outline-info"><span class="glyphicon glyphicon-off"></span> <fmt:message key="navbar.logout"/></a></li>
        </ul>
        
      </div>
    </nav>
	</header>
	<%@ include file="../include/sidebar.jsp"%>
	
	