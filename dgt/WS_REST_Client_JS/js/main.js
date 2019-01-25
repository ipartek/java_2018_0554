

console.info('ready');


var request = new XMLHttpRequest(); //ajax

request.onreadystatechange = function() {
  if(request.readyState === 4) {
          
    if(request.status === 200) { 
        console.log("200");
        console.log( request.responseText );
        
        //parsear a json el texto
        let vehiculos = JSON.parse(request.responseText);
        console.log( vehiculos );
        
        //vaciar lista        
        let ul = document.getElementById('ulVehiculos');
        ul.innerHTML = '';
        
        //recorrer vehiculos
        let lis = '';        
        vehiculos.forEach( function(el) {
            lis += `<li class="list-group-item">
                            ${el.id} 
                            <b>${el.modelo}</b>
                            ${el.km} km
                    </li>`;
        });        
        ul.innerHTML = lis;        
    } // 200 
      
  } // readyState === 4
}// onreadystatechange
 
request.open('GET', 'http://localhost:8080/wsrest/api/vehiculo');
request.send();