<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>

<main role="main" class="container">
      <div class="jumbotron">
      	<form action="formperro" method="post" class="form-signin">
	      <img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
	      <h1 class="h3 mb-3 font-weight-normal">Introduce los datos</h1>
	      <label for="nombre" class="sr-only">Nombre</label>
	      	<input type="text" id="nombre" name="nombre" class="form-control" placeholder="el nombre del perro" required autofocus>
	      <label for="raza" class="sr-only">Raza</label>
	      	<input type="text" id="raza" name="raza" class="form-control" placeholder="raza del perro" required autofocus>
	   
	      <button class="btn btn-lg btn-primary btn-block" type="submit">Introducir perro</button>
  
   		 </form>
   				
		
      </div>
    </main>
    
    
    
<%@ include file="../includes/footer.jsp" %> 