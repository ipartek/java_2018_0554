<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="idioma" value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}" scope="session" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="i18nmessages" /> 

<!doctype html>
<html lang="${idioma}">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>Videos</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="CSS/login.css" rel="stylesheet">
  </head>

  <body class="text-center"> 	
  
  <!-- leer cookie para Idioma -->	  
      <c:set var="cIdioma" value="${not empty cookie.cIdioma ? cookie.cIdioma.value : 'es_ES'}" scope="session" />
      
  	<p>Idioma por defecto: ${cookie.cIdioma.value}</p>
  
    <form novalidate action="login" method="post" class="form-signin">    
    
     <c:if test="${not empty mensaje}">	  
		 <div class="alert alert-danger alert-dismissible fade show" role="alert">
		  ${mensaje}			 
		 </div>	 	
	  </c:if>   
      
      <label for="email" class="sr-only">Correo Electronico:</label>
      <input type="email" name="email" class="form-control" value="xabier@ipartek.com" placeholder="tu@email.com" required autofocus>
      
      <label for="pass" class="sr-only">Contraseña</label>
      <input type="password" name="pass" class="form-control" value="Pa$$w0rd" placeholder="minimo 6 caracteres" required>
      
      <label for="idioma">Selecciona un Idioma</label>
      <select name="idioma" class="form-control mb-5">
      <option value="eu_ES" ${(cIdioma=="eu_ES")?"selected":""}>Euskera</option>
      <option value="es_ES" ${(cIdioma=="es_ES")?"selected":""}>Castellano</option>
      </select>
      
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
    </form>

    
  </body>
</html>
