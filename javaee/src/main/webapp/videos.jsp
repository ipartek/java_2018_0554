
<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@include file="cabecera.jsp" %>
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
	if(videos.isEmpty())
	//if (videos.size()==0)
	{
		
%>
	<p style="color:red">No existen videos</p>
<% } //endif %>
<ol>
	<%
		for( Video video: videos){
			%>
					<li><%=video.getNombre()%></li>
					<iframe width="560" height="315" src="https://www.youtube.com/embed/<%=video.getUrl() %>/embed" frameborder="0" 
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
					allowfullscreen></iframe>
			<%	
		}	
	%>
</ol>

