<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

  <body> 

<form action="saludar" method="post">
		
			<label for="nombre">Escribe tu nombre</label>
			<input type="text" name="nombre" placeholder="nombre" required autofocus>
			<br>
			<label for="apellido1">Apellido1</label>
		    <input type="text" name="apellido1" placeholder="primer apellido" required>
		    <br>
		    <label for="apellido2">Apellido2</label>
		    <input type="text" name="apellido2" placeholder="segundo apellido" required>
		    <br>
		    <button type="submit" class="btn btn-success">Mostrar</button>
		    <a href="principal.jsp" class="btn btn-danger">Volver</a>
		
</form>

</body>
</html>
