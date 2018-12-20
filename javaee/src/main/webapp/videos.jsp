
<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@  include file="cabecera.jsp" %>
<h1>Listado Videos</h1>

<%

	ArrayList<Video> videos = (ArrayList<Video>)request.getAttribute("videos");
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

<%
	if (videos.size() == 0){ //videos.isEmpty() es lo mismo que esta expresion 
%>

	<p>No existen videos en la tabla de bbdd</p>
	
<%
	}
%>

<ol>
	<%
		for( Video video: videos){
			%>
					<li><%=video.getNombre()%></li>
			<%	
		}	
	%>
</ol>

