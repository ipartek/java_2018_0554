<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>

<style>
	nav{
		background-color: #CCC;
		color: #000;
		border-bottom:3px solid BEBEBE;
		padding: 10px;
	}
</style>

<nav>
<%
	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	if ( usuarioLogeado != null ){
%>
	
	
	<p><%=usuarioLogeado.getEmail() %></p>
	<a href="privado/index.jsp">Zona Privada</a><br>
	<a href="logout">Cerrar Session</a>
	

<% } else { %>

	<a href="login">Iniciar session</a>

<% } %>

</nav>
