<%@include file="../includes/cabecera.jsp"%>

<body class="text-center">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h1 class="cover-heading">ERROR 404</h1>
			</div>
		</header>
		<main role="main" class="inner cover">
		<h2 class="cover-heading">
			<i class="material-icons" style="font-size: 114px;">error</i>
		</h2>
		<h5>Lo sentimos, la página a la que intenta acceder no existe o
			su dirección ha sido modificada :(</h5>
		<div class="error-actions">
			<a href="${pageContext.request.contextPath}/privado/index.jsp" class="btn btn-primary btn-lg"> 
				<span class="d-flex justify-content-center align-items-center">Inicio
	    			<i class="material-icons" style="font-size:26px; margin-left:3px;">home</i>
	    		</span>
    		</a>
			<a href="${pageContext.request.contextPath}/privado/index.jsp" class="btn btn-warning btn-lg"> 
			<span class="d-flex justify-content-center align-items-center">Contactar con el soporte
	    			<i class="material-icons" style="font-size:26px; margin-left:3px;">contact_mail</i>
	    		</span>
    		</a>
		</div>

		<%@include file="../includes/pie.jsp"%>