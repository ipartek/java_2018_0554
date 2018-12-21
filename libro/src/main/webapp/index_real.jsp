<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<p>AUTOR: ${pagina.autor}</p>
<textarea>${pagina.texto}</textarea>


<hr>

<p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>

<a href="index?pagina=${paginaActual+1}">Siguiente</a>
<a href="index?pagina=${paginaActual-1}">Anterior</a>
  