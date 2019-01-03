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

<h1>NUEVO PERRO</h1>

<form action="perros" method="post">
		
			<label for="nombre">Nombre del perro</label>
			<input type="text" name="nombre" placeholder="nombre" required autofocus>
			<br>
			<label for="raza">Raza</label>
		    <input type="text" name="raza" placeholder="raza" required>
		    <br>
		    <label for="chip">Chip (DD-DDDD-AAAA)</label>
		    <input type="text" name="chip" placeholder="chip" required>
		    <br>
		    <button type="submit" class="btn btn-success">Añadir</button>
		    <a href="principal.jsp" class="btn btn-danger">Volver</a>
		
</form>

</body>
</html>