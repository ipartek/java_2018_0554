<c:if test="${error eq 'Usuario Inválido'}">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<strong>Error!</strong> ${error}
	</div>
</c:if>
<c:if test="${errores != null}">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<strong>Error!</strong> ${mensajeError}
	</div>
</c:if>