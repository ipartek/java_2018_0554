<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>¡Libro Compartido!</title>
</head>
<body>
	<h1>¡Libro Compartido!</h1>
		<span>Autor: ${autor}</span>
		<textarea>${texto}</textarea>
		<p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>
		<a href="libro?pagina=${paginaActual-1}">Página anterior</a> <a href="libro?pagina=${paginaActual+1}">Siguiente página</a>
</body>
</html>