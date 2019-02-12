<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang=es>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ahorcado</title>

    <!-- Bootstrap core CSS  DFDFDF-->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
<!-- FONT AWESOME -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <link rel="stylesheet" href="css/styles.css">
  
  </head>
	
	
<body>
<main class="container">
		<c:if test="${not empty acierto}">	
		
		<h1>HAS GANADO</h1>
			<div class="alert alert-info alert-dismissible fade show flex-container" role="alert">
				<strong>La palabra correcta es <span class= "respuesta">${letra1}${letra2}</span></strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		
			<form  class="form-signin" action="adivina?id=1&op=jugar" method="post" action="login">
				<button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
					VOLVER A EMPEZAR
				</button>
			</form>
		</c:if>
		
		<c:if test="${empty acierto}">		
		   <section class = "flex-row" >
		   		<h1>Ahorcado</h1>
		   	
			   	<div class="col-sm-6">
					<div class="flex-container alert alert-info alert-dismissible fade show mensaje" role="alert">
						<strong  >${mensaje}</strong>
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
			   	
				   	<div class="col-sm-6 flex-container ">
					  	<div  id="ahorcado" class="fallo${contador}"></div> 
					  	<script src="js/main.js"></script> 
					</div>
				</div>		
			</section>
			
			<section>
			  <ul class="pagination pagination-xs flex-container">
			    <li class="page-item" aria-current="page">
			      <span class="page-link">
			        ${contador}
			        <span class="sr-only">(current)</span>
			      </span>
			    </li>
			    <li class="page-item "><a class="page-link" href="#">${maxInt}</a></li>
			   
			  </ul>
			</section>
			
			<section>
				<form  class="form-signin" action="adivina?id=1&op=jugar" method="post" action="login">
					<c:if test="${contador!=7}">   	  
				  	 	<div class="row "> 
						   <input class="col-sm 8" type="text" id="letra1" name=letra1 placeholder="letra 1"  class="form-control">
						   <input class="col-sm 4" type="text" id="letra2" name=letra2 placeholder=" letra 2"  class="form-control">
					 	</div>
					    <button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
							PROBAR SUERTE
						</button>
					</c:if>
					<c:if test="${contador==7}">   	
			 			<button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
							VOLVER A EMPEZAR
						</button>
					</c:if>
				</form>
			</section>

		
		
		<a href="actualizarPalabra.jsp" class="btn btn-outline-success mb-2">CAMBIAR PALABRA</a>
		
				   	  
			  	 	
				   
				
			
		
		
		<label class="alert alert-info alert-dismissible fade show" >${letra1}</label>
		<label class="alert alert-info alert-dismissible fade show" >${letra2}</label>
		
		</c:if>
</main>
</body>	

</html>