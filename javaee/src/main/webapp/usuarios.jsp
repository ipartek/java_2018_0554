<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Usuario, java.util.ArrayList"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	ArrayList<Usuario> listado = (ArrayList<Usuario>) request.getAttribute("listado");
%>

<%@ include file="cabecera.jsp"%>

<h1>Usuarios</h1>

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

<hr>

<p style="color: red"><%=(request.getAttribute("mensaje")==null)?"":request.getAttribute("mensaje")%></p>


<h2>Crear nuevo usuario</h2>

<form action="usuarios" method="post">
	<input type="number" name="id" placeholder="id" value="<%=request.getAttribute("id")%>"> 
	<input type="text" name="email" placeholder="email" value="<%=(request.getAttribute("email")==null)?"":request.getAttribute("email") %>">
	<input type="password" name="pass" placeholder="contraseña" value="<%=(request.getAttribute("pass")==null)?"":request.getAttribute("pass")%>"> 
	<input type="submit" value="CREAR">
</form>














