<head>	
	<!-- link a CSS -->	
	<link rel="stylesheet" href="CSS/productos.css">
</head>	

	<section>  
		<!---------DATOS---------------->
		   <h1>${datosPagina.autor} </h1>        
		   <textarea rows="15" cols="40" >${datosPagina.texto}  </textarea>
		        
		<!-- numero paginacion-->
		    <p>paginacion: ${paginaActual+1} / ${paginasTotal} </p>	

		<!---------pagina atras y siguiente----------------->
		<a class="btn btn-primary" href="home?pagina=${paginaActual-1}" role="button">Atras</a>  <!-- ENLACE COMO BOTON enviar parametro con la pagina acutal para retroceder-->
		<a class="btn btn-primary" href="home?pagina=${paginaActual+1}" role="button">Siguiente</a>   <!-- enviar parametro con la pagina acutal para avanzar-->
		
	</section>	



