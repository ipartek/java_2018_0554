<%@page import="com.ipartek.formacion.modelos.pojos.Carrito,com.ipartek.formacion.modelos.pojos.Perro, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Carrito> carritocomp = (ArrayList<Carrito>) request.getSession().getAttribute("carrito");
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
		<% if (carritocomp.size()!=0) {%>
			<%
				for (Carrito c: carritocomp) {
					Perro p= new Perro();
					p=c.getPerro();
			%>
			<tr>
				<th><%=c.getId()%></th>
				<td><%=p.getRaza()%></td>
				<td><img src="<%=p.getImagen() %>" alt="imagen <%= p.getRaza() %>"/></td>
				<td><%=p.getPrecio() %></td>
				<td><%=c.getCantidad()%></td>
				<td><%=p.getPrecio()*c.getCantidad() %></td>
			</tr>
			<%
				}
			}else{%>
			<tr>
				<td>NO</td>
				<td>EXISTEN</td>
				<td>COMPRAS</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<a href="perro">Volver</a>
</body>
</html>