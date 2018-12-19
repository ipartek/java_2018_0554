<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	ArrayList<Usuario> listado = (ArrayList<Usuario>) request.getAttribute("listado");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>

	<%@ include file="../cabecera.jsp"%>
	<a href="index.jsp">Zona Privada</a>
	<br>
	<a href="privado/videos">Videos</a>
	<br>
	<a href="privado/usuarios">Usuarios</a>
	<br>
	<h1>
		Bienvenido a esta web
		<%=usuario.getEmail()%></h1>
</body>
</html>