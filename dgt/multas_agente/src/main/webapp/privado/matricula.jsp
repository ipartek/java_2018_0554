<%@include file="../includes/cabecera.jsp" %>
<%@include file="../includes/menu.jsp" %>
<%@include file="../includes/mensajes.jsp" %>
<main role="main" class="inner cover">
    <h1 class="cover-heading">Registrar multa</h1>
    <p class="lead">Introduzca la matrícula del vehículo: </p>
    
    <form action="matricula" method="POST">
    <div class="form-group">
    <input type="text" class="form-control" id="matriculaCoche" name="matriculaCoche" 
    	aria-describedby="matriculaHelp" placeholder="P.E: 1234AAA" value ="${matricula}" autofocus required>
  	</div>
      <button type="submit" class="btn btn-lg btn-secondary btn-block">
      	<span class="d-flex justify-content-center align-items-center">Buscar
    		<i class="material-icons" style="font-size:26px; margin-left:3px;">find_in_page</i>
		</span>
      </button>
  	</form>
    
<%@include file="../includes/pie.jsp" %>