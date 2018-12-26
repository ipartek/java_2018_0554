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
				    <li class="page-item"><a class="page-link" href="privado/libro?pagina=${paginaActual}">Anterior</a></li>			    
				    <li class="page-item"><a class="page-link" href="privado/libro?pagina=${paginaActual+2}">Siguiente</a></li>
				  </ul>
				  
		<c:if test="${busqueda!=null }">
			
		
		
		</c:if>		  
				  <form class="form-inline mt-2 mt-md-0" action="privado/libro" method="get" >
            <input class="form-control mr-sm-2" type="text" placeholder="Buscar" aria-label="Buscar" name="pagina" value="${paginaActual+1}" required>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="buscar">Buscar</button>
          </form>
          
				</nav>
		</div>
		
	<hr>
	
	<h2>Escribir nueva página</h2>
	<form action="privado/libro" method ="post">
	<input type="text" name="autor" value="${usuario.email}"><br>
	<textarea name="texto" placeholder="minimo 50 caracteres"></textarea><br>
	<input type="submit" name="Nueva" value="Nueva">
	
	</form>
		
		
	</main>				


<%@ include file="../includes/footer.jsp"  %>  