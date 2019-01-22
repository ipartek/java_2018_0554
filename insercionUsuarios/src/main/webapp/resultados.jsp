<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultados</title>
<!-- Bootstrap core CSS -->
    <link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h1>Resultados de la inserción</h1>
<div class="jumbotron">
<p class="text-info">Lineas leídas: ${lineas } = <span class="text-success">${insertadas }</span> + <span class="text-warning">${menores }</span> + <span class="text-danger">${personasIncompletas }</span></p>
<p  class="text-success">Personas insertadas: ${insertadas }</p>
<p class="text-danger">Personas incompletas: ${personasIncompletas }</p>
<p class="text-warning">Menores de edad: ${menores}</p>
<p class="text-secondary">Tiempo empleado: ${tiempo} segundos</p>
</div>
</div>
</body>
</html>