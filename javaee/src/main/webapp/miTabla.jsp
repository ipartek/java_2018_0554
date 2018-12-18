<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ipartek.formacion.modelo.pojos.Usuario,java.util.ArrayList,com.ipartek.formacion.modelo.pojos.Video"%>
<% ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
ArrayList<Video> videosBuscados = (ArrayList<Video>) request.getAttribute("videosBuscados");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi Tabla</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="jumbotron">
<form action="videos" method="post">
	<fieldset>
		<legend>Buscar</legend>
		
		
			<label for="busqueda">Introduzca el nombre del vídeo</label>
			<input type="text" name="busqueda" id="busqueda" />
			<input type="submit" value="Buscar">
		
	</fieldset>
</form>
</div>
<% if (videos != null && videos.size() != 0){ %>
<table class="table">
		<thead class="thead-dark">
			<tr>
				<th colspan="3">TODOS LOS VÍDEOS</th>
			</tr>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>URL</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Video v : videos) {
			%>
			<tr>
				<td><%=v.getId()%></td>
				<td><%=v.getNombre()%></td>
				<td><a href="video?direccion=<%=v.getUrl()%>">Ir al video</a></td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>
	<% if(videosBuscados != null && videosBuscados.size()>0) { %>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th colspan="3">Videos encontrados</th>
			</tr>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>URL</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Video vB : videosBuscados) {
			%>
			<tr>
				<td><%=vB.getId()%></td>
				<td><%=vB.getNombre()%></td>
				<td><%=vB.getUrl()%></td>
			</tr>
			<%
				}%>
		</tbody>
	</table>
	<% }else if(videos == null && videosBuscados.size() == 0){%>
	<h1>No se han encontrado resultados para esa búsqueda</h1>
	<%} %>
</div>
</body>
</html>