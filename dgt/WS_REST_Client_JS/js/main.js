//VARIABLES GLOBALES
var ulVehiculos;
var vehiculos=[];
var vehiculoSelecionado;


window.addEventListener('load',function(){
/*
    console.info('info');
    console.trace('trace');
    console.warn('warn');
    console.debug('debug');
    console.error('error');
*/
ulVehiculos = document.getElementById('ulVehiculo');
    refrescarLista();
})


function refrescarLista(){
    console.trace('Refrescar lista ');
    ulVehiculos.innerHTML = '<li class="list-group-item">Cargando....</li>';

    
    let promesa = ajax('GET','http://localhost:8080/wsrest/api/vehiculo');
    promesa.then(data =>{
        console.log('temenos datos %o', data);
        vehiculos = data;
        let lis='';
        vehiculos.forEach((element,pos) => {
            console.debug(element);
            lis+=`<li class="list-group-item">
            <span> ${element.matricula}</span>
            <span> ${element.modelo}</span>
            <span> ${element.km} km</span>
            <a href="#" onclick="eliminar(${pos})>Eliminar</a>
            </li>`;
        });
        ulVehiculo.innerHTML=lis;
    }).catch(e =>{
        console.log('Tenemos un error'+e);
    
    });

    
}


function eliminar ( posicion ){
    let vehiculo = vehiculo[posicion];
    console.log("asdf "+vehiculo);

    let promesa = ajax('DELETE', `http://localhost:8080/wsrest/api/vehiculo${vehiculo.id}`);
    promesa.then(
        console.debug("elimnado");
    }).catch(e =>{

    });
}