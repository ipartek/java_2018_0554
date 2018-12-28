<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>

<main role="main" class="container">
      <div class="jumbotron">
      	<form action="saludar" method="post" class="form-signin">
	      <img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
	      <h1 class="h3 mb-3 font-weight-normal">Introduce los datos</h1>
	      <label for="nombre" class="sr-only">Nombre</label>
	      	<input type="text" id="nombre" name="nombre" class="form-control" placeholder="el nombre" required autofocus>
	      <label for="raza" class="sr-only">Apellido</label>
	      	<input type="text" id="apellido" name="apellido" class="form-control" placeholder="el apellido" required autofocus>
	   
	      <button class="btn btn-lg btn-primary btn-block" type="submit">Mostrar</button>
  
   		 </form>
   				
		
      </div>
    </main>
    
    
    
<%@ include file="../includes/footer.jsp" %> 