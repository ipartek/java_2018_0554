/*
    DOM --> acceder a un objeto por su id.
     -innerHTML --> para enmaquetar/acceder a contenidos, cuando manipulas html.
     -style/classname --> para modificar estilos
     -value--> para los inputs, datos introducidos por el usuario. SOLO PARA INPUTS
     -textContent --> para acceder al texto que tiene una etiqueta.

*/
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
        //la lógica de negonio va dentro de la function
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
            //la lógica de negonio va dentro de la function
             if (xhr.readyState == 4) {
                 if ( xhr.status == 200 ){               
                    refrescarLista();
                 }else if ( xhr.status == 409 ){
                    showAlert('CONFLICTO existen multas asociadas', 'warning');
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
        //la lógica de negonio va dentro de la function
        if(xhr.readyState == 4){
            if ( xhr.status == 201 ){
                console.debug('STATUS' + xhr.status);            
                refrescarLista();
             }else if ( xhr.status == 409 ){
                showAlert('CONFLICTO esa matricula ya existe', 'warning');
             }
        }
    };
    xhr.open('POST', ENDPOINT);
    //El setRequestHeader sirve para decirle que tipo de datos se va a enviar, esto se está definiendo en la cabecera
    //JavaScript no tiene null, se usa undefined
    xhr.setRequestHeader("Content-type", "application/json");
    //a la hora de enviar datos hay que tranformar de json a texto
    // y a la hora de recibir datos hay que transformar de texto a json
    xhr.send( JSON.stringify(jsonCoche) );
}
function showAlert(texto,tipo='info'){
    let alertHTML = `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
        <p>${texto}</p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        </div>`;

    document.getElementById('alert').innerHTML = alertHTML;
}//showAlert
