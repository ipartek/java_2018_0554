<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>MULTOMETRO ${sessionScope.agente_logeado.apellido} </title> 
    <base href="${pageContext.request.contextPath}/">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css">

<!-- FONT AWESOME -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<!--  nuestro css -->
	<link rel="stylesheet" href="css/principal.css">
</head>
 
<body>

<header>
<nav class="navbar navbar-expand-md navbar-dark  bg-dark">
	<a class="navbar-brand  mr-auto" href="${pageContext.request.contextPath}/privado/principal"><i class="fas fa-home fa-2x"></i></a>

	
	<ul class="navbar-nav float-right">
	<li><button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#perfil" >
		 <i class="far fa-address-card"></i>
		</button>
		
	</ul>      
	
</nav>
<!-- Modal -->
	<div class="modal fade" id="perfil" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sesión Actual</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<ul class="list-unstyled mt-3 mb-4">		
					<li>Agente: ${sessionScope.agente_logeado.apellido}	</li>         	
					<li>Numero de placa: ${sessionScope.agente_logeado.placa}</li>
					<li>Departamento: ${sessionScope.agente_logeado.departamento}</li>				     
					</ul>			   
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<a href="logout" class="btn btn-info btn-block ">Cerrar Sesión </a>
				</div>
			</div>
		</div>
	</div>


</header>

