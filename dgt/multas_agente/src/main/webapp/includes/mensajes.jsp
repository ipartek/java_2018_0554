<c:if test="${mensaje != null}">
	<div class="alert alert-${mensaje.tipo} alert-dismissible fade show"
		role="alert"> ${mensaje.texto}
	</div>
</c:if>