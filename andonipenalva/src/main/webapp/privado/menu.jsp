<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelos.pojos.Usuario, java.util.ArrayList"%>


<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/footer.jsp"%>
<%


	Object objeto = session.getAttribute("usuario");
	Usuario usuario = (Usuario) objeto;
	Object oUsuarios = request.getAttribute("usuarios");
	ArrayList<Usuario> usuarios = (ArrayList<Usuario>) oUsuarios;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
<main role="main" class="container">
	<h1>
		Bienvenido a esta web
		<%= usuario.getNombre() %></h1>

>
<h2>Ahora tienes acceso a los siguientes enlaces:</h2>
	<a href="listadeperros">Ver todos los perros</a>
<a href="privado/nuevoperro.jsp">Agregar nuevo perro</a>
<a href="privado/saludoformal.jsp">Te saludamos de nuevo</a>		<!-- //POST -->
<a href="SaludoController">Saludo Automático</a> 					<!-- //GET -->

</main>
</body>