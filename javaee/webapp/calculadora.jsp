<%@page import="javax.swing.ButtonGroup"%>
<%@page import="javax.swing.JRadioButton"%>

<%@ include file="cabecera.jsp"  %>

<style>

	li{
	list-style-type:none;
	}

</style>
<h1>Calculadora</h1>


<%
	String mensaje = (String)request.getAttribute("mensaje");
	if ( mensaje  != null ){
%>	
		
 <%
	} // if
 %>

<form action="calcular" method="post">



	<input type="number" name="p1"> 
	<br>
	<input type="number" name="p2">
<%-- 	<span style="color:red"><%=request.getAttribute("error") %></span> --%>
	
	<ul>
	
	<li>SUMAR<input type="radio" name="operacion" value="suma" /></li>
	<li>RESTAR<input type="radio" name="operacion"  value="resta"  /></li>
	<li>MULTIPLICAR<input type="radio" name="operacion" value="multiplicacion" /></li>
	<li>DIVIDIR<input type="radio" name="operacion" value="division" /></li>
</ul>
<!-- 	<input type="submit" value="SUMAR"> -->

<input type="submit" value="RESULTADO"><input type="reset" value="BORRAR">

</form>