<h1>Calculadora</h1>

<%
	String mensaje = (String)request.getAttribute("mensaje");
	if ( mensaje  != null ){
%>	
		<p style="color:red"><%=mensaje%></p>
 <%
	} // if
 %>


<form action="calcular" method="post">
	<input type="number" name="op1"> <input type="number"
		name="op2"> <input type="submit" value="resultado">
</form>

<p>
	<a href="login">Volver a inicio</a>
</p>