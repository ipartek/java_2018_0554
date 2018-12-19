<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
<%@include file="cabecera.jsp" %>
	<h1>
		Bienvenido a esta web
		<%= usuario.getEmail() %></h1>
		
	<a href="privado/index.jsp">Zona privada</a><br>
<a href="calcular">Ejemplo Calculadora</a>	<br>
	<a href="videos">Ver Videos</a><br>
	<a href="usuarios">Ver Usuarios</a><br>
	<a href="Coche">Ver Coches</a>

	

</body>
</html>