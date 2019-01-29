
//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;

const ENDPOINT = 'http://localhost:8080/wsrest/api/vehiculo/';


window.addEventListener('load', function(){

    console.info('documento cargado y listo');    
    // console.trace('esto es un trace');
    // console.debug('esto es un debug');
    // console.warn('esto es un waring');
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
            let estado ;
           
            vehiculos = JSON.parse(xhr.responseText);
            vehiculos.forEach( (vehiculo, index) => {
                if(vehiculo.fecha_baja==null){
                    estado='Baja';
                }else{ estado='Alta';}
                lis += ` <li class="list-group-item">
                            <span class="matricula">${vehiculo.matricula}</span> 
                            <span class="modelo">${vehiculo.modelo}</span>
                            <span class="km"> ${vehiculo.km} KM</span>
                            <span class="fecha"> ${vehiculo.fecha_baja} </span>
                            <a href="#" onclick="eliminar(${vehiculo.id})"> Eliminar </a>
                            <a href="#" onclick="cargarForm(${index})"> Editar </a>
                            <a href="#" onclick="baja(${vehiculo.id})">${estado}</a>
                        </li>`;
            });
            ulVehiculos.innerHTML = lis;
         }    
    };
    xhr.open('GET', ENDPOINT );    
    xhr.send();
} // refrescarLista

function cargarForm( index ){

    console.log('click cargar form %o', vehiculos[index] );
    document.getElementById('matricula').value=vehiculos[index].matricula;
    document.getElementById('modelo').value=vehiculos[index].modelo;
    document.getElementById('km').value=vehiculos[index].km;
    $( "#botonmodificar" ).click(function() {
        modificar(vehiculos[index].id);
      });
}

function modificar( idVehiculo ){
    console.log('click modificar %o', idVehiculo );
    

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
             if (xhr.readyState == 4) {
                 if ( xhr.status == 200 ){               
                    refrescarLista();
                    showAlert('Vehiculo dado de baja', 'info');
                 }else if ( xhr.status == 400 ){
                    showAlert(' Error 400 peticion no valida', 'warning');
                 } else if ( xhr.status == 500 ){
                    showAlert('ERROR FATAL', 'warning');
                 }  else if ( xhr.status == 404 ){
                    showAlert('Recurso no disponible', 'warning');
                 }     
             }    
        };
        xhr.open('PUT', ENDPOINT + idVehiculo );    
        xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );
     
}



function baja( idVehiculo ){
    console.log('click Eliminar %o', idVehiculo );
    
        if ( confirm('¿Baja?') ){
            let xhr = new XMLHttpRequest();    
            xhr.onreadystatechange = function(){ 
                 if (xhr.readyState == 4) {
                     if ( xhr.status == 200 ){               
                        refrescarLista();
                        showAlert('Vehiculo eliminado correctamente', 'info');
                     }else if ( xhr.status == 409 ){
                        showAlert('CONFLICTO existen multas asociadas no se puede eliminar', 'warning');
                     } else if ( xhr.status == 400 ){
                        showAlert('CONFLICTO Error 400 peticion no valida', 'warning');
                     } else if ( xhr.status == 500 ){
                        showAlert('ERROR FATAL', 'warning');
                     }  else if ( xhr.status == 404 ){
                        showAlert('Recurso no disponible', 'warning');
                     }     
                 }    
            };
            xhr.open('PATCH', ENDPOINT + idVehiculo );    
            xhr.send();
        }    
        
    } // Baja





function eliminar( idVehiculo ){
console.log('click Eliminar %o', idVehiculo );

    if ( confirm('¿Estas Seguro?') ){
        let xhr = new XMLHttpRequest();    
        xhr.onreadystatechange = function(){ 
             if (xhr.readyState == 4) {
                 if ( xhr.status == 200 ){               
                    refrescarLista();
                    showAlert('Vehiculo eliminado correctamente', 'info');
                 }else if ( xhr.status == 409 ){
                    showAlert('CONFLICTO existen multas asociadas no se puede eliminar', 'warning');
                 } else if ( xhr.status == 400 ){
                    showAlert('CONFLICTO Error 400 peticion no valida', 'warning');
                 } else if ( xhr.status == 500 ){
                    showAlert('ERROR FATAL', 'warning');
                 }  else if ( xhr.status == 404 ){
                    showAlert('Recurso no disponible', 'warning');
                 }     
             }    
        };
        xhr.open('DELETE', ENDPOINT + idVehiculo );    
        xhr.send();
    }    
    
} // eliminar


$( "#botoncrear" ).click(function() {
   crear();
  });

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
            console.debug(' STATUS ' + xhr.status );
            if ( xhr.status == 201 ){               
                showAlert('Vehiculo nuevo creado con exito', 'info');
                refrescarLista();
             }else if ( xhr.status == 409 ){
                showAlert('CONFLICTO Ya existe la matricula', 'warning');
             }else if ( xhr.status == 400 ){
                showAlert('Los campos introducidos no cumplen las validaciones', 'warning');
             }else if ( xhr.status == 500 ){
                showAlert('ERROR FATAL', 'warning');
             }        
           
        }    
   };
   xhr.open('POST', ENDPOINT );
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );

};


function showAlert( texto, tipo = 'info' ){

    
   let alertHTML = `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
        <p>${texto}</p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        </div>`;

    document.getElementById('alert').innerHTML = alertHTML;


}// showAlert