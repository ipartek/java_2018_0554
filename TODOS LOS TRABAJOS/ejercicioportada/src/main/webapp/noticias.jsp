<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp" %>

<section>
    <h2>Últimas noticias</h2>
    
    <c:forEach items="${noticias.values()}" var="noticia">
    <article>
        <header>
            <h3>${noticia.titular}</h3>
        </header>
       
        <footer>
             Publicado el
             <time datetime="${noticia.fecha}">
             	<fmt:formatDate pattern = "dd.MM.yy HH:mm:ss" value = "${noticia.fecha}" />
             </time>
             por ${noticia.autor} 
        </footer>
    
        <p><img src="media/noticia-${noticia.id}.jpg" alt=""></p>
        
        <p>${noticia.texto}</p>
        
        <p>
        	<a href="#">leer más</a>
        	<a href="formularionoticia?accion=editar&id=${noticia.id}">Editar</a>
        	<a href="formularionoticia?accion=borrar&id=${noticia.id}">Borrar</a>
        </p>
        
    </article>
    </c:forEach>
    
    <p>
    	<a href="formularionoticia?accion=insertar">Añadir</a>
    </p>
</section>

<%@ include file="includes/pie.jsp" %>
