

<%@ include file="../include/header.jsp"%>
<%@ include file="../include/navbar.jsp"%>
	
    <main role="main">
	<div class="jumbotron">
	<div class="container">
	 <h1 class="display-3">Principal</h1>
     <form class="form-inline" method="post" action="privado/videos">
	  <div class="form-group mx-sm-3 mb-2">
	    <label for="textobuscar" class="sr-only">Buscador por texto</label>
	    <input type="text" class="form-control" id="textobuscar" name="textobuscar" placeholder="Rallye">
	  </div>
	  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
	</form>
 		
 		 <div class="row">
          <c:forEach items="${videos}" var="video">
           	<div class="col-md-4">
              <div class="card mb-4 shadow-sm">
              	<div class="embed-responsive embed-responsive-16by9">
					 	 <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/${video.url.split("=")[1]}" allowfullscreen></iframe>
				</div>
                <div class="card-body">
                  <p class="card-text">${video.nombre.toUpperCase()}</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="button" class="btn btn-sm btn-outline-secondary">Añadir</button>
                    </div><!-- /btn-group -->
                   </div><!-- /d-flex justify-content-between align-items-center -->
                  </div><!-- /card-body -->
              </div><!-- /card mb-4 shadow-sm -->
            </div><!-- /col-md-4" -->
            
           </c:forEach>  
            
          </div><!-- /row -->
          
       
     	
    </div><!-- /container -->
	</div> <!-- /jumbotron -->
	</main><!-- /main -->
	
	
<%@ include file="../include/footer.jsp"%>
