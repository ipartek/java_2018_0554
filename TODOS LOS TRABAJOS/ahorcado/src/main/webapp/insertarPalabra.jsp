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

		<H3>INSERTA UNA NUEVA PALABRA</H3>
		<form  class="form-signin" action="adivina?op=insert" method="post" action="login">
				   	  
			  	 	<div class="flex-container row "> 
					   <input class="col-xs 6"  type="text" id="letra1" name=letra1 placeholder="letra 1"  class="form-control">
					   <input class="col-xs 6"  type="text" id="letra2" name=letra2 placeholder=" letra 2"  class="form-control">
				 	</div>
				    <button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
					NUEVA PALABRA
					</button>
				
			</form>
		
		

</body>	

</html>