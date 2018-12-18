<%@page import="com.ipartek.formacion.modelo.pojos.UsuarioNoValido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	ArrayList<Usuario> listado = (ArrayList<Usuario>) request.getAttribute("listado");
	ArrayList<UsuarioNoValido> listadoNO = (ArrayList<UsuarioNoValido>) request.getAttribute("usuariosNoValidos");
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
		<%=usuario.getEmail()%></h1>
	<p>
		<a href="misVideos">Mis videos</a>
	</p>
	<h2>Usuarios validos</h2>
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
				for (Usuario u : listado) {
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
	</table>

	<h2>
		Usuarios NO validos
		</h1>
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
					for (UsuarioNoValido u : listadoNO) {
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
		</table>
</body>
</html>