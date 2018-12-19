<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<Usuario> listado = (ArrayList<Usuario>) request.getAttribute("listado");
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

<h2>Crear Nuevo Usuario</h2>
<form action="usuarios" method="post">
	<p>
		<label for="id">id</label> <input type="number" name="id" id="id"
			value="<%=(request.getAttribute("id") == null) ? "" : request.getAttribute("id")%>"
			placeholder="42" />

	</p>
	<p style="color: red"><%=request.getAttribute("mensajeId") == null ? "" : request.getAttribute("mensajeId")%></p>
	<p>
		<label for="email">Email</label> <input type="email" name="email"
			id="email"
			value="<%=(request.getAttribute("email") == null) ? "" : request.getAttribute("email")%>"
			placeholder="tu@email.com" />
	</p>
	<p>
		<label for="password">Password</label> <input type="password"
			name="password" id="password"
			value="<%=(request.getAttribute("password") == null) ? "" : request.getAttribute("password")%>"
			placeholder="!A3b2c1" />
	</p>
	<p>
		<button>Login</button>
	</p>
	<p style="color: red"><%=request.getAttribute("mensajeGrave") == null ? "" : request.getAttribute("mensajeGrave")%></p>
	<p style="color: red"><%=request.getAttribute("mensajePojo") == null ? "" : request.getAttribute("mensajePojo")%></p>
</form>