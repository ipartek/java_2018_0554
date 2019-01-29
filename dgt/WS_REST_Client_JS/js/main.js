//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;

const ENDPOINT = 'http://localhost:8080/wsrest/api/vehiculo/';


window.addEventListener('load', function(){

    console.info('documento cargado y listo');    
    // console.trace('esto es un trace');
    // console.debug('esto es un debug');
    // console.warn('esto es un warning');
    // console.error('esto es un ERROR');
    
    ulVehiculos = document.getElementById('ulVehiculo');

    refrescarLista();

});


function refrescarLista(){

    console.trace('refrescarLista');
    ulVehiculos.innerHTML = '<li class="list-group-item">Cargando vehiculos....</li>';

    let xhr = new XMLHttpRequest();    
    xhr.onreadystatechange = function(){ 
         if (xhr.readyState == 4 && xhr.status == 200 ){               
            let lis = '';
            vehiculos = JSON.parse(xhr.responseText);
            vehiculos.forEach( (vehiculo, index) => {
                lis += ` <li class="list-group-item">
                            <span class="matricula">${vehiculo.matricula}</span> 
                            <span class="modelo">${vehiculo.modelo}</span>
                            <span class="km"> ${vehiculo.km} KM</span>                            
                            <a href="#" onclick="eliminar(${vehiculo.id})">Eliminar</a>
                            <a href="#" onclick="rellenarFormulario(${index})" class="mr-3">Modificar</a>
                        </li>`;
            });
            ulVehiculos.innerHTML = lis;
         }    
    };
    xhr.open('GET', ENDPOINT );    
    xhr.send();
} // refrescarLista


function eliminar( idVehiculo ){

   
    console.log('click Eliminar %o', idVehiculo );

    if ( confirm('¿Estas Seguro?') ){
        let xhr = new XMLHttpRequest();    
        xhr.onreadystatechange = function(){ 
             if (xhr.readyState == 4) {
                switch(xhr.status) {
                    case 200:
                      showAlert('Coche Eliminado', 'success');
                      refrescarLista();
                      break;
                    case 404:
                      showAlert('No existe Coche', 'warning');
                      break;
                    case 409:
                      showAlert('No se puede eliminar un Coche si tiene MULTAS', 'warning');
                      break;
                    default:
                        showAlert('Lo sentimos pero tenemos problemas tecnicos', 'error');
                  }  
             }    
        };
        xhr.open('DELETE', ENDPOINT + idVehiculo );    
        xhr.send();
    }    
    
} // eliminar


function crear(){
    console.log('click crear' );

    let matricula = document.getElementById('matricula').value;
    let modelo = document.getElementById('modelo').value;
    let km = document.getElementById('km').value;

    let jsonCoche = {
        "matricula" : matricula,
        "modelo": modelo,
        "km": km
    };

   let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4 ){   
            switch(xhr.status) {
                case 201:
                  showAlert('Coche creado con exito', 'success');
                  refrescarLista();
                  break;
                case 400:
                  showAlert('Por favor introduce valores correctos', 'warning');
                  break;
                case 409:
                  showAlert('Lo sentimos pero la MATRICULA ya existe', 'warning');
                  break;
                default:
                    showAlert('Lo sentimos pero tenemos problemas tecnicos', 'error');
              }
        }    
   };
   xhr.open('POST', ENDPOINT );
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );

};

function rellenarFormulario(index){
    
    let vehiculo = vehiculos[index];
    console.trace('rellenarFormulario %o', vehiculo);
    
    document.getElementById('id').value = vehiculo.id;
    document.getElementById('matricula').value = vehiculo.matricula;
    document.getElementById('modelo').value = vehiculo.modelo;
    document.getElementById('km').value = vehiculo.km;
    

};//rellenar formulario

function modificar(){

    console.log('click Modificar %o'  );
    let id = document.getElementById('id').value;
    let matricula = document.getElementById('matricula').value;
    let modelo = document.getElementById('modelo').value;
    let km = document.getElementById('km').value;

    let jsonCoche = {
        
        "id":id,
        "matricula":matricula,
        "modelo": modelo,
        "km": km
    };

   let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4 ){   
            switch(xhr.status) {
                case 200:
                  showAlert('Coche modificado correctamente', 'success');
                  refrescarLista();
                  break;
                case 400:
                  showAlert('Por favor introduce valores correctos', 'warning');
                  break;
                default:
                    showAlert('Lo sentimos pero tenemos problemas tecnicos', 'danger');
              }
        }    
   };
   xhr.open('PUT', ENDPOINT + id );
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );

}; //modificar

function darDeBaja(){

}; //dar de baja


function showAlert( texto, tipo = 'info' ){

    
   let alertHTML = `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
        <p>${texto}</p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        </div>`;

    document.getElementById('alert').innerHTML = alertHTML;


};// showAlert