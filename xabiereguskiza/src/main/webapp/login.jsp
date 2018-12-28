<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
<html lang="es_Es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>Login_Perros</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="CSS/login.css" rel="stylesheet">
  </head>

  <body class="text-center"> 	
  
   <form novalidate action="login" method="post" class="form-signin"> 
    
     <c:if test="${not empty mensaje}">	  
		 <div class="alert alert-danger alert-dismissible fade show" role="alert">
		  ${mensaje}			 
		 </div>	 	
	  </c:if>   
      
      <label for="nombre">Usuario:</label>
      <input type="text" name="nombre" class="form-control" value="scobby" placeholder="Usuario" required autofocus>
      
      <label for="pass">Contraseña:</label>
      <input type="password" name="password" class="form-control" value="galletas" placeholder="minimo 6 caracteres" required>
      
      
      
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
  </form>
    
  </body>
</html>