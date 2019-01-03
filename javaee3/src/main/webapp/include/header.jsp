<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'eu_ES'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18nmessages" />

<!doctype html>
<html lang="${language}">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title> ${usuario_logeado.email.split("@")[0].toUpperCase()}</title>
   
    <base href="${pageContext.request.contextPath}/">

   <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dashboard.css" rel="stylesheet">
	<link href="css/gly.css" rel="stylesheet">
    <!-- Custom styles for this template -->
   
  </head>

  <body>