<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="includes/cabecera.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANTENIMIENTO</title>
</head>
<body>



<table style="width:100%">

  <tr>
    <th>ID</th>
    <th>TITULAR</th> 
    <th>FECHA</th>
    <th>AUTOR</th>
	<th>TEXTO</th>
	<th>EDITAR</th>
	
  </tr>
  <c:forEach items="${noticias.values()}" var="noticia">
  <tr>
    <td>${noticia.id}</td>
    <td>${noticia.titular}</td> 
    <td>${noticia.fecha}</td>
    <td>${noticia.autor}</td>
     <td>${noticia.texto}</td>
     <td><a href="borrarnoticiaservlet?accion=borrar&id=${noticia.id}">Borrar</a></td>
    <td><a href="guardarnoticiaservlet?accion=borrar&id=${noticia.id}">Guardar</a></td>
  </tr>
</c:forEach> 
</table>


</body>
</html>