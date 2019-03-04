<c:if test="${not empty mensaje.texto}">
	<div class="alert alert-${mensaje.tipo}">
	  ${mensaje.texto}
	</div>
</c:if>