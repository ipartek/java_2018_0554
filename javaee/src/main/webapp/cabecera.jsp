<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
	nav{
		background-color: #ccc;
		color: #fff;
		border-bottom: 3px solid #bebebe;
	}
</style>
<nav>
<%
Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");

if ( usuarioLogeado != null){
%>

	<p><%=usuarioLogeado.getEmail() %></p>
	<a href="privado/index.jsp">Zona privada</a>
	<a href="logout">Cerrar sesion</a>
	

<% } else{ %>
<a href="login">Iniciar sesion</a>
<% }//else %>
</nav>