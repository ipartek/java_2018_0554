<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Principal</title>
</head>
<body>
<h1>Usuario logueado con éxito</h1>
<p>${sessionScope.usuario_logueado.getEmail()}</p>
</body>
</html>