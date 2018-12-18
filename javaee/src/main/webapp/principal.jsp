<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");
	ArrayList<String> listadoNo = (ArrayList<String>)request.getAttribute("listadoNo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
<a href="videos">Videos</a>
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
			<% for(Usuario u: listado) { %>
			<tr>
				<th><%=u.getId() %></th>
				<td><%=u.getEmail() %></td>
				<td><%=u.getPassword() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	<table>
		<thead>
			<tr>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<% for(String u: listadoNo) { %>
			<tr>
				<td><%=u %></td>
			</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>