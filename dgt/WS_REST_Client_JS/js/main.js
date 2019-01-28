
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
        vehiculos.forEach( el => {
            console.debug(el);
            lis += `<li class="list-group-item">
                        <span class="matricula">${el.matricula}</span> 
                        <span class="modelo">${el.modelo}</span>
                        <span class="km">${el.km} KM</span>
                        <a href="#">Eliminar</a>
                    </li>`;
        });
        ulVehiculos.innerHTML = lis;

    }).catch(e => {
        console.error(' tenemos un error ' + e);
    });
  

}