<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario,java.util.ArrayList,com.ipartek.formacion.modelo.pojos.UsuarioNoValido"%>

<%
	 	/* Object objeto = request.getAttribute("usuario");
		Usuario usuario = (Usuario) objeto;  */
		
		Usuario usuario = (Usuario) request.getAttribute("usuario");

		/* Object oUsuarios = request.getAttribute("listado");
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) oUsuarios; */
		
		ArrayList<Usuario> listado = (ArrayList<Usuario>) request.getAttribute("listado");
		ArrayList<UsuarioNoValido> listadoNoValido = (ArrayList<UsuarioNoValido>) request.getAttribute("listadoNoValido");

	/* Object oNoValidos = request.getAttribute("noValidos");
	ArrayList<UsuarioNoValido> noValidos = (ArrayList<UsuarioNoValido>) oNoValidos;   */
%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Principal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h1>Bienvenido <%= usuario.getEmail() %></h1>
<h2><a href="videos">Mi Tabla</a></h2>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th colspan="4">VÁLIDOS</th>
			</tr>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Password</th>
				<th>GitHub</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Usuario u : listado) {
			%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getGitHub()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	 
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th colspan="4">NO VÁLIDOS</th>
			</tr>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Password</th>
				<th>GitHub</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (UsuarioNoValido unv : listadoNoValido) {
			%>
			<tr>
				<td><%=unv.getId()%></td>
				<td><%=unv.getEmail()%></td>
				<td><%=unv.getPassword()%></td>
				<td><%=unv.getGitHub()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table> 
</div>
</body>
</html>