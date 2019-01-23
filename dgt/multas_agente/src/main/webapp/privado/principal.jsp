<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<div class="preloader"> 
<div class="preloader_image">

</div>
</div>

<main role="main" class="container p-2">
	<div class="mt-3">
		<img class="img-responsive mx-auto d-block mb-5 mt-3" width="175px" height="200px"  src="https://pngimage.net/wp-content/uploads/2018/05/escudo-policia-nacional-espa%C3%B1a-png-1.png" alt="escudo policia">
	</div>
	<a href="privado/multas?op=irA" class="mt-6 btn btn-outline-primary btn-block btn-lg ">
		Poner una multa
	</a>
	<a href="privado/multas?op=ver&opm=todo" class="mt-6 btn btn-outline-secondary btn-block btn-lg">
		Ver todas tus multas
	</a>
	<a href="privado/multas?op=ver&opm=baja" class="mt-6 btn btn-outline-secondary btn-block btn-lg">
		Ver tus multas anuladas
	</a>
	<a href="privado/estadisticas" class="mt-6 btn btn-outline-dark btn-block btn-lg">
		Ver tus objetivos
	</a>
</main>
<%@include file="../includes/footer.jsp"%>