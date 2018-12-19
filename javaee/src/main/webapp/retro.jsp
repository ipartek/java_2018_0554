
<%@page import="com.ipartek.formacion.modelo.pojos.Retro"%>
<%@page import="java.util.ArrayList"%>




<h1>Lista de juegos retro</h1>

<%
	ArrayList<Retro> juegos = (ArrayList<Retro>)request.getAttribute("juegos");
	String busqueda = (String)request.getAttribute("busqueda");
%>

<% 
	if ( busqueda != null ){ //si encuentra registros
		%>
			<p>Resultado para la busqueda: <b><%=busqueda%></b></p>
		<% 
	}else{
		busqueda = "";
	}
%>

<form action="juegos" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>


<%
	if ( juegos.isEmpty() ) {
%>
	<p style="color:red;"> No existen Videos todavia!!!</p>
<%
	} // if
%>

<ol>
	<%
		for( Retro retro: juegos){
			%>
					<li>
							<%=retro%>
							
					
					</li>
			<%	
		}	
	%>
</ol>
