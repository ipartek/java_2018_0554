<%@ include file="cabecera.jsp"  %>

<h1>Resultado</h1>


<%
	
	int suma = (Integer)request.getAttribute("suma");
%>

<p>Suma = <%=suma%></p>
