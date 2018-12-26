<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>


    <main role="main" class="container">
      <div class="jumbotron">
				<p><span class="badge badge-secondary">${pagina.autor}</span></p>
				<div class="border border-secondary p-3">${pagina.texto}</div>
				<hr>
				<p>pagina ${paginaActual+1} / ${paginasTotal} </p>			
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				    <li class="page-item"><a class="page-link" href="privado/libro?pagina=${paginaActual-1}">Anterior</a></li>			    
				    <li class="page-item"><a class="page-link" href="privado/libro?pagina=${paginaActual+1}">Siguiente</a></li>
				  </ul>
				</nav>
		</div>
	</main>				


<%@ include file="../includes/footer.jsp"  %>  