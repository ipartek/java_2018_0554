<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="ENDESHUSOcom.ipartek.formacion.ejemplocapas.pojos.Usuario, java.util.ArrayList"%>

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

	
	
		<h1>Bienvenido a esta web
		<%= usuario.getEmail() %></h1>
<<a href="videos">Videos online</a>

	<table>
		<thead>
			<tr>
			
			<th>Titulo</th>
			<th>URL</th>
			
				<!-- <th>ID</th>
				<th>Email</th>
				<th>Password</th> -->
			</tr>
		</thead>
		<tbody>
		
			<%  for(Video v: listadoV) {%>
			 
			 <th><% v.getTitulo()%></th>
			  <th><% v.getURL()%></th>
			 <%}%>
			<%-- <% for(Usuario u: listado) { %> --%>
			<tr>
				<<%-- th><%=u.getId() %></th>
				<td><%=u.getEmail() %></td>
				<td><%=u.getPassword() %></td> --%>
			</tr>
		<%-- 	<% } %> --%>
		</tbody>
	</table>

</body>
</html>