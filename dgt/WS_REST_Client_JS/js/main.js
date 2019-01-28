//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;

const ENDPOINT = 'http://localhost:8080/wsrest/api/vehiculo/';

window.addEventListener('load',function(){
    console.info('documento cargado y listo');
    // resto de llamadas a metodos
    ulVehiculos= document.getElementById('ulVehiculo');

    refrescarLista();
    
});

function  refrescarLista(){
    console.trace('refrescarLista');
    ulVehiculos.innerHTML ='<li class="list-group-item">Cargando vehículos ....</li>';
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            let lis='';
            vehiculos = JSON.parse(xhr.responseText);
            vehiculos.forEach((el,i) =>{
                lis+=`<li class="list-group-item">
                        <span class="matricula">${el.matricula}</span> 
                        <span class="modelo">${el.modelo}</span>
                        <span class="km">${el.km} KM</span>
                        <button type="button" class="btn btn-primary" onclick="eliminar(${el.id})">Eliminar</button>
                    </li>`
            });
            ulVehiculos.innerHTML =lis;
        }
    };
    xhr.open('GET', ENDPOINT);
    xhr.send();
}

function eliminar( idVehiculo ){

   
    console.log('click Eliminar %o', idVehiculo );

    if ( confirm('¿Estas Seguro?') ){
        let xhr = new XMLHttpRequest();    
        xhr.onreadystatechange = function(){ 
             if (xhr.readyState == 4) {
                 if ( xhr.status == 200 ){               
                    refrescarLista();
                 }else if ( xhr.status == 409 ){
                    showAlert('CONFLICTO existen multas asociadas');
                 }   
             }    
        };
        xhr.open('DELETE', ENDPOINT + idVehiculo );    
        xhr.send();
    }    
    
} // eliminar

    function crear(){
        console.log('click crear')

        let matricula = document.getElementById('matricula').value;
        let modelo = document.getElementById('modelo').value;
        let km = document.getElementById('km').value;

        let jsonCoche = {
            "matricula" : matricula,
            "modelo" : modelo,
            "km" : km
        };
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange= function(){
            if(xhr.readyState == 4){
                console.debug('STATUS' + xhr.status);
                refrescarLista();
            }
        };
        xhr.open('POST', ENDPOINT);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send( JSON.stringify(jsonCoche) );
    }