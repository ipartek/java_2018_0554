<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang=es>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	 <title>Acceso Agente</title>
	
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
<!-- FONT AWESOME -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  </head>

  <body >
	  <form  novalidate class="form-signin" method="post" action="login">
	   
	   	<h1 class="h3 mb-3 font-weight-normal">Acceso Agente</h1>
	   	
	   	  
	  	  	<div class="mb-1">
		   <label for="placa" >Agente</label>
		    <div class="input-group">
		      <div class="input-group-prepend">
		        <span class="input-group-text"><i class="fas fa-address-book"></i></span>
		      </div>
		     	<input type="text" id="placa" name=placa class="form-control" placeholder="Nº Placa: 222" value= "${not empty placa ? placa : ''}" >
		    </div>
		  </div> 
	  
		  <div class="mb-1">
		    <label for="pass" >Contraseña</label>
		    <div class="input-group">	
		     
		      <div class="input-group-prepend">
		        <span class="input-group-text">  <i class="fas fa-unlock-alt"></i>  </span>
		      </div>
		      <input type="pass" class="form-control" id="pass" name="pass" placeholder="123456" value="${not empty pass ? pass : ''}">
		    </div>
		  </div>  
	 
	      <button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
	      Acceder
	      </button>
	   
		 <c:if test="${error != null }">
			 <div class="alert alert-primary  alert-dismissible fade show" role="alert">
		   		${error}
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    	<span aria-hidden="true">&times;</span>
			  	</button>
		  	</div>
		
		  	<!-- Bootstrap core JavaScript
		    ================================================== -->
		    <!-- Placed at the end of the document so the pages load faster -->
		    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" ></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>	  
		</c:if>
	  </form>
	</body>
</html>
