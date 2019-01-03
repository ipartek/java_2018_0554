<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'es_ES'}" scope="session" />



<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18nmessages" /> 

<!doctype html>
<html lang="${language}">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Acceso Privado</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
    <link href="css/gly.css" rel="stylesheet">
  </head>

  <body class="text-center">
  	
  	
  	<c:set var="cIdioma" value="${not empty cookie.cIdioma ? scookie.cIdioma.value : 'es_ES'}" scope="session" />
  
  
  
  
    <form  novalidate class="form-signin" method="post" action="login">
    
   	<h1 class="h3 mb-3 font-weight-normal text-center">Zona Privada</h1>
   	
   	<div class="mb-1">
    <label for="mail" class="sr-only">Email</label>
    <div class="input-group">
      <div class="input-group-prepend">
        <span class="input-group-text"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span>
      </div>
      <input type="email" id="mail" name=mail class="form-control"  value="${not empty cookie.cEmail ? cookie.cEmail.value : 'mail_uno@mail.com'}"  >
    </div>
  </div> 
  
  <div class="mb-1">
    <label for="pass" class="sr-only">Contraseña</label>
    <div class="input-group">
      <div class="input-group-prepend">
        <span class="input-group-text"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
      </div>
      <input type="text" class="form-control" id="pass" name="pass" placeholder="Pa$$w0rd" value="Pa$$w0rd">
    </div>
  </div>  
      
  <div class="mb-1">
    <label for="idioma" class="sr-only">Idioma</label>
    <div class="input-group">
      <div class="input-group-prepend">
        <span class="input-group-text"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span></span>
      </div>
      <select name="idioma" class="form-control">
		  <option value="es" ${(cIdioma=="eu_ES")?"selected":""}>Español</option>
		  <option value="eu" ${(cIdioma=="eu_ES")?"selected":""}>Euskera</option>
		</select>
    </div>
  </div> 
      
      
 
      
      <button class="btn btn-lg  btn-block mb-3 mt-3  btn-outline-primary" type="submit">
      <fmt:message key="login.boton" />
      </button>
      
      
    
      
	<c:if test="${error != null }">
	 <div class="alert alert-primary  alert-dismissible fade show" role="alert">
   ${error}
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  
	</c:if>
    </form>
    
    

  </body>
</html>
