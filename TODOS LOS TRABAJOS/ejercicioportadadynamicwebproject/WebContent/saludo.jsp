<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${saludo != null}">
	<h1>Saludo = ${saludo}</h1>
</c:if>
<c:if test="${saludo == null}">
	<h1>No se ha recibido saludo</h1>
</c:if>
</body>
</html>