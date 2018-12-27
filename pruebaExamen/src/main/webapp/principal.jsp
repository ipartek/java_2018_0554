<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>
<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
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
		<%= usuario.getEmail() %></h1>

<a href="videos">Ver todos los videos</a>

<h2>Estos son los datos de los usuarios que nos has proporcionado</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<% for(Usuario u: usuarios) { %>
			<tr>
				<th><%=u.getId() %></th> 
				<td><%=u.getEmail() %></td>
				<td><%=u.getPassword() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</main>
</body>