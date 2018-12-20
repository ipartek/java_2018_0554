<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@  include file="cabecera.jsp" %>
<%

	Usuario usuario = (Usuario)session.getAttribute("usuario_logueado");

	if(usuario != null){
		
%>

	<nav>
		<p><%=usuario.getEmail() %></p>
		<a href="logout">Cerrar Sesion</a>
	</nav>

<% }else { %>
	<a href="login.jsp">Iniciar sesion</a>
<%} %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo JSP</title>
</head>
<body>
¡Hola a todos!

<%-- Scriptlets --%>

<%= new java.util.Date() %>

<% for(int i = 1; i <= 6; i++) { %>
	<h<%=i %>>Título <%=i %></h<%=i %>>
<% } %>

</body>
</html>
