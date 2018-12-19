<%@ include file="cabecera.jsp"  %>

<h1>Resultado</h1>


<%
	
	double resultado = (Double)request.getAttribute("resultado");


%>

<p><%=request.getParameter("p1")%> ? <%=request.getParameter("p2")%> = <%=resultado%></p>