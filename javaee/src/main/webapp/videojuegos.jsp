<%@page import="com.ipartek.formacion.modelo.pojos.VideoJuego"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIDEOJUEGOS</title>

</head>
<body>

<%@ include file="cabecera.jsp" %>
<h1>LISTADO VIDEOJUEGOS</h1>

<%
	ArrayList<VideoJuego> videojuegos = (ArrayList<VideoJuego>)request.getAttribute("videojuegos");
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

<form action="videojuegos" method="post">
	<input type="text" name="busqueda" value="<%=busqueda%>" required>
	<input type="submit" value="filtrar">
</form>

<%
	if ( videojuegos.isEmpty() ) {
%>
	<p style="color:red;"> No existen Videojuegos todavia!!!</p>
<%
	} // if
%>

<table border=1>
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Compania</th>
		<th>Imagen</th>
	</tr>


	<%
		for( VideoJuego videojuego: videojuegos){
			%>
					<tr>
							<td><%=videojuego.getId()%></td>
							<td><%=videojuego.getNombre()%></td>
							<td><%=videojuego.getCompania()%></td>
							<td><img width="200px" height="140px" src="<%=videojuego.getImagen()%>" alt="imagen"></td>
							<td><a href="carrito?id">Comprar</a></td>
					<tr>
					
			<%	
		}	
	%>
</table>
</body>
</html>