<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/navbar.jsp"%>
<%@ include file="../includes/mensajes.jsp"%>



<main role="main" class="container">
<div class="jumbotron">

	<h1>Editar ${usuarios}</h1>
<form action="privado/usuarios" method="post">
<div class="form-group">	
		<input type="text" class="form-control" id="exampleInputEmail1"
		aria-describedby="emailHelp" name="id" value="${usuario.id}" readonly>
</div>

<div class="form-group">	
		<input type="text" class="form-control" id="exampleInputEmail1"
		aria-describedby="emailHelp" name="email" value="${usuario.email}" >
</div>
<div class="form-group">	
		<input type="text" class="form-control" id="exampleInputEmail1"
		aria-describedby="emailHelp" name="password" value="${usuario.password}" >
</div>

<div class="form-group">
	<input type="hidden" name="op" value="3">
	<button type="submit" class="btn btn-primary btn-block">Guardar</button>
</div>
<c:if test="${usuario.id > 0 }">
	<a href="#TODO#" class="btn btn-danger btn-block mt-4">Eliminar</a>
</c:if>
</form>

</div>
</main>





<%@ include file="../includes/footer.jsp"%>
