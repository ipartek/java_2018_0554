
// Variables Globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;


window.addEventListener('load', function(){
  console.info('Documento cargado y listo');
  // console.trace('Esto es un trace');
  // console.debug('Esto es un debug');
  // console.warn('Esto es un warning');
  // console.error('Esto es un error');

  ulVehiculos = document.getElementById('ulVehiculo');
  
  refrescarLista();

});



function refrescarLista(){
  console.trace('refrescarLista');  
  ulVehiculos.innerHTML = '<li class="list-group-item">Cargando vehículos...</li>';

  let promesa = ajax('GET', 'http://localhost:8080/wsrest/api/vehiculo');

  promesa.then( data => {
    console.log('Tenemos los datos %o', data);
    vehiculos = data;
    let lis = '';
    vehiculos.forEach(el,i => {
      console.debug(el);
      lis += `<li class="list-group-item">
                <span class="matricula">${el.matricula}</span>
                <span class="modelo">${el.modelo}</span>
                <span class="km">${el.km} KM</span> 
                <a href="#" onClick="eliminar(${i})">Eliminar</a>
              </li>`;

    });
    ulVehiculos.innerHTML = lis;
  }).catch(e => {
    console.error('Tenemos un error');
  });

  function eliminar( index ){

  }

}