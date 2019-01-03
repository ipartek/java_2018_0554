<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="../cabecera.jsp"%>


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

<form action="videos" method="post">
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
	<li><%=video.getNombre()%> <iframe width="250" height="250"
			src="https://www.youtube.com/embed/<%=video.getCodigo()%>"
			frameborder="0"
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe></li>
			<a href="carrito?id=<%=video.getId()%>">Sumar al carrito</a>
	<%
		}
	%>
</ol>

