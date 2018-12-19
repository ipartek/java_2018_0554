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
	<%@ include file="cabecera.jsp" %>
	<h1>
		Bienvenido a esta web
		<%=usuario.getEmail()%></h1>

	<a href="privado/index.jsp">Area Privada</a>
	<a href="calculadora.jsp">Ejemplo Calculadora</a>
	<a href="libros">Ver Libros</a>
	<a href="videos">Ver Videos</a>
	<a href="usuarios">Ver Usuarios</a>

</body>
</html>