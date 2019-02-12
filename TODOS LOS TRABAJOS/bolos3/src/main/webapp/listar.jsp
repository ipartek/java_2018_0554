<%@ include file="../../includes/header.jsp"  %>

<%@ include file="../../includes/alerta.jsp"  %>

    <main role="main" class="container">
	<c:forEach items="${bolos}" var="b">  			
<!-- Modal  -->
	<div class="modal fade" id="anular${b.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Atención</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					¿ Estas serguro que deseas anular la multa ?
					<ul class="list-unstyled mt-3 mb-4">			         	
					<li>Fecha: ${b.fecha}</li>
					<li>Lugar: ${b.lugar}</li>	
					
					<li>Banda: ${b.banda1}</li>
							     
					</ul>			   
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
					<a href="bolo?op=eliminar&id=${b.id}" class="btn btn-danger">ANULAR</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
	
	
		<c:if test = "${mensaje!=null}">	
			<div class="alert alert-info alert-dismissible fade show" role="alert">
		  		<strong> ${mensaje }</strong>
			  	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			   	 	<span aria-hidden="true">&times;</span>
			  	</button>
			</div>
		</c:if>	
	
	
	
	
		<a href="nuevo.jsp" class="btn btn-outline-primary mb-2">"Nuevo Bolo"</a>
		<a href="modificar.jsp" class="btn btn-outline-primary mb-2">"Modificar Bolo"</a>
		
		<table class="table tablaOrdenable">
		  <thead class="thead-dark">
		   <tr>
		      <th scope="col">id</th>
		      <th scope="col">fecha</th>
		      <th scope="col">lugar</th>
		      <th scope="col">banda1</th>
		      <th scope="col">banda2</th>
		      <th scope="col">banda3</th>
		      <th scope="col">hora</th>		    
		      <th scope="col">Eliminar}</th>
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${bolos}" var="b">
			    <tr>		    	
			      <th scope="row">${b.id}</th>
			      <th scope="row">${b.fecha}</th>			      		      
			      <th scope="row">${b.lugar}</th>
			      <th scope="row">${b.banda1}</th>
			      <th scope="row">${b.banda2}</th>
			      <th scope="row">${b.banda3}</th>
			    
			      <th scope="row">
			      	<fmt:formatDate value="${b.fecha}" pattern="hh:mm:ss"/>
			      </th>
			      <th>
				      <button type="button" class="btn btn-outline-danger btn-block" data-toggle="modal" data-target="#anular${b.id}" >
								ANULAR
					  </button>
				  </th>
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>

	</main>				

<%@ include file="../../includes/footer.jsp"  %>  