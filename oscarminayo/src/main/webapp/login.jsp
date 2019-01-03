

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>Examen Oscar</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
  </head>

  <body class="text-center"> 	


		<form action="login" method="post" class="form-signin">
		
			<label for="user">Nombre de usuario</label>
			<input type="text" name="usuario" class="form-control" value="scobby" placeholder="usuario" required autofocus>
			
			<label for="pass">Contraseña</label>
		    <input type="password" name="pass" class="form-control" value="galletas" placeholder="contraseña" required>
		    
		    <button class="btn btn-lg btn-danger btn-block" type="submit">Entrar</button>
		
		</form>

  </body>
</html>