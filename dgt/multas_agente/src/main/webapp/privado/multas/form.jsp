<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<div class="preloader">
	<div class="preloader_image"></div>
</div>
<main role="main" class="container p-2"> <c:choose>
	<c:when test="${op != 'buscar'}">
		<a href="privado/multas?op=ver&opm=${opm}"
			class="btn btn-outline-primary mt-3 mb-3 col-3"> Volver </a>
	</c:when>
	<c:otherwise>
		<a href="privado/multas?op=irA"
			class="mt-4 btn btn-outline-primary btn-block mt-3 mb-3 col-3">
			Volver </a>
	</c:otherwise>
</c:choose> <%@ include file="../../includes/mensajes.jsp"%>
<form action="privado/multas" method="post">
	<input type="hidden" name="idmulta"
		value="${(op == 'ver') ? multa.id : 0}"> <input type="hidden"
		name="idcoche" value="${coche.id}"> <input type="hidden"
		name="op" value="multar">
	<div class="form-group">
		<label for="matricula">Matricula</label> <input type="text"
			name="matricula"
			value="${(op == 'ver') ? multa.coche.matricula : coche.matricula}"
			class="form-control" readonly>
	</div>
	<c:choose>
		<c:when test="${opm != 'baja'}">
			<div class="form-group">
				<label for="fecha">Fecha</label> <input type="text" name="fecha"
					value="<fmt:formatDate pattern = "dd/MM/yyyy HH:mm" value = "${(op == 'ver') ? multa.fechaAlta : fecha}" />"
					class="form-control" readonly>
			</div>
		</c:when>
		<c:otherwise>
			<div class="form-group">
				<label for="fecha">Fecha Alta</label> <input type="text"
					name="fechaAlta"
					value="<fmt:formatDate pattern = "dd/MM/yyyy HH:mm" value = "${multa.fechaAlta}" />"
					class="form-control" readonly>
			</div>
			<div class="form-group">
				<label for="fecha">Fecha Baja</label> <input type="text"
					name="fechaBaja"
					value="<fmt:formatDate pattern = "dd/MM/yyyy HH:mm" value = "${multa.fechaBaja}" />"
					class="form-control" readonly>
			</div>
		</c:otherwise>
	</c:choose>
	<div class="form-group">
		<label for="concepto">Concepto <c:if test="${op != 'ver'}">
				<span id="contadorLabel"></span>
			</c:if></label>
		<textarea name="concepto" id="concepto"
			${(op == 'ver') ? '' :'autofocus'} rows="8" style="resize: none"
			required class="form-control" ${(op == 'ver') ? "readonly" : ""}>${(op == 'ver') ? multa.concepto : concepto}</textarea>
	</div>
	<div class="form-group">
		<label for="importe">Importe</label> <input type="number" step="any"
			required name="importe"
			value="${(op == 'ver') ? multa.importe : importe}"
			class="form-control number" ${(op == 'ver') ? "readonly" : ""}>
	</div>
	<fieldset class="border p-2">
		<legend class="w-auto">Detalles del vehiculo</legend>
		<div class="form-group">
			<label for="modelo">Modelo</label> <input type="text" name="modelo"
				value="${(op == 'ver') ? multa.coche.modelo : coche.modelo}"
				class="form-control" readonly>
		</div>
		<div class="form-group">
			<label for="km">KM</label> <input type="text" name="km"
				value="${(op == 'ver') ? multa.coche.km : coche.km}"
				class="form-control" readonly>
		</div>
	</fieldset>
	<c:if test="${op == 'buscar'}">
		<input type="submit"
			class="btn btn-outline-success btn-block mt-3 mb-3" value="Multar">
	</c:if>

	<c:if test="${op != 'buscar'}">
		<c:choose>
			<c:when test="${opm != 'baja'}">
				<!-- Button trigger modal -->

				<a href="#" class="btn btn-outline-danger btn-block mt-3 mb-3"
					data-toggle="modal" data-target="#exampleModal">Anular multa</a>
			</c:when>
			<c:otherwise>
				<a href="privado/multas?op=anular&idmulta=${multa.id}&opr=recuperar"
					class="btn btn-outline-success btn-block mt-3 mb-3">Recuperar
					multa</a>
			</c:otherwise>
		</c:choose>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Confirmación
							de anulación de multa</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">¿Está seguro de anular esta multa de
						la matricula ${multa.coche.matricula} con fecha
						${multa.fechaAlta}?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">No anular</button>
						<a
							href="privado/multas?op=anular&idmulta=${multa.id}&opr=norecuperar"
							class="btn btn-danger"> Anular multa </a>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</form>
</main>
<%@ include file="../../includes/footerForm.jsp"%>