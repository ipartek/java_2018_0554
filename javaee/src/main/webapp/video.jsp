<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>

<h1>Listado Videos</h1>

<%
	ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
	String busqueda = (String) request.getAttribute("busqueda");
%>

<%
	if (busqueda != null) {
%>
<p>
	Resultado para la busqueda: <b><%=busqueda%></b>
</p>
<%
	} else {
		busqueda = "";
	}
%>

<form action="video" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>


<%
	if (videos.isEmpty()) {
%>
<p style="color: red;">No existen Videos todavia!!!</p>
<%
	} // if
%>

<ol>
	<%
		for (Video video : videos) {
	%>
	<li><%=video.getNombre()%> <iframe width="150" height="150"
			src="https://www.youtube.com/embed/<%=video.getUrl()%>"
			frameborder="0"
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe></li>
	<%
		}
	%>
</ol>