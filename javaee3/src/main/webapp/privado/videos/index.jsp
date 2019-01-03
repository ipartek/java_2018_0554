<%@ include file="../../include/header.jsp"  %>
<%@ include file="../../include/navbar.jsp"  %>
<%@ include file="../../include/mensajes.jsp"  %>


    <main role="main">
	<div class="jumbotron">
	<div class="container">
	 <h1 class="display-5">VIDEOS</h1>
	 <a href="privado/cvideos?op=2&id=-1" class="btn btn-outline-success mb-2">Insertar nuevo video</a>
	 <%-- 
     <form class="form-inline" method="post" action="privado/videos">
	  <div class="form-group mx-sm-3 mb-2">
	    <label for="textobuscar" class="sr-only">Buscador por texto</label>
	    <input type="text" class="form-control" id="textobuscar" name="textobuscar" placeholder="Rallye">
	  </div>
	  <button type="submit" class="btn btn-primary mb-2"><fmt:message key="buscar.boton" /></button>
	</form>
	--%>
 		
 		 <div class="row">
          <c:forEach items="${videos}" var="video">
           	<div class="col-md-4">
              <div class="card mb-4 shadow-sm">
              	<div class="embed-responsive embed-responsive-16by9">
					 	 <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/${video.codigo}" allowfullscreen></iframe>
				</div>
                <div class="card-body">
                  <p class="card-text">${video.titulo.toUpperCase()}</p>
                  <div class="d-flex justify-content-between align-items-center">
                   
                   </div><!-- /d-flex justify-content-between align-items-center -->
                  </div><!-- /card-body -->
              </div><!-- /card mb-4 shadow-sm -->
            </div><!-- /col-md-4" -->
            
           </c:forEach>  
            
          </div><!-- /row -->
          
       <table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">Titulo</th>
		      <th scope="col">Codigo</th>		      
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${videos}" var="video">
			    <tr>
			      <th scope="row">${video.id}</th>
			      <td><a href="privado/usuarios?op=2&id=${video.id}">${video.titulo}</a></td>
			      <td>${video.codigo}</td>		      
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>
       
       
     	
    </div><!-- /container -->
	</div> <!-- /jumbotron -->
	</main><!-- /main -->			


<%@ include file="../../include/footer.jsp"  %>  