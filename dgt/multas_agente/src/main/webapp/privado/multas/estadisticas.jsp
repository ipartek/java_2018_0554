<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<div class="preloader"> 
<div class="preloader_image">

</div>
</div>
<main role="main" class="container p-2">
<div class="container mb-3">
	<div class="row d-flex align-items-center mb-3 mt-3">
		<div class="col-4">
			<a href="privado/principal.jsp"	class=" btn btn-outline-primary btn-block">Volver</a>
		</div>
		<div class="text-center align-middle col-8">
			<span style="font-size:25px">ESTADÍSTICAS</span>
		</div>
	</div>
	<!-- Actual -->
	<span>Objetivos actuales</span>
	<table id="actual" class="table">
		<tr>
			<td>Mes</td>
			<td class="${(totalMesActual < (objetivoAnualActual / 12)) ? 'nocumpletxt' : 'cumpletxt'}"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalMesActual}" /> de <fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${objetivoAnualActual / 12}" /></td>
		</tr>
		<tr>
			<td>Año</td>
			<td class="${(totalAnualActual < objetivoAnualActual) ? 'nocumpletxt' : 'cumpletxt'}"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalAnualActual}" /> de <fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${objetivoAnualActual}" /></td>
		</tr>
	</table>
	
	<hr>
	
	<!-- Histórico -->
	<p><span>Histórico</span>
		<span class="float-right">
			<select id="anyo" onchange="cambiarAnyo()">
				<c:forEach var = "i" begin = "2018" end ="${anyoActual}"  >
			  		<option ${anyocombo==i?'selected':'' } value="${i}">${i}</option>
			    </c:forEach>
			</select>
		</span>
	</p>
	Objetivo: 
	<span class="${(totalAnualCombo < objetivoAnioCombo) ? 'nocumpletxt' : 'cumpletxt'}">
		<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalAnualCombo}"/> / <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${objetivoAnioCombo }" />
	</span>
	<div class="mt-3 mb-3">
		
	</div>
	
	<table id="historico" class="table">
		<thead class="thead-light">
			<tr>
				<th>Mes</th>
				<th>Rec de Obj</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${objetivo}" var="o">
				<tr class="${(o.importe < (objetivoAnioCombo / 12)) ? 'nocumple' : 'cumple'}">
					<td>${o.nombremes}</td>
					<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${o.importe}" /> de <fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${objetivoAnioCombo / 12}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 	
</div>

</main>
<%@include file="../../includes/footer.jsp"%>