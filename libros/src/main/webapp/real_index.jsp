<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Pagina"%>

<p>AUTOR: ${pagina.autor}</p>
<textarea>${pagina.texto}</textarea>


<hr>

<p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>

<a href="index?pagina=${paginaActual+1}">Siguiente</a>
<a href="index?pagina=${paginaActual-1}">Anterior</a>
