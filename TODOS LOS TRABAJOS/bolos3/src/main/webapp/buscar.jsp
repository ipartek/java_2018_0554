<%@ include file="../../includes/header.jsp"  %>

<%@ include file="../../includes/alerta.jsp"  %>

    <main role="main" class="container">
	
		<c:if test = "${mensaje!=null}">	
			<div class="alert alert-info alert-dismissible fade show" role="alert">
		  		<strong> ${mensaje }</strong>
			  	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			   	 	<span aria-hidden="true">&times;</span>
			  	</button>
			</div>
		</c:if>		
		
		<table class="table tablaOrdenable">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">fecha</th>
		      <th scope="col">lugar</th>
		      <th scope="col">banda1</th>
		      <th scope="col">banda2</th>
		      <th scope="col">banda3</th>		    
		      <th scope="col">${info}</th>
		    </tr>
		  </thead>
		  <tbody>
	
			    <tr>		    	
			      <th scope="row">${boloBuscar.id}</th>
			      <th scope="row">${boloBuscar.fecha}</th>			      		      
			      <th scope="row">${boloBuscar.lugar}</th>
			      <th scope="row">${boloBuscar.banda1}</th>
			      <th scope="row">${boloBuscar.banda2}</th>
			      <th scope="row">${boloBuscar.banda3}</th>			 
			      <th scope="row">${boloBuscar.info}"</th>
			    </tr>    
		 
		  </tbody>
		</table>

	</main>				

<%@ include file="../../includes/footer.jsp"  %>  