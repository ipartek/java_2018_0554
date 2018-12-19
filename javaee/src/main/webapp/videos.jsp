<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Video, java.util.ArrayList"%>
<%@ include file="cabecera.jsp" %>	
<% ArrayList<Video> listadoVideos = (ArrayList<Video>)request.getAttribute("listadoVideos"); %>
<% ArrayList<Video> listadoVideosbuscados = (ArrayList<Video>)request.getAttribute("listadoVideosbuscados"); %>
<%
String texto = (String)request.getAttribute("texto"); 
String placeholder="";
if(texto!=null){
	 placeholder=texto;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Videos</title>
</head>
<body>
<h1>VIDEOS</h1>
<form action="videos" method="post">
<fieldset>
<legend>Buscador</legend>
<label for="textoBuscar">Buscar
<input type="text" id="textoBuscar" name="textoBuscar" placeholder="<%=placeholder %>" />
</label>
<input type="submit" value="Buscar" />
</fieldset>
</form>


<%if(listadoVideosbuscados!=null){ %>
<%if(listadoVideosbuscados.size()!=0){ %>
<h2>Filtrado por <%=texto %> </h2>
<table>
	<thead>
	<tr>
		<th>Nombre</th>
		<th>Url</th>
		<th>Video</th>
	</tr>
	</thead>
	
	<tbody>
	<% for(Video v: listadoVideosbuscados) { %>
	<tr>
	<td><%=v.getNombre() %></td>
	<td><a target="blank" href="<%=v.getUrl() %>"><%=v.getUrl() %></a></td>
	<%
	String[] idVideo = v.getUrl().split("=");
	String id = idVideo[1];
	String enlace="https://www.youtube.com/embed/"+id;%>
	<td><iframe width="140" height="80" src="<%=enlace %>" 
	frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</td>
	<td><a href="carrito?id=<%=v.getId()%>">Al carrito</a></td>
	</tr>
	<% } %>
	</tbody>
	
</table>
<%}else {%>
	<h3>No hay resultado que coincidad con: <%=texto %> </h3>
<%}%>
	
<%} %>


<%if(listadoVideos!=null){ %>

<h2>TODOS LOS VIDEOS</h2>
<table>
	<thead>
	<tr>
		<th>Nombre</th>
		<th>Url</th>
		<th>Video</th>
	</tr>
	</thead>
	
	<tbody>
	<% for(Video v: listadoVideos) { %>
	<tr>
	<td><%=v.getNombre() %></td>
	<td><a target="blank" href="<%=v.getUrl() %>"><%=v.getUrl() %></a></td>
	<%
	String[] idVideo = v.getUrl().split("=");
	String id = idVideo[1];
	String enlace="https://www.youtube.com/embed/"+id;%>
	<td><iframe width="140" height="80" src="<%=enlace %>" 
	frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</td>
	<td><a href="carrito?id=<%=v.getId()%>">Al carrito</a></td>
	</tr>
	<% } %>
	</tbody>
	
</table>
<%} %>

</body>
</html>
