
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">JavaEE</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link"href="#"> <span class="sr-only">(current)</span></a>
          </li>
        </ul>
        <form class="form-inline mt-2 mt-md-0" action="${pageContext.request.contextPath}/desconectar" method="POST">
          <span class="nav-link text-light">${sessionScope.usuario.email}</span>
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Desconectar</button>
        </form>
      </div>
    </nav>