<%@ include file="../includes/header.jsp" %>   
<%@ include file="../includes/navbar.jsp" %>  
<%@ include file="../includes/mensajes.jsp" %> 
<main>
<form action="nuevoperro" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Nombre</label>
    <input type="text" class="form-control" name="nombre" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nombre">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Chip</label>
    <input type="text" class="form-control" name="chip" id="exampleInputPassword1" placeholder="chip">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Raza</label>
    <input type="text" class="form-control" name="raza" id="exampleInputPassword1" placeholder="Raza">
  </div>

  <button type="submit" class="btn btn-primary">Guardar</button>
</form>

</main>
<%@ include file="../includes/footer.jsp" %>  