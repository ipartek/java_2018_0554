<%@page import="com.ipartek.formacion.modelo.pojos.Perro"%>
<%@page import="java.util.ArrayList"%>

<h1>Listado Perros</h1>

<%
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");
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

<form action="perros" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>

<ol>
	<%
		for( Perro perro: perros){
			%>
					<li><%=perro%></li>
			<%	
		}	
	%>
</ol>