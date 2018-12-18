<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.ipartek.formacion.modelo.pojos.Coche, java.util.ArrayList"%>
<% ArrayList<Coche> listadoCoches = (ArrayList<Coche>)request.getAttribute("coches"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Concesionario</title>
</head>
<body>
<h1>COCHES</h1>
<ul>
<%if(listadoCoches!=null){ %>
	<% for(Coche c: listadoCoches) { %>
	<li><%=c.getMarca() %></li>
	<li><%=c.getModelo() %></li>
	<li><img src="<%=c.getFoto() %>"></li>
	<% } %>
<% }else{%>
	<p>NO VA NADA</p>
<%}%>
</ul>
</body>
</html>