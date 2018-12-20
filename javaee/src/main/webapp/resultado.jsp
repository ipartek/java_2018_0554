<%@ include file="cabecera.jsp"  %>

<h1>Resultado</h1>


<%
	
	double resultado = (Double)request.getAttribute("resultado");


%>

<%
	int num1 = (Integer)request.getAttribute("p1");
%>

<p><%=num1 %> = <%=resultado%></p>