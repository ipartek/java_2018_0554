<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'eu_ES'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18nmessages" /> 
<!doctype html>
<html lang="${language}">
<head>
<base href="${pageContext.request.contextPath}/">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Libreria</title>
<base href="${pageContext.request.contextPath}/">
<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="https://getbootstrap.com/docs/4.1/examples/navbar-static/navbar-top.css rel="stylesheet">
</head>

<body>
