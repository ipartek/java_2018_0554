console.log("ready");

var request = new XMLHttpRequest(); //ajax
request.onreadystatechange = function() {
    if(request.readyState === 4) {
      
    }
      if(request.status === 200) { 
       console.log("200");
       // es texto
       console.log(request.responseText); 
        //es json, hay que parsearlo de text a json
       let vehiculos = JSON.parse(request.responseText); 
       console.log(vehiculos);

        //vaciar lista
        let ul = document.getElementById('ulVehiculos');
        ul.innerHTML = '';

        //recorrer vehiculos
        let lis='';
        vehiculos.forEach(el=> {
           lis +=`<li class="list-group-item">
           ${el.matricula}  ${el.modelo} ${el.km}
                    </li>`;
        });

        ul.innerHTML=lis;

    }
  }
  request.open('GET', 'http://localhost:8080/wsrest/api/vehiculo');
  request.send();
