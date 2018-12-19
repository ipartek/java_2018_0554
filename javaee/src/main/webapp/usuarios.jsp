<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>
<%@ include file="cabecera.jsp" %>
<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");

	

	ArrayList<Usuario> listado = (ArrayList<Usuario>)request.getAttribute("listado");
	
	ArrayList<String> listadomal = (ArrayList<String>)request.getAttribute("listadomal");

%>
	 
	<hr>	
	<%if(request.getAttribute("mensaje")!=null){%>
	<p style="color:red"><%=request.getAttribute("mensaje")%></p>
<% } %>	
	<h2>Crear Nuevo Usuario</h2>
	<form action="usuarios" method="post">
		<input type="text" name="id" placeholder="15" value=<%=(request.getAttribute("id")==null)?"":request.getAttribute("email") %>>
		<input type="text" name="email" placeholder="tu@email.com" value=<%=(request.getAttribute("email")==null)?"":request.getAttribute("email") %>>
		<input type="text" name="pass" placeholder="Pa$$w0rd" value=<%=(request.getAttribute("pass")==null)?"":request.getAttribute("pass") %>>
	
		<input type="submit" value="CREAR">
	</form>
	<hr>	
	<table>
		<thead>
		<tr><th>LISTADO NO VALIDO</th></tr>
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
	
		<table>
		<thead>
		<tr><th>LISTADO NO VALIDO</th></tr>
			<tr>
				
				<th>Email</th>

			</tr>
		</thead>
		<tbody>
			<% for(String u: listadomal) { %>
			<tr>
				
				<td><%=u %></td>
				
			</tr>
			<% } %>
		</tbody>
	</table>
	
	

	
