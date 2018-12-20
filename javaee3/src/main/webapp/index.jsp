<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LOGIN BRUTAL</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form  novalidate class="form-signin" method="post" action="login">
    	
    	<!-- 
      <img class="mb-4" src="img/logo.jpg" alt="" width="100" height="100">
      <h1 class="h3 mb-3 font-weight-normal">LOGIN BRUTAL</h1>
      -->
      
      <label for="mail" class="sr-only">Email</label>
      <input type="email" id="mail" name=mail class="form-control"  value="ima@gmail.com">
      
      <label for="pass" class="sr-only">Contraseña</label>
      <input type="password" id="pass" name="pass" class="form-control" value="Pa$$w0rd" >
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
      
	<c:if test="${error != null }">
     <div class="alert alert-warning alert-dismissible fade show" role="alert">
 		${error}
	</div>
	</c:if>
    </form>
    
    

  </body>
</html>
