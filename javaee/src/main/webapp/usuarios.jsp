<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%

	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
	
	<hr>
	<p style="color:red"><%=request.getAttribute("mensaje") %></p>
	<h2>Nuevo usuario</h2>
	<form action="usuarios" method="post">
	ID<input type="number" name="id" value="<%=request.getAttribute("idValue") %>"><br>
	EMAIL<input type="text" name="email" placeholder="email@email.com" value="<%=request.getAttribute("emailValue") %>"><br>
	PASSWORD<input type="password" name="password" value="<%=request.getAttribute("passwordValue") %>">

		<input type="submit" value=Enviar>
	</form>
</body>
</html>