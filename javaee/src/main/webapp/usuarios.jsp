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
	
	<p style="color:red"><%=request.getAttribute("mensaje")%></p>
	<h2>Crear Nuevo USuario</h2>
	<form action="usuarios" method="post">
	
	<!--  NUEVO: aseguramos los campos rellenados en caso de error-->
	
		<input type="text" name="id" value="<%=(request.getAttribute("id")==null)?"":request.getAttribute("id")%>" placeholder="identificodor"><br>

	
		<input type="text" name="email" placeholder="tu@email.com" value="<%=(request.getAttribute("email")==null)?"":request.getAttribute("email")%>"><br/>
		
	
		<input type="text" name="password" value="<%=(request.getAttribute("password")==null)?"":request.getAttribute("password")%>" placeholder="contraseña"><br>
		
		
		
		<input type="submit" value="CREAR">
	</form>