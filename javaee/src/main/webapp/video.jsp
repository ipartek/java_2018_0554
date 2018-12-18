<%@page import="com.ipartek.formacion.modelo.pojos.UsuarioNoValido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Video, java.util.ArrayList"%>

<%
	ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("misVideos");
	Video videoBuscar= (Video)request.getAttribute("video");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busca tu vídeo</title>
</head>
<body>
	<p>
		<h2>Busca tu video</h2>
	</p>
	<p>
	<form action="misVideos" method="post">
		<label for="nombreVideo"> Introduce el nombre del video:<input type="text" id="nombreVideo"
			name="nombreVideo" value="noriyaro">
		</label>
		<button>Buscar</button>
		<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
		
	</p>
	<% if(videoBuscar !=null){ %>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Url</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th><%=videoBuscar.getId()%></th>
				<td><%=videoBuscar.getNombre()%></td>
				<td><%=videoBuscar.getUrl()%></td>
			</tr>

		</tbody>
	</table>
	<% } %>
	<p>
	<h2>Mis Videos</h2>
	</p>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Url</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Video v : videos) {
			%>
			<tr>
				<th><%=v.getId()%></th>
				<td><%=v.getNombre()%></td>
				<td><%=v.getUrl()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>