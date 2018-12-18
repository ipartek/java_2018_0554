<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

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
	<a href="videos">MI TABLA</a>

	<table>
		<thead>
		<tr><th>LISTADO NO VALIDO</th></tr>
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
		<tr><th>LISTADO NO VALIDO</th></tr>
			<tr>
				
				<th>Email</th>

			</tr>
		</thead>
		<tbody>
			<% for(String u: listadomal) { %>
			<tr>
				
				<td><%=u.toString() %></td>
				
			</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>

<%}else{
response.sendRedirect("login");} %>