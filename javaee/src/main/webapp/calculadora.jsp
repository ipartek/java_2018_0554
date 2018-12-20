<h1>Calculadora</h1>


<%
	String mensaje = (String)request.getAttribute("message");
	if ( mensaje  != null ){
%>	
		<p style="color:red"><%=mensaje%></p>
 <%
	} // if
 %>

<form action="calculadora" method="post">
	
	
	<input type="text" name="op1">
	<br>
	<input type="text" name="op2">
	<br>
	<input type="submit" value="SUMAR">
	
</form>

<a href="calculadora?op1=<%=request.getParameter("op1")%>&op2=<%=request.getParameter("op2") %>">Calcular</a>