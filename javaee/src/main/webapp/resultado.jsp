<%@ include file="cabecera.jsp"  %>

<h1>Resultado</h1>


<%
	
	double resultado = (Double)request.getAttribute("resultado");


%>

<p><%= %> = <%=resultado%></p>