<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Coches</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
</head>
<body>
	<div class="container">
		<h1>WEB SERVICE SOAP COCHES</h1>
		<div class="jumbotron">
		<h2>Documentación: </h2>
		  <dl class="list-group">
	         <dt class="list-group-item">
	         	<span class="p-1"><i class="fas fa-circle"></i></span>obtenerDatos():</dt>
			        <dd class="pl-5">Este servicio devuelve un coche cuya matrícula se recibe por parámetros.</dd>
			        <dd class="pl-5">Retorna: El coche con la matrícula indicada o null en caso de que no exista.</dd>
		     <dt class="list-group-item">
		     	<span class="p-1"><i class="fas fa-circle"></i></span>End Point (WSDL):</dt>
		     		<dd class="pl-5"><a href="http://localhost:8080/wssoap/services/WSVehiculo?wsdl" class="btn btn-info mt-2">Consultar</a></dd>
	      </dl>
		</div>
	</div>
</body>
</html>