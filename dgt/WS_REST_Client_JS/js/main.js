
//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;


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

    let promesa = ajax('GET','http://localhost:8080/wsrest/api/vehiculo/');

    promesa.then( data => {
        console.debug('tenemos los datos %o', data);
        vehiculos = data;
        let lis = '';
        vehiculos.forEach( (el,pos) => {
            console.debug(el);
            lis += `<li class="list-group-item">
                        <span class="matricula">${el.matricula}</span> 
                        <span class="modelo">${el.modelo}</span>
                        <span class="km">${el.km} KM</span>
                        <a href="#" onclick="eliminar(${pos})">Eliminar</a>
                    </li>`;
        });
        ulVehiculos.innerHTML = lis;

    }).catch(e => {
        console.error(' tenemos un error ' + e);
    });
} // refrescarLista


function eliminar( posicion ){

    let vehiculo = vehiculos[posicion];
    console.log('click Eliminar %o', vehiculo );

    if ( confirm('¿Estas Seguro?') ){
        let promesa = ajax('DELETE',`http://localhost:8080/wsrest/api/vehiculo/${vehiculo.id}`);
        promesa.then( data =>{
            console.debug('Vehiculo eliminado');
            refrescarLista();
        }).catch( e => {
            console.warn('Vehiculo NO eliminado %o', e);
        });
    }    
    
} // eliminar


function crear(){
    console.log('click crear' );

    let matricula = document.getElementById('matricula').value;

    let jsonCoche = {
        "matricula" : matricula,
        "modelo": "harcodeado",
        "km": 1000000
    };

   let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4 ){   
            console.debug(' STATUS ' + xhr.status );
            refrescarLista();
        }    
   };
   xhr.open('POST', 'http://localhost:8080/wsrest/api/vehiculo/');
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );

};