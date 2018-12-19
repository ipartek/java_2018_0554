<%@page import="com.ipartek.formacion.modelos.pojos.Perro, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Perro> carrito = (ArrayList<Perro>) request.getSession().getAttribute("carrito");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="cabecera.jsp" %>
 
<h1>MIS PERROS EN CARRITO</h1>

<table>
	<thead>
			<tr>
				<th>ID</th>
				<th>raza</th>
				<th>Imagen</th>
				<th>Precio /u</th>
				<th>Cantidad</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
		<% if (carrito.size()!=0) {%>
			<%
				for (Perro p : carrito) {
			%>
			<tr>
				<th><%=p.getId()%></th>
				<td><%=p.getRaza()%></td>
				<td><img width=150 height=150 src="<%=p.getImagen()%>" alt="Imagen <%=p.getRaza()%>"></td>
				<td><%=p.getPrecio()%></td>
				<td><%=p.getRaza()%></td>
				<td><%=p.getRaza()%></td>
			</tr>
			<%
				}
			}else{%>
			<tr>
				<td>NO</td>
				<td>EXISTEN</td>
				<td>COMPRAS</td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>