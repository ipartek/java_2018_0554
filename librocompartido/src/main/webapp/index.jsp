
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Leer Libros</title>

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet" href="CSS/login.css">
</head>

  <body class="text-center"> 	


    <form novalidate action="login" method="post" class="form-signin">    
    
     <c:if test="${not empty mensaje}">	  
		 <div class="alert alert-danger alert-dismissible fade show" role="alert">
		  ${mensaje}			 
		 </div>	 	
	  </c:if>   
      
      <label for="nombre" class="sr-only">Nombre</label>
      <input type="text" name="nombre" class="form-control" value="" placeholder="Nombre" required autofocus>
      
      <label for="password" class="sr-only">Contraseña</label>
      <input type="password" name="password" class="form-control" value="" placeholder="minimo 6 caracteres" required>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
    </form>

    
    
    
    
  </body>
</html>
