<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/alerta.jsp"  %>

	
<body>
<main class="container">
	
	<c:if test = "${mensaje!=null}">	
			<div class="alert alert-info alert-dismissible fade show" role="alert">
		  		<strong> ${mensaje }</strong>
			  	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			   	 	<span aria-hidden="true">&times;</span>
			  	</button>
			</div>
		</c:if>			
			
			<section>
		<a href="bolo?op=listar" class=" btn btn-outline-primary btn-block">listar </a>
			</section>

	
			<form action="bolo?op=buscar" method="post">
			
				<div class="form-group">
				    <input type="number" name="id"  id="id" placeholder="id" class="form-control">			    
				</div>	
				
				<button type="submit" class="btn btn-primary btn-block">Buscar por ID</button>
		</form>
		
	
<div class="btn-group">
  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Buscar Bolo fecha
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="bolo?op=fecha&fecha=2019">2019</a>
    <a class="dropdown-item" href="bolo?op=fecha&fecha=2018">2018</a>
    <a class="dropdown-item" href="bolo?op=fecha&fecha=2017">2017</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="bolo?op=fecha&fecha=2016">2016</a>
  </div>
</div>
		
		
		
		
</main>

<%@ include file="../../includes/footer.jsp"  %>  