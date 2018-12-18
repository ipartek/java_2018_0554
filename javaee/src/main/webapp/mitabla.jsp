<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="cabecera.jsp" %>

<h1>Videos</h1>
<%
ArrayList<String> videos = (ArrayList<String>)request.getAttribute("videos");
String busqueda = (String)request.getAttribute("busqueda");
%>
<%
	if(busqueda != null){
		%>
			<p>Resultado para la busqueda: <b><%=busqueda%></b></p>
		<%
	}
%>
<form action="mitabla" method="post">
	<input type="text" name="busqueda"  value=<%=busqueda%>required>
	<input type="submit" value="filtrar">
</form>

	<ol>
		<%
			for(String video: videos){
				%>
					<li><%=video%></li>
				<%
			}
		%>
	</ol>
</body>
</html>