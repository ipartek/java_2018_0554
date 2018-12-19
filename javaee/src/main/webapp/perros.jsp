<%@page import="com.ipartek.formacion.modelo.pojos.UsuarioNoValido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelo.pojos.Perro, java.util.ArrayList"%>

<%
	ArrayList<Perro> perros = (ArrayList<Perro>) request.getAttribute("perros");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="cabecera.jsp" %>
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
				for (Perro p : perros) {
			%>
			<tr>

				<th><%=p.getId()%></th>
				<td><%=p.getRaza() %></td>
				<td><%=p.getOrigen()%></td>
				<td><img src="<%=p.getImg()%>" alt=""></td>
				<td><a href="carrito?id=<%=p.getId()%>">Añadir al carrito</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>