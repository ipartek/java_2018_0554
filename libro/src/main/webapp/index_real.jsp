<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
   ${alerta}
   
<p>AUTOR: ${pagina.autor}</p>
<textarea>${pagina.texto}</textarea>


<hr>

<p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>

<a href="index?pagina=${paginaActual}">Anterior</a>
<a href="index?pagina=${paginaActual+2}">Siguiente</a>

<form action="index" method="get">
	<input type="text" name="pagina" value="${paginaActual+1}" required>
	<input type ="submit" value="buscar">
</form>

<hr>

<h2>Escribir nueva pagina</h2>

<form action="index" method="post">
			<input type="text" name="autor"><br>
			<textarea name="texto" placeholder="minimo 10 caracteres"></textarea><br>
			<input type="submit" value="Nueva">
</form>