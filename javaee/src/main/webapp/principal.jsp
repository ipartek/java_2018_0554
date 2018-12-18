<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelos.pojos.Usuario, java.util.ArrayList"%>

<%
	ArrayList<Usuario> usuariosok = (ArrayList<Usuario>) request.getAttribute("usuariosok");
	ArrayList<String> usuariosnook = (ArrayList<String>) request.getAttribute("usuariosnook");
	Usuario usuario = (Usuario) request.getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
<a href="video">Mi tabla</a>
<h1>BIENVENIDO <%=usuario.getEmail() %></h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Usuario u : usuariosok) {
			%>
			<tr>
				<th><%=u.getId()%></th>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPassword()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
		<tbody>
			<%
				for (String um : usuariosnook) {
			%>
			<tr>
				<th><%=um%></th>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>