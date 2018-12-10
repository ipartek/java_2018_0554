<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp" %>

<h1> Noticias </h1>

<section>
    <h2>Últimas noticias</h2>
    
    <c:forEach items="${noticias.values()}" var="noticia">
    <article>
        <header>
            <h3>${noticia.titular}</h3>
        </header>
       
        <footer>
             Publicado el <time datetime="${noticia.fecha}">${noticia.fecha}</time> por ${noticia.autor} 
        </footer>
    
       <p><img src="media/noticia-${noticia.id}.jpg" alt=""></p>
        
        <p>${noticia.texto}</p>
        
        <p><a href="#">leer más</a></p>
        
    </article>
    </c:forEach>
</section>

<%@ include file="includes/pie.jsp" %>
