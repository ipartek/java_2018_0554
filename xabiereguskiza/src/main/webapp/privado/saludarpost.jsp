<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>


<form action="saludarpost" method="post" class="form-inline" role="form">
  <div class="form-group">
  
  <c:if test="${not empty mensaje}">	  
		 <div class="alert alert-danger alert-dismissible fade show" role="alert">
		  ${mensaje}			 
		 </div>	 	
	  </c:if>   
  
  
    <label for="nombre" class="mb-2 mr-sm-2">Nombre:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" id="nombre" name="nombre" required autofocus>
  </div>
  <div class="form-group">
    <label for="apellido" class="mb-2 mr-sm-2">Apellido:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" id="apellido" name="apellido" required>
  </div>
  
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>



<%@ include file="../includes/footer.jsp"%>