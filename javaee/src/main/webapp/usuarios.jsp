<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");
ArrayList<String> listadoNo = (ArrayList<String>)request.getAttribute("listadoNo");
 %>
	 <h2>Usuarios válidos</h2>
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
	
		<input type="number" name="id" value="<%=(request.getAttribute("id")==null)?"":request.getAttribute("id")%>" placeholder="id">
		<input type="email" name="email" value="<%=(request.getAttribute("email")==null)?"":request.getAttribute("email")%>" placeholder="tu@email.com">
		<input type="text" name="pass" value="<%=(request.getAttribute("pass")==null)?"":request.getAttribute("pass")%>" placeholder="tu contraseña">
	
		<input type="submit" value="CREAR">
	</form>