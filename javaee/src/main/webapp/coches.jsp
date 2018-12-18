
<%@page import="com.ipartek.formacion.modelo.pojos.Coche"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@include file="cabecera.jsp" %>
<h1>Listado Coches</h1>

<%

	ArrayList<Coche> coches = (ArrayList<Coche>)request.getAttribute("coches");
	String busqueda = (String)request.getAttribute("busqueda");

%>

<% 
	if ( busqueda != null ){
		%>
			<p>Resultado para la busqueda: <b><%=busqueda%></b></p>
		<% 
	}else{
		busqueda = "";
	}
%>

<form action="Coche" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>
<%
	if(coches.isEmpty())
	//if (videos.size()==0)
	{
		
%>
	<p style="color:red">No existen videos</p>
<% } //endif %>
<ol>
	<%
		for( Coche coche: coches){
			%>
					<li><%=coche%></li>

			<%	
		}	
	%>
</ol>

