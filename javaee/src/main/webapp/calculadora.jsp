<%@page import="javax.swing.ButtonGroup"%>
<%@page import="javax.swing.JRadioButton"%>

<%@ include file="cabecera.jsp"  %>
<h1>Calculadora</h1>


<%
	String mensaje = (String)request.getAttribute("mensaje");
	if ( mensaje  != null ){
%>	
		<p style="color:red"><%=mensaje%></p>
 <%
	} // if
 %>

<form action="calcular" method="get">

	<%-- <%
		JRadioButton radio1 = new JRadioButton("suma");
		JRadioButton radio2 = new JRadioButton("resta");
		JRadioButton radio3 = new JRadioButton("multiplicacion");
		JRadioButton radio4 = new JRadioButton("division");
	%>
	<%
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		group.add(radio4);
	%> --%>


	<input type="text" name="p1"> <p><%=request.getAttribute("error") %></p>
	<br>
	<br>
	<input type="text" name="p2">
	<ul>
	
	<li> + <input type="radio" name="operacion" value="suma" /></li>
	<li> - <input type="radio" name="operacion"  value="resta"  /></li>
	<li> * <input type="radio" name="operacion" value="multiplicacion" /></li>
	<li> / <input type="radio" name="operacion" value="division" /></li>
</ul>
<!-- 	<input type="submit" value="SUMAR"> -->

<input type="submit" value="RESULTADO">

</form>