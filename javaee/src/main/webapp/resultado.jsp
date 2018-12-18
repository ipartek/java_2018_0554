<%@include file="cabecera.jsp" %>
<h1>Resultado</h1>

<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>

<%
	
	int suma = (Integer)request.getAttribute("suma");

%>

<p>Suma = <%=suma%></p>