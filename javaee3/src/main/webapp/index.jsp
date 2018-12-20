

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">   
 
  
    <form novalidate action="login" method="post" class="form-signin">
      
      
      <label for="usuario" class="sr-only">Correo Electronico:</label>
      <input type="text" name="usuario" class="form-control" value="maria@gmail.com" placeholder="tu@email.com" required autofocus>
      
      <label for="pass" class="sr-only">Contraseña</label>
      <input type="password" name="pass" class="form-control" value="12345678" placeholder="minimo 6 caracteres" required>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
    </form>       
  

	  <div class="alert alert-danger alert-dismissible fade show" class="text-center" role="alert">
		  ${mensaje}
		    ${errores}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
	</div>   
    
    
  </body>
</html>
