<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>

	<%@ include file="cabecera.jsp"  %>


	

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
			<% for(Usuario u: listado) { %>
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