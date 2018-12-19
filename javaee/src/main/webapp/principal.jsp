<%@page import="com.ipartek.formacion.modelo.pojos.UsuarioNoValido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<%@ include file="cabecera.jsp"%>
	<h1>
		Bienvenido a esta web
		<%=usuario.getEmail()%></h1>
	<p>
		<a href="misVideos">Mis videos</a>
	</p>
	<p>
		<a href="perros">Perros</a>
	</p>
	<p>
		<a href="usuarios">Usuarios</a>
	</p>
		
</body>
</html>