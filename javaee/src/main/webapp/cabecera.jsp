<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
	nav{
		background-color: #ccc;
		color:#000;
		margin-bottom: 3px solid BEBEBE;
	}
</style>
<% 

Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");

if(usuarioLogeado !=  null){ %>
	<nav>
		<p><%=usuarioLogeado.getEmail() %></p>
		<a href="logout">Cerrar sesion</a>
	</nav>

<%} //cierre if 
else{  %>
<a href="login">Iniciar sesion</a>
<%} //cierre else %>
