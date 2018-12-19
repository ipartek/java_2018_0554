<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");
 %>

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

	<p style="color:red">
	<% if (request.getAttribute("mensaje") != null) { %>
	
	<%= request.getAttribute("mensaje") %>
	
	<% } %>
	</p>
	<h2>Crear Nuevo Usuario</h2>
	<form action="usuarios" method="post">

		<input type="number" name="id" value="<%=(request.getAttribute("id")==null)?"":request.getParameter("id") %>">
		
		<input type="text" name="email" placeholder="tu@email.com" value="<%=(request.getAttribute("email")==null)?"":request.getParameter("email") %>">
		
		<input type="password" name="password" placeholder="Password" value="<%=(request.getAttribute("password")==null)?"":request.getParameter("password") %>">

		<input type="submit" value="CREAR">
	</form>