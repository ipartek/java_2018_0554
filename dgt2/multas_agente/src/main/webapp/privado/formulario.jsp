<%@include file="../includes/cabecera.jsp" %>
<%@include file="../includes/menu.jsp" %>
<%@include file="../includes/mensajes.jsp" %>
<main role="main" class="inner cover">
    <h3 class="cover-heading">Registrar multa</h3>
    <p class="lead"><small>Introduzca la matrícula del vehículo: </small></p>
    
    <form action="altamulta" method="POST">
    <div class="form-group">	    
	    <label for="matricula">Matrícula: </label>
	    <input type="text" class="form-control" id="matricula" name="matricula" aria-describedby="matriculaHelp" placeholder="P.E: 1234AAA" value="${coche.matricula}" disabled>
  	</div>
  	<div class="form-group">	    
	    <label for="modelo">Modelo: </label>
	    <input type="text" class="form-control" id="modelo" name="modelo" aria-describedby="modeloHelp" placeholder="P.E: Ford Scort" value="${coche.modelo}" disabled>
  	</div>
  	<div class="form-group">
	    <label for="importe">Importe: </label>
	    <input type="number" class="form-control" id="importe" name="importe" aria-describedby="importeHelp" placeholder="P.E: 300" value="${importe}" autofocus step="any" required>
  	</div>
  	<div class="form-group">
	    <label for="concepto">Concepto: (<b id="textoContador" name="textoContador">0</b> /255)</label>
	    <textarea class="form-control" id="concepto" name="concepto" aria-describedby="importeHelp" 
	    		  placeholder="Motivo de la sanción" onKeyDown="contadorFuncion()" onKeyUp="contadorFuncion()" required>${concepto}</textarea>
  	</div>
  	<div class="form-group">
	    <input type="hidden" id="id_coche" name="id_coche" value="${coche.id }">
	    <input type="hidden" id="id_agente" name="id_agente"  value="${sessionScope.agenteLogueado.id }">
  	</div>
      <button type="submit" class="btn btn-lg btn-secondary btn-block">
		<span class="d-flex justify-content-center align-items-center">Crear
    		<i class="material-icons" style="font-size:26px; margin-left:3px;">note_add</i>
    	</span>
	  </button>
  	</form>

  	<script>
	
		function contadorFuncion()
		{
			mensaje = document.getElementById('concepto');
			texto = mensaje.value;
			document.getElementById('textoContador').innerHTML = texto.length;
			if(texto.length <= 240) {
				document.getElementById('textoContador').style.color="green";
			}
			if(texto.length > 240){
				document.getElementById('textoContador').style.color="orange";
			}
			if(texto.length >= 254){
				document.getElementById('textoContador').style.color="red";
				nuevotexto = texto.slice(0, 254);
				mensaje.value= nuevotexto;
			}
		}
	
</script>
    
<%@include file="../includes/pie.jsp" %>