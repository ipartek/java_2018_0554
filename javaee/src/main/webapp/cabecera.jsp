<%@page import="com.ipartek.formacion.modelo.pojos.Gato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<nav class="navbar navbar-default">
<%
	Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
	ArrayList<Gato> gatosComprados = (ArrayList<Gato>) session.getAttribute("gatosComprados");	

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
		<th>Carrito de la compra de la puta madre de dani</th>
	</tr>
	</thead>
	<tbody>
	<% if(gatosComprados != null){ %>
	<% for(Gato g : gatosComprados){ %>
	<tr>
	<td><%=g.getRaza() + " - " + g.getNombre() %></td>
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