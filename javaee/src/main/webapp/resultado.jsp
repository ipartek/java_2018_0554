<%@ include file="cabecera.jsp"  %>

<h1>Resultado</h1>


<%
	
	double resultado = (Double)request.getAttribute("resultado");


%>

<%
String valor1 = request.getParameter("p1");
String valor2 = request.getParameter("p2");
%>


<p><%=valor1 %> (+ - * /) <%=valor2 %> = <%=resultado%></p>