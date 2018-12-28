<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<main role="main" class="container">
   <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">Usuario: ${usuario_logeado.email}</h1>
      <p>
      	<a class="btn btn-primary btn-lg" href="privado/saludarpost" role="button">Saludar Post</a>
    	<a class="btn btn-primary btn-lg" href="privado/saludarget" role="button">Saludar Get</a>
      	<a class="btn btn-primary btn-lg" href="privado/perros" role="button">Listar Perros</a>
      	<a class="btn btn-primary btn-lg" href="privado/nuevoperro.jsp" role="button">Nuevo Perro</a>
      </p>
    </div>
  </div>
</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.2/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="https://getbootstrap.com/docs/4.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script></body>
</html>
