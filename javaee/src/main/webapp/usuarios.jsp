<%@page import="com.ipartek.formacion.modelo.pojos.UsuarioNoValido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	ArrayList<Usuario> listado = (ArrayList<Usuario>) request.getAttribute("listado");
	ArrayList<UsuarioNoValido> listadoNO = (ArrayList<UsuarioNoValido>) session.getAttribute("usuariosNoValidos");
%>

<%@ include file="cabecera.jsp" %>
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
	
	<hr>
	<h2>Crear un nuevo usuario</h2>
		<form action="usuarios" method="post">
			<p>
				<label for="id">Introduce el id:
					 <input type="number" id="id" name="id" value="<%=(request.getParameter("id")== null) ?"":request.getParameter("id")%>">
				</label>
			</p>
			<p>
				<label for="email">Introudce tu email:
					 <input typer="text" id="email" name="email" value="<%= (request.getParameter("email")== null) ?"":request.getParameter("email")  %>">
				</label>
			</p>
			<p>
				<label for="password">Introduce tu contraseña: 
					<input type="password" id="password" name="password" value="<%= (request.getParameter("password")== null) ?"":request.getParameter("password")%>">
				</label>
			</p>
			<p>
				<input type="submit" value="Crear" />
			</p>
			<p style="color:red"><%= request.getAttribute("errorMensajeCrear")!=null ? request.getAttribute("errorMensajeCrear") : "" %></p>
		</form>