<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="css/css.css">
    
    <title>LIBRO COMPARTIDO</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>
    <header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <h1 class="navbar-brand" href="#">Libro Compartido</h1>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item ${activohome} ">
          <a class="nav-link" href="paginas">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item ${activologin}">
       			<a class="nav-link" href=${not empty usuario_logeado.email ? "logout" : "login"}>${not empty usuario_logeado.email ? "Logout" : "Login"}</a>
        </li>
       
      </ul>
    </div>
  </nav>
</header>