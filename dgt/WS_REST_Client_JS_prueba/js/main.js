console.log('Preparados');
//document ready
var request = new XMLHttpRequest(); //ajax

request.onreadystatechange = function() {
	  if(request.readyState === 4) {//4 significa k la peticion a terminado sin errors ha devuelto todo
	   
	    if(request.status === 200) { 
	      console.log("200");
	      console.log(request.responseText);
	      //se parsea para converitr en objetos json
	      let vehiculos = JSON.parse(request.responseText);
	      console.log(vehiculos);
	      
	      //limpiar lista
	     let ul = document.getElementById('ulVehiculos');
	     ul.innerHTML='';
	     
	     //recorre vehiculos
	     let lis='';
	     
	     vehiculos.forEach(function(el) {
	    	 lis+=`<li class="list-group-item">${el.modelo}</li>`;
	    	});
	     
	     ul.innerHTML=lis;
	    } 
	    
	  }
	}
	 
	request.open('Get', 'http://localhost:8080/wsrest/api/vehiculo');
	request.send();