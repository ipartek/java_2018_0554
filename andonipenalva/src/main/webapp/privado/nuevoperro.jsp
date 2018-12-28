
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.modelos.pojos.Usuario, java.util.ArrayList"%>


<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/footer.jsp"%>

<main role="main" class="container w-50">

<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">


<form action="listadeperros" method="post" class="form-signin">

<fieldset>
<legend>Formulario de registro para perro</legend>
  <div class="form-group m-3">
    <label for="formGroupExampleInput">Nombre</label>
    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Nombre del perro">
  </div>
  <div class="form-group m-3">
    <label for="formGroupExampleInput2">Chip</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="DD-DDDD-AAAA">
  </div>
  
   <div class="form-group m-3">
    <label for="formGroupExampleInput3">Raza</label>
    <input type="text" class="form-control" id="formGroupExampleInput3" placeholder="Indica su raza">
  </div>
  <p>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
</p>

</fieldset>
</form>

</div>
</main>