<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo JSP</title>
</head>
<body>
<%@ include file="cabecera.jsp" %>
¡Hola a todos!

<%-- Scriptlets --%>

<%= new java.util.Date() %>

<% for(int i = 1; i <= 6; i++) { %>
	<h<%=i %>>Título <%=i %></h<%=i %>>
<% } %>

</body>
</html>
