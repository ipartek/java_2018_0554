<%@page import="com.ipartek.formacion.modelo.pojos.Gato"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%ArrayList<Gato> gatos = (ArrayList<Gato>) request.getAttribute("gatos"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gatos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<%@include file="cabecera.jsp" %>
<div class="container">
<div class="jumbotron">
<h1>TODOS LOS GATOS</h1>
<% for(Gato g : gatos){ %>
<div class="col-lg-6 col-offset-6 centered">
<h3 class="cover-heading"><%= g.getRaza() %></h3>
<p class="lead">Nombre: <%= g.getNombre() %></p>
<p class="lead">Color: <%= g.getColor() %></p>
<p class="lead">Peso: <%= g.getPeso() %> kgs</p>
<img src="<%=g.getImagen() %>" width="250px" height="200px">   
<a href="comprar?id=<%=g.getId() %>" class="btn btn-success">Comprar</a>    
</div>
<% } %>
</div>
</div>
</body>
</html>