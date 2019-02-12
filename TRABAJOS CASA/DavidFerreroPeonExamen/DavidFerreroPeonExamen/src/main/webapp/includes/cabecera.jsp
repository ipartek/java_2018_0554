<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- IDIOMAS -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="idioma" value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}" scope="session" /> <!--  CREAR VARIABLE -->
<fmt:setLocale value="${idioma}" />  <!-- SETEAR LOCALE -->
<fmt:setBundle basename="i18nmessages" /> <!-- CARGAR FICHERO PROPERTIES -->

<!doctype html>


<html lang="${idioma}"> <!--  INDICAR IDIOMA -->
<!-- FIN IDIOMAS -->


</head>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- link a CSS -->	
<link rel="stylesheet" href="CSS/cabecera.css">

</head>
	<header>
		<nav class="navbar navbar-expand-sm   navbar-dark bg-primary " >  <!-- kitar navbar para cambiar color y cambiar palabra secondary por otra danger es rojo por ejemplo mirar en bootstrap el problema es que deja de funcionar los colores hover y focus del css extra-->	
		  <button class= "navbar-expand-sm   navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation"></button>
		
		  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		    	<ul class="navbar-nav  mr-auto mt-2 mt-lg-0">
		      			      		
		   <!-- mostrar nombre usuario-->
				
		      		<li class="nav-item">
		        		<a class="nav-link" href="login"><span><fmt:message key="navbar.login"/></span></a>
		      		</li>
		      		
		     		 <li class="nav-item">
		        		<a class="nav-link"href="logout"><span><fmt:message key="navbar.logout"/></span></a>
		      		</li>
		      		
		      		<li class="nav-item">
		      			<a class="nav-link" href="nuevo.jsp"><span><fmt:message key="navbar.nueva"/></span></a> 
		      		</li> 
		      		
					<li class="nav-item">
					<a class="nav-link" href="home?listado=ok"><span><fmt:message key="navbar.listado"/></span></a> 	
		      		</li> 
	   	 			
					<li class="nav-item">
					<a class="nav-link" href="saludo.jsp"><span><fmt:message key="navbar.saludoP"/></span></a> 	
		      		</li> 
	   	 	
	   	 			<li class="nav-item">
					<a class="nav-link" href="saludo?nombre=David&apellido1=Ferrero&apellido2=Peon"><span><fmt:message key="navbar.saludoG"/></span></a> 	
		      		</li> 
	   	 	
		   	 	</ul>
		
				 <h5>Usuario conectado:</h5>  
				 <h3><span class="badge badge-light mr-3">${usuario.email}</span></h3>
			
		  </div>
		</nav>
	</header>
</html>
