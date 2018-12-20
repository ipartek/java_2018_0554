<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Perro"%>

<%@  include file="cabecera.jsp" %>

<%

	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");
	String busqueda = (String)request.getAttribute("busqueda");

%>

<h1>Listado perros</h1>

<ol>
	<%
		for( Perro perro: perros){
			%>
					<li><%=perro.getNombre() + " " + perro.getRaza() + " " + perro.getChip()%></li>
			<%	
		}	
	%>
</ol>