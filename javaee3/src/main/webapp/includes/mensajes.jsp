<c:if test="${not empty alerta}">
	<div class="alert alert-${alerta.tipo } alert-dismissible fade show" role="alert">
	  ${alerta.mensaje}
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>

