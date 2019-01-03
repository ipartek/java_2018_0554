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

  <body class="text-center"> 	

<ol class="list-group">
		<c:forEach items="${perros}" var="perro">
			<li>${perro.nombre} - ${perro.raza} - ${perro.chip}</li>
		</c:forEach>
</ol>
<br>
<a href="principal.jsp" class="btn btn-danger">Volver</a>

</body>
</html>