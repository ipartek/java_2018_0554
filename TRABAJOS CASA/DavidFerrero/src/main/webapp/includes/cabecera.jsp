<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="generator" content="Notepad++">
	<title>Práctica Estructura y CSS</title>
</head>

	
<body>
	
    
<header>
    <h1>
        <a href="index.html">
            <img src="media/logo.jpg" alt="Logo">
        </a>
    </h1>   
    
    <nav>
        <ul>
            <li><a href="#">Quiénes somos</a></li>
            <li><a href="#">Servicios</a></li>
            <li><a href="#">Proyectos</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Contacto</a></li>
           <li> <a href="mantenimientoservlet?id=${noticia.id}">Mantenimiento</a></li>
           <li> <a href="homeservlet?id">Home</a></li>
        </ul>
    </nav>
    
    <ul>
        <li>
            <a href="http://www.facebook.com">
                <img src="media/logo-facebook.gif" alt="Facebook">
            </a>
        </li>
        <li>
            <a href="http://www.twitter.com">
                <img src="media/logo-twitter.gif" alt="Twitter">
            </a>
        </li>
    </ul>
</header> 
    
    
    
<aside>
 
    <p><img src="media/banner.jpg" alt=""></p>  
    
</aside>
    
    