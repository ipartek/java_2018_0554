<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Ander Solana, Daniel Zallo">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Aplicación Multas</title>

	<!-- Favicon -->
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/fee.png">

	<!-- Bootstrap core CSS -->
    <link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.2/dist/css/bootstrap.min.css">
	
    <!-- Custom styles for this template -->
    <link rel="stylesheet"
    href="https://getbootstrap.com/docs/4.2/examples/cover/cover.css">
    
    <!-- Google Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
     <link rel="stylesheet"
	href="misCss/style.css">
  </head>
<body class="text-center">
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
<main role="main" class="inner cover">
    <h1 class="cover-heading"><i class="material-icons" style="font-size:114px;">directions_car</i></h1>
    <p class="lead">Introduzca sus credenciales: </p>
    <form action="login" method="POST">
    <div class="form-group">	    
	    <label for="placa">Nº Placa: </label>
	    <input type="number" class="form-control" id="placa" name="placa" 
	    	   aria-describedby="placaHelp" placeholder="P.E: 1234" value="${placa}" required autofocus>
  	</div>
  	<div class="form-group">	    
	    <label for="password">Contraseña: </label>
	    <input type="password" class="form-control" id="password" name="password" 
	    	   aria-describedby="passwordHelp" placeholder="P.E: 12345678" value="${password}" required>
  	</div>
  	<button type="submit" class="btn btn-lg btn-secondary btn-block mb-3">
  		<span class="d-flex justify-content-center align-items-center">Acceder
      		<i class="material-icons" style="font-size:26px; margin-left:3px;">input</i>
      	</span>
    </button>
  	</form>
<%@include file="includes/mensajes.jsp" %>
<%@include file="includes/pie.jsp" %>