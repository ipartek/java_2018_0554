<%@ include file="../includes/cabecera.jsp" %> 	

<main>

<section class="container-fluid mt-3 ">
<c:if test = "${mensaje!=null}">
<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

</c:if>
<a class="btn btn-lg btn-info btn-block mb-3" href="privado/listar?operacion=0&id=${sessionScope.agente_logeado.id}" role="button">MULTAS ACTIVAS</a>
<a class="btn btn-lg btn-info btn-block mb-3" href="privado/listar?operacion=1&id=${sessionScope.agente_logeado.id}" role="button">MULTAS ANULADAS</a>
<a class="btn btn-lg btn-info btn-block  mb-3" href="privado/buscar" role="button">NUEVA MULTA</a>
<a class="btn btn-lg btn-info btn-block  mb-3" href="privado/objetivos?id_agente=${sessionScope.agente_logeado.id}" role="button">OBJETIVOS</a>
</section>


</main>

<%@ include file="../includes/footer.jsp"  %>
