<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>
<%@ include file="cabecera.jsp" %>
<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
if(usuario!=null){
	

	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");
	
	ArrayList<String> listadomal = (ArrayList<String>)request.getAttribute("listadomal");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>

	<h1>
		Bienvenido a esta web
		<%= usuario.getEmail() %>
	</h1>
	<ul>
	<li><a href="videos">VIDEOS</a></li>
	<li><a href="coches">COCHES</a></li>
	<li><a href="calcular">CALCULADORA</a></li>
	<li><a href="usuarios">USUARIOS</a></li>
	</ul>

	

</body>
</html>

<%}else{
response.sendRedirect("login");} %>