<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>Examen Oscar</title>
    
    <base href="${pageContext.request.contextPath}/">

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
  </head>

  <body> 
<a href="privado/logout">Logout</a>

<ul>
	<li><a href="privado/saludarpost.jsp" class="btn btn-success">Saludar POST</a> (funciona)</li><br>
	<li><a href="privado/saludar?nombre=Ander&apellido=profe" class="btn btn-success">Saludar GET</a> (funciona)</li><br>
	<li><a href="privado/perros" class="btn btn-success">Listar</a> (funciona)</li><br> 
	<li><a href="privado/insertarPerro.jsp" class="btn btn-success">Nuevo perro</a> (funciona)</li><br>
</ul>

</body>
</html>