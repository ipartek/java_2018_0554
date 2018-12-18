<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelos.pojos.Usuario,com.ipartek.formacion.modelos.pojos.Video, java.util.ArrayList"%>

<%
	ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	String busqueda = (String) request.getAttribute("busqueda");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MIS VIDEOS</h1>
<%if(busqueda!=null && busqueda.trim().length()!=0){ %>
<p>Resultado de busqueda: <%=busqueda%></p>
<%} %>
<form action="video" method="post">
	<label for="busca">Buscar</label>
	<input type="text" name="busca" id="busca">
	<button>Buscar</button>
</form>
<table>
	<thead>
			<tr>
				<th>ID</th>
				<th>titulo</th>
				<th>Prev</th>
			</tr>
		</thead>
		<tbody>
		<% if (videos.size()!=0) {%>
			<%
				for (Video v : videos) {
			%>
			<tr>
				<th><%=v.getId()%></th>
				<td><%=v.getTitulo()%></td>
				<td><iframe width="280" height="157" src="<%=v.getUrl() %>" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
			</tr>
			<%
				}
			}else{%>
			<tr>
				<td>NO</td>
				<td>EXISTEN</td>
				<td>VIDEOS</td>
			</tr>
			<%}%>
		</tbody>
	</table>
	 
</body>
</html>