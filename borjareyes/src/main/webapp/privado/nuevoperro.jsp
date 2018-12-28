<%@ include file="../includes/header.jsp" %>   
<%@ include file="../includes/navbar.jsp" %>  
<%@ include file="../includes/mensajes.jsp" %> 
<main class="container">
<form action="nuevoperro" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Nombre</label>
    <input type="text" class="form-control" name="nombre" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nombre">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Chip</label>
    <input type="text" class="form-control" name="chip" id="exampleInputPassword1" placeholder="12-1234-1234">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Raza</label>
    <input type="text" class="form-control" name="raza" id="exampleInputPassword1" placeholder="Raza">
  </div>

  <button type="submit" class="btn btn-primary">Guardar Perro</button>
</form>

</main>
<%@ include file="../includes/footer.jsp" %>  