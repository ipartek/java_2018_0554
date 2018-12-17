<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

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

	<h1>
		Bienvenido a esta web
		<%= usuario.getEmail() %></h1>

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