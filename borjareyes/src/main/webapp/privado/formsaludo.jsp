<%@ include file="../includes/header.jsp" %>   
<%@ include file="../includes/navbar.jsp" %>  
<%@ include file="../includes/mensajes.jsp" %> 
<main>
<form action="saludars" method="${metodo}">
  <div class="form-group">
    <label for="exampleInputEmail1">Nombre</label>
    <input type="text" class="form-control" name="nombre" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nombre">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Apellidos</label>
    <input type="text" class="form-control" name="apellidos" id="exampleInputPassword1" placeholder="Password">
  </div>

  <button type="submit" class="btn btn-primary">Enviar</button>
</form>

</main>
<%@ include file="../includes/footer.jsp" %>  