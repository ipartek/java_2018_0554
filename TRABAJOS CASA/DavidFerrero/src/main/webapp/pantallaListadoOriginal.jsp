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
             	${noticia.fecha}
             	
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
    	<a href="formularionoticia?accion=insertar=">Añadir</a>  <!--  AQUI LLAMA A JSP NOTICIA -->
    </p>
</section>  
    
    
<footer>
    <nav>
     <h3>FOOTER</h3>
        <ul>
            <li><a href="#">Quiénes somos</a></li>
            <li><a href="#">Servicios</a></li>
            <li><a href="#">Proyectos</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Contacto</a></li>
            <li><a href="#">Mantenimiento</a></li>
            
        </ul>
    </nav>
    
    <ul>
        <li><a href="#">Aviso Legal</a></li>
        <li><a href="#">Privacidad</a></li>
        <li><a href="#">Cookies</a></li>
    </ul>
    
    <p>Copyright 2018</p>
    
</footer>
    
</body>
</html>