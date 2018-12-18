<%@page import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<%@ include file="cabecera.jsp" %>
	<h1>
		Bienvenido a esta web
		<%= usuario.getEmail() %></h1>
<a href="videos">Ver Videos</a>	
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

</body>
</html>