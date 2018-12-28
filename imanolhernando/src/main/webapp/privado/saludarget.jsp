 <%@ include file="../includes/header.jsp"%>
	
 <%@ include file="../includes/navbar.jsp"%>
 
    <form class="form-signin" method="get" action="privado/saludarget">
    <legend>SALUDAR GET</legend>
 	<label for="nombre" >Nombre</label>
  <input type="text" id="nombre" name="nombre" class="form-control" value="nombre" >
  
  <label for=apellidos >Apellidos</label>
  <input type="text" id="apellidos" name="apellidos" class="form-control" value="apellido">
  
  <button class="btn btn-lg btn-primary btn-block mb-5" type="submit">Saludar</button>
  
 
    <c:if test = "${nombre != null}">
         <h1 class="alert alert-primary">"wellcome ${nombre} ${apellidos}"</h1>
  </c:if>
  
</form>


</body>
</html>
