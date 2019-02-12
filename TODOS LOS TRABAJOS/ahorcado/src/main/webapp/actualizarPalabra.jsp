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

    <title>Actualizar Palabra</title>

    <!-- Bootstrap core CSS  DFDFDF-->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
<!-- FONT AWESOME -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <link rel="stylesheet" href="css/styles.css">
  
  </head>
	
	
<body>

		<p>CAMBIA LA PALABRA QUE QUIERES QUE ADIVINEN</p>
		<form  class="form-signin" action="adivina?id=1&op=update" method="post" action="login">
				   	  
			  	 	<div class="mb-1"> 
					   <input type="text" id="letra1u" name=letra1u placeholder="letra 1u"  class="form-control">
					   <input type="text" id="letra2u" name=letra2u placeholder=" letra 2u"  class="form-control">
				 	</div>
				    <button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
					ACTUALIZAR PALABRA
					</button>
				
			</form>
		
		
		<label class="alert alert-info alert-dismissible fade show" >${letra1}</label>
		<label class="alert alert-info alert-dismissible fade show" >${letra2}</label>
		
	

</body>	

</html>