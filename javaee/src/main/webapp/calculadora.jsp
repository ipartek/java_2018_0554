<%@include file="cabecera.jsp" %>
<h1>Calculadora</h1>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>



<%
	String mensaje = (String)request.getAttribute("mensaje");
	if ( mensaje  != null ){
%>	
		<p style="color:red"><%=mensaje%></p>
 <%
	} // if
 %>

<form action="calcular" method="post">

	<input type="text" name="p1">
	<br>
	<input type="text" name="p2">

	<input type="submit" value="SUMAR">

</form>