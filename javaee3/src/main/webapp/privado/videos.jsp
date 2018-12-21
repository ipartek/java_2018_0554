<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>


<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>





<%@ include file="../includes/mensajes.jsp"%>

<main role="main" class="container">

<%-- <c:forEach items="${videos}" var="vid">
<div class="video">

	<a href="#" class="video-link" id="${vid.url}"><img
		src="https://lineafix.store/assets/img/video-link.jpg.pagespeed.ce.iUU8y6hP14.jpg"
		alt="${vid.nombre}"></a>
	<div class="item">
		<h1>${vid.nombre}</h1>
		<p></p>

	</div>
	<iframe width="100%" height="315" src="" frameborder="0"
		allowfullscreen></iframe>
</div>
<div class="overlay"></div>
</c:forEach> --%>



<div class="video">

	<a href="#" class="video-link" id="j4raCkT63Js">Ver video</a>
	<div class="item">
		<h1>hola funciona</h1>
		<p></p>

	</div>
	<iframe width="100%" height="315" src="" frameborder="0"
		allowfullscreen></iframe>
</div>
<div class="overlay"></div>




<%-- <div class="jumbotron">
	<ol>
		<ul>
			<c:forEach items="${videos}" var="vid">
				<li>${vid.id}</li>
				<li>${vid.nombre}</li>

				<iframe width="560" height="315"
					src="https://www.youtube.com/embed/${vid.url}/embed"
					frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>

			</c:forEach>
		</ul>
</div> --%> </main>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/videos.js"></script>
<%@ include file="../includes/footer.jsp"%>