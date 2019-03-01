<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<div class="preloader">
	<div class="preloader_image"></div>
</div>
<main role="main" class="container p-2">
<div class="container mb-3 mt-3">
	<div class="row d-flex align-items-center mb-3">
		<div class="col-4">
			<a href="privado/principal.jsp"
				class=" btn btn-outline-primary btn-block">Volver </a>
		</div>
		<div class="text-center align-middle col-8">
			<span style="font-size: 25px">${(opm == 'baja') ? 'MULTAS ANULADAS':'MULTAS' }</span>
		</div>
	</div>
	<%@include file="../../includes/mensajes.jsp"%>
	<table class="table table-hover tablaOrdenable">
		<thead class="thead-light">
			<tr>
				<th>Matricula</th>
				<c:choose>
					<c:when test="${opm != 'baja'}">
						<th>Fecha</th>
					</c:when>
					<c:otherwise>
						<th>Fecha Baja</th>
						<th>Fecha Alta</th>
					</c:otherwise>
				</c:choose>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${multas}" var="m">
				<tr class="transparente"
					onclick="location='privado/multas?op=ver&idmulta=${m.id}&opm=${opm}'">
					<td>${m.coche.matricula}</td>
					<c:if test="${opm=='baja' }">
						<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
								value="${m.fechaBaja}" /></td>
					</c:if>
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
							value="${m.fechaAlta}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</main>
<%@include file="../../includes/footer.jsp"%>