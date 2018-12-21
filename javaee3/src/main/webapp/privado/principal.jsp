<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="../logout">Salir de la sesion</a>
	<h1>BENVENUTE</h1>
	
	${usuarioLogeado.email}
	
	<ol>
	<c:forEach items="${videos}" var="v">
		${v.Nombre}
		
		<iframe width="150" 
									        height="150" 
									        src="https://www.youtube.com/embed/${v.Url}" 
									        frameborder="0" 
									        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
									        allowfullscreen></iframe>
	
	</c:forEach>
	</ol>
</body>
</html>