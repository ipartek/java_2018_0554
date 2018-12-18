<%@page import="com.ipartek.formacion.modelo.pojos.UsuarioNoValido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Video, java.util.ArrayList"%>

<%
	ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("misVideos");
	Video videoBuscar = (Video) request.getAttribute("video");
	String busqueda = (String) request.getAttribute("busqueda");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="cabecera.jsp" %>
	<p>
	<h2>Busca tu video</h2>
	</p>
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
	<p>
	<form action="misVideos" method="post">
		<label for="nombreVideo"> Introduce el nombre del video: <input
			type="text" id="nombreVideo" name="nombreVideo" value="<%=busqueda%>">
		</label>
		<button>Buscar</button>
	</form>
	</p>

	<p>
	<h2>Mis Videos</h2>
	</p>
	<%
		if (videos.size() != 0) {
	%>
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
				<td><iframe width="150" height="150"
						src="https://www.youtube.com/embed/<%=v.getUrl()%>"
						frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<%
		} else {
	%>
	<p>No se ha encontrado ningun video con ese nombre</p>
	<%
		}
	%>
	<a href="login">VOLVER</a>
</body>
</html>