<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>

<style>
	nav{
		background-color: #CCC;
		color: #000;
		border-bottom: 3px solid BEBEBE;
		
	}
</style>

<nav>
<%

	Usuario usuarioLogueado = (Usuario)session.getAttribute("usuario_logueado");

	if(usuarioLogueado != null){
		
%>

	
		<p><%=usuarioLogueado.getEmail() %></p>
		<a href="privado/index.jsp">Zona privada</a>
		<a href="logout">Cerrar Sesion</a>
	

<% }else { %>
	<a href="login">Iniciar sesion</a>
<%} %>

</nav>