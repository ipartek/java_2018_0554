<%@ include file="../includes/header.jsp" %>

<%@ include file="../../includes/alerta.jsp"  %>
	
<main role="main" class="container mt-3">	

	<c:if test = "${mensaje!=null}">	
		<div class="alert alert-info alert-dismissible fade show" role="alert">
			<strong> ${mensaje }</strong>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>	
	<form action="bolo?op=crear" method="post">	
		<div class="form-group">
			<input type="hidden"  name="id"  id="id" value="-1" class="form-control" >			    
		</div> 
		
		<div class="form-group">
			<label for="lugar">Donde se celebra el bolo</label>
			<input type="text" name="lugar"  id="lugar" value="granada" class="form-control" >			    
		</div>
		
		<div class="form-group">
			<label for="banda1">Banda 1</label>
			<input type="text" name="banda1" id= "banda1" value="sonora kilombo" class="form-control" >			    
		</div>
		
		<div class="form-group">
			<label for="banda2">Banda 2</label>
			<input type="text" name="banda2" id= "banda2" value="tokokera" class="form-control" >			    
		</div>
		
		<div class="form-group">
			<label for="banda3">Banda 3</label>
			<input type="text" name="banda3" id= "banda3" value="moncada 20" class="form-control" >			    
		</div>
		
		<div class="form-group">
			<label for="idCrew">ID Crew</label>
			<input type="text" name="idCrew" id= "idCrew"   class="form-control" >			    
		</div>
					                                                                          
		<div class="form-group">
			<label for="info">Informacion sobre las bandas <span id="contadorLabel">(0/250)</span></label>
		 	<br>
			<textarea name="info"  class="form-control" placeholder="minimo 10 caracteres maximo 255"  id="info" cols="30" rows="10" >${concepto!=null ? concepto : ''}</textarea>		    
		</div>	
	
		<div  class="form-group">								
			<button type="submit" class="btn btn-primary btn-block">CREAR BOLO</button>
		</div>	
		
	</form>
	
	<form action="bolo?op=crear" method="post">	
	
		<div class="form-group">
			<label for="importe">Equipo que realiza el bolo</label>
			<input type="text" name="nombreFOH" id= "nombreFOH" placeholder="FOH"  class="form-control" autofocus>	
			<input type="text" name="nombreMON" id= "nombreMON" placeholder="Monitores"  class="form-control" autofocus>
			<input type="text" name="nombreLUC" id= "nombreLUC" placeholder="Luces"  class="form-control" autofocus>				    
		</div>	
	
		<div  class="form-group">								
			<button type="submit" class="btn btn-primary btn-block">CREAR CREW</button>
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
           concepto = document.getElementById('info');
            
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


