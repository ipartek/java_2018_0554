<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC4B14eczpGQrbfGNpc72jeBel2-dAEVoLkhwaVUTVoRCNYjym">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/login.css">
  </head>
  <body class="text-center">  
    <form class="form-signin" action="login" method="POST">
      <img class="mb-4" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC4B14eczpGQrbfGNpc72jeBel2-dAEVoLkhwaVUTVoRCNYjym" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">
      	Iniciar Sesión
      </h1>
      <label for="usuario" class="sr-only">Nombre de Usuario</label>
      <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Nombre de Usuario (P.E: scobby)" required autofocus>
      <label for="pass" class="sr-only">Password</label>
      <input type="password" id="pass" name="pass" class="form-control" placeholder="Contraseña (P.E: galletas)" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
      	Entrar
      </button>
     <c:if test="${mensaje != null}">
     <div class="alert alert-danger">${mensaje }</div>
     </c:if>
     <c:if test="${sesionNoIniciada != null}">
     <div class="alert alert-danger">${sesionNoIniciada }</div>
     </c:if>
    </form>
  </body>
</html>
