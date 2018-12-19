
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
<%@ include file="cabecera.jsp" %>
<a href="privado/index.jsp"> Zona privada </a>

<a href="calculadora.jsp"> Ejemplo Calculadora</a>
<a href="calcular"> Ejemplo Calculadora</a>
<a href="privado/index.jsp"> Zona privada </a>

	<h1>
		Bienvenido a esta web
		<%= usuario.getEmail() %></h1>
		
		
	<a href="videos">Ver Videos</a>
	<a href="videojuegos">Ver Videojuegos</a>
	<a href="usuarios">Ver usuarios</a>

</body>
</html>