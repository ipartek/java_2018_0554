<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Principal ${usuario_logeado.email.split("@")[0].toUpperCase()}</title>

   <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
  </head>

  <body>
	<header>
	    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	      <a class="navbar-brand" href="#">${usuario_logeado.email}</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	
	      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
	        <ul class="navbar-nav mr-auto">
	          <li class="nav-item">
	            <a class="nav-link" href="../logout">Cerrar Sesion</a>
	          </li>
	      </div>
	    </nav>
	</header>
	
	
    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Principal</h1>
          <table>
          
          <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>VIDEO</th>
          </tr>
          
      	 <c:forEach items="${videos}" var="video">
      	 <tr>
          <td>${video.id}</td>
          <td>${video.nombre}</td>
          <td>
          	<iframe width="160" 
			height="90" 
			src="https://www.youtube.com/embed/${video.url.split("=")[1]}" 
			rameborder="0" 
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
			allowfullscreen>
			</iframe>
          </td>
          </tr>
   			 
		</c:forEach>       
          
          </table>
        </div>
      </div>
	</div> <!-- /container -->

    </main>

    <footer class="container">
      <p>&copy; Company 2017-2018</p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
