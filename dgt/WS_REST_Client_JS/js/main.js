//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;

window.addEventListener('load',function(){
    console.info('documento cargado y listo');
    // resto de llamadas a metodos
    ulVehiculos= document.getElementById('ulVehiculo');

    refrescarLista();
    
});

function  refrescarLista(){
    console.trace('refrescarLista');
    ulVehiculos.innerHTML ='<li class="list-group-item">Cargando vehículos ....</li>';

    let promesa = ajax('GET','http://localhost:8080/wsrest/api/vehiculo/');
    promesa.then(data =>{
        console.log('tenemos los datos %o', data);
        vehiculos = data;
        let lis = '';
        vehiculos.forEach((el,i) => {
           console.debug(el); 
           lis +=`
           <li class="list-group-item">
            <span class="matricula"> ${el.matricula}</span> 
            <span class="modelo"> ${el.modelo} </span>
            <span class="km">${el.km}</span>
            <a href="#" onclick="eliminar(${i})">Eliminar</a>
            </li>`;
        });
        ulVehiculos.innerHTML=lis;
    }).catch(e =>{
        console.error('Tenemos un error '+ e);
    });
}

function eliminar(i){
    let vehiculo = vehiculos[i];
    console.log('click Eliminar %o',vehiculo.id);
    if(confirm('¿Estás seguro?')){
        let promesa = ajax('DELETE',`http://localhost:8080/wsrest/api/vehiculo/${vehiculo.id}`);
        promesa.then(data=>{
            console.log('Vehiculo eliminado');
            refrescarLista();
        }).catch(e=>{
            console.error('Tenemos un error '+ e);
        });
    }

    function crear(){
        console.log('click crear')

        let matricula = documente.getElementById('matricula').value;

        let json = {
            "matricula" : matricula,
            "modelo" : "harcodeado",
            "km" : 10000
        };
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange= function(){
            if(request.readyState == 4){
                console.debug('STATUS' + xhr.status);
            }
        };
        xhr.open('POST', 'http://localhost:8080/wsrest/api/vehiculo/', true);
        request.send( JSON.stringify(data) );
    }
}