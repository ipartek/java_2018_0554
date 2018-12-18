<%@page import="java.util.ArrayList"%>

<h1>Listado Videos</h1>

<%
	ArrayList<String> videos = (ArrayList<String>)request.getAttribute("videos");
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

<form action="videos" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>

<ol>
	<%
		for( String video: videos){
			%>
					<li><%=video%></li>
			<%	
		}	
	%>
</ol>