<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Videos"%>
<h1>Listado Videos</h1>

<%
	ArrayList<Videos> videos = (ArrayList<Videos>)request.getAttribute("videos");
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
<%@ include file="cabecera.jsp" %>
<form action="videos" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>


<%
if ( videos.isEmpty() ) {
%>
		<p style="color:red;">No existen Videos todavía!!!</p>
<%	
	} //cerrr ifa

%>

<ol>
	<%
		for( Videos video: videos){
			%>
					<li><%=video.getTitulo()%>
					<iframe width="150" 
							        height="150" 
							        src="https://www.youtube.com/embed/<%=video.getUrl()%>" 
							        frameborder="0" 
							        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
							        allowfullscreen></iframe>
					</li>
			<%	
		}	
	%>
</ol>