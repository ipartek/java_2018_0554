<%@ include file="../../includes/cabecera.jsp"%>
<%@ include file="../../includes/navbar.jsp" %>

 <main role="main" class="container">
 <%@ include file="../../includes/mensajes.jsp" %>
  <h1>Resumen</h1>
      <div class="jumbotron">
     	<div class="row">
 			 <div class="col-sm-6">
  				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 					 <div class="card-header">Usuarios registrados</div>
  						<div class="card-body">
    						<p class="card-text">Actualmente hay ${totalUsuarios} registrados.</p>
   							<a href="privado/usuarios" class="btn btn-info">Usuarios</a>
  						</div>
  				</div>
  			</div>
   			 <div class="col-sm-6">
  
  				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 					 <div class="card-header">Videos registrados</div>
  						<div class="card-body">
    						<p class="card-text">Actualmente hay ${totalVideos} registrados.</p>
   							<a href="privado/videos" class="btn btn-info">Videos</a>
  						</div>
  				</div>
  			</div>
		</div>
    </div>
 </main>  
<%@ include file="../../includes/footer.jsp"%>