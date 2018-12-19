<%@page import="com.ipartek.formacion.modelo.pojos.Gato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<nav class="navbar navbar-default">
<%
	Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
	ArrayList<String> gatosComprados = (ArrayList<String>) session.getAttribute("gatosComprados");	

	if (usuarioLogueado != null) {
%>
	<div class="container-fluid bg-warning">
	<p><%=usuarioLogueado.getEmail()%></p>
	<a href="privado/index.jsp">Zona Privada</a>
	<a href="logout">Cerrar Sesión</a>
	</div>
	<table class="table">
	<thead class="thead-dark">
	<tr>
		<th>Carrito</th>
	</tr>
	</thead>
	<tbody>
	<% if(gatosComprados != null){ %>
	<% for(String g : gatosComprados){ %>
	<tr>
	<td><%=g %></td>
	</tr>
	<%} }%>
	</tbody>
	</table>
<%
	} else {
%>
<div class="container-fluid bg-warning">
<a href="login">Iniciar Sesión</a>
</div>
<%
	}
%>
</nav>