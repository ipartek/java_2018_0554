<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videos</title>
</head>
<body>
<h1>Listado vídeos</h1>
<% ArrayList<String> videos = (ArrayList<String>)request.getAttribute("videos");
	String busqueda = (String)request.getAttribute("videos");%>
	<%if (busqueda != null){
		%> <p>Resultad búsqueda: <b><% busqueda %></b></p>
	}
	<ol>
	<%
	for(String video: videos){
	%>
	
	<li><% video%></ol>
	<%} %>
</body>
</html>