<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String direccion = (String) request.getParameter("direccion"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<iframe width="560" height="315" 
src="https://www.youtube.com/embed/<%=direccion %>" 
frameborder="0" allow="accelerometer; 
autoplay; encrypted-media; gyroscope; 
picture-in-picture" allowfullscreen>
</iframe>
<h1><a href="videos">Volver a todos los vídeos</a></h1>
</body>
</html>