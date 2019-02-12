<%@ include file="../includes/cabecera.jsp" %> 	
<main role="main" class="container mt-3">	

<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<form action="privado/multa" method="post">	

	<input type="hidden" name="id_agente" value="${agente_logeado.id}">
	<input type="hidden" name="id_coche" value="${coche.id}">
	<input type="hidden" name="operacion" value="1">
	
	<div class="form-group">
	<label for="matricula">Matricula seleccionada</label>
	<input readonly  type="text" name="matricula" value="${coche.matricula }" class="form-control" >			    
	</div>
	
	<div class="form-group">
	<label for="importe">Importe</label>
	<input type="text" name="importe" placeholder="Introduce un valor numerico valido" value="${importe!=null ? importe : ''}" class="form-control" autofocus>			    
	</div>	
		
	                                                                          
	<div class="form-group">
	<label for="concepto">Concepto  <span id="contadorLabel">(0/250)</span></label>
	 <br>
	<textarea name="concepto"  class="form-control" placeholder="minimo 10 caracteres maximo 255"  id="concepto" cols="30" rows="10" >${concepto!=null ? concepto : ''}</textarea>		    
	</div>	
	

	<div  class="form-group">								
	<button type="submit" class="btn btn-primary btn-block">MULTAR</button>
	</div>	
	
</form>

	
</main>			
<script>
         
       let label;
       let concepto; //textarea
       
       const MAX_CARARCTERES = 255; 
       const MIN_CARARCTERES = 10;
       
       window.addEventListener('load', function() {
           
           console.log('el DOM cargado y listo');
           label   = document.getElementById('contadorLabel');
           concepto = document.getElementById('concepto');
            
           label.textContent = `0/`+ MAX_CARARCTERES;
           label.style.color = 'orange';
           
           concepto.addEventListener("keyup", function(){
               
               let caracteres = concepto.value.length;                             
               
               if( caracteres < MIN_CARARCTERES ){
                    label.style.color = 'orange';   
               }else if ( caracteres  > MAX_CARARCTERES ){
                   concepto.value = concepto.value.substr(0,MAX_CARARCTERES);
               }else{
                    label.style.color = 'green';
               }
               
               caracteres = concepto.value.length;
               label.textContent = caracteres + `/`+ MAX_CARARCTERES;
               
           });
           
           
       });
    
   </script>
   	
<%@ include file="../includes/footer.jsp"  %>



