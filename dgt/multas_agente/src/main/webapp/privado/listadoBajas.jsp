<%@include file="../includes/cabecera.jsp" %>
<%@include file="../includes/menu.jsp" %>
<%@include file="../includes/mensajes.jsp" %>

<main role="main" class="inner cover">
    <h3 class="cover-heading">Multas anuladas</h3>
    
    
<table id="tabla_multas" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
        <thead>
		    <tr>
		      <th scope="col">Matrícula</th>
		      <th scope="col">Fecha Baja</th>
		    </tr>
	  </thead>
  <tbody>
  <c:forEach items="${multas}" var="multa">
    <tr>
      <th scope="row"><a href="multa?op=2&id=${multa.key}">${multa.value.coche.matricula}</a></th>
      <td><a href="multa?op=2&id=${multa.key}">${multa.value.fecha_baja}</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<p class="lead">
<a href="listado" class="btn btn-lg btn-info btn-block">
<span class="d-flex justify-content-center align-items-center">Listado de Multas
    	<i class="material-icons" style="font-size:26px; margin-left:3px;">subdirectory_arrow_left</i>
	</span>
</a>
</p>
    
<%@include file="../includes/pie.jsp" %>