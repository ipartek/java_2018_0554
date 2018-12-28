 <nav class="navbar navbar-expand-md navbar-light fixed-top bg-dark">

 
      <a class="navbar-brand" href="privado/menu.jsp">PERRÓN</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="listadeperros">Todos los perros</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="privado/saludoformal.jsp">POST</a>
          </li>
           <li class="nav-item active">
            <a class="nav-link" href="SaludoController">GET</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="privado/nuevoperro">Añadir perro</a>
          </li>
        </ul>
        ${usuario}
        <a href="/logout">LOGOUT</a>
        
      </div>
    </nav>