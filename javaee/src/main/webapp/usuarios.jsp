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
	
	<p style="color:red"><%=request.getAttribute("mensaje")%></p>
	<h2>Crear Nuevo Usuario</h2>
	<form action="usuarios" method="post">
		
		<input type="text" name="id" value="<%=(request.getAttribute("id")==null)?"":request.getAttribute("id")%>" placeholder="identificodor"><br>
		<input type="text" name="email" value="<%=(request.getAttribute("email")==null)?"":request.getAttribute("email")%>" placeholder="tu@email.com"><br>
		<input type="text" name="password" value="<%=(request.getAttribute("password")==null)?"":request.getAttribute("password")%>" placeholder="contraseña"><br>
		<input type="submit" value="CREAR">
</form>
	
	

</body>
</html>