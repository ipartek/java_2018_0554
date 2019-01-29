//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;

const ENDPOINT = "http://localhost:8080/wsrest/api/vehiculo/";

window.addEventListener("load", function() {
  console.info("documento cargado y listo");
  // console.trace('esto es un trace');
  // console.debug('esto es un debug');
  // console.warn('esto es un waring');
  // console.error('esto es un ERROR');

  ulVehiculos = document.getElementById("ulVehiculo");

  refrescarLista();
});

function refrescarLista() {
  console.trace("refrescarLista");
  ulVehiculos.innerHTML =
    '<li class="list-group-item">Cargando vehiculos....</li>';

  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      let lis = "";
      vehiculos = JSON.parse(xhr.responseText);
      vehiculos.forEach((vehiculo, index) => {
        lis += ` <li class="list-group-item">
                            <span class="matricula">${vehiculo.matricula}</span> 
                            <span class="modelo">${vehiculo.modelo}</span>
                            <span class="km"> ${vehiculo.km} KM</span>
                            <a href="#" onclick="eliminar(${vehiculo.id})" class="btn btn-danger">Eliminar</a>
                            <a href="#" onclick="ponerDatos(${index})" class="btn btn-secondary">Editar</a>
                            <a href="#" onclick="darDeBaja(${index})" class="btn btn-warning">Dar de Baja</a>
                        </li>`;
      });
      ulVehiculos.innerHTML = lis;
    }
  };
  xhr.open("GET", ENDPOINT);
  xhr.send();
} // refrescarLista

function eliminar(idVehiculo) {
  console.log("click Eliminar %o", idVehiculo);

  if (confirm("¿Estas Seguro?")) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
      if (xhr.readyState == 4) {
        switch (xhr.status) {
          case 200:
            refrescarLista();
            break;
          case 409:
            showAlert("CONFLICTO: Existen multas asociadas", "warning");
            break;

          default:
          showAlert("ERROR INESPERADO", "danger");
            break;
        }
      }
    };
    xhr.open("DELETE", ENDPOINT + idVehiculo);
    xhr.send();
  }
} // eliminar

function crear() {
  console.log("click crear");

  let matricula = document.getElementById("matricula").value;
  let modelo = document.getElementById("modelo").value;
  let km = document.getElementById("km").value;

  if (!matricula.localeCompare("") || !modelo.localeCompare("") || !km.localeCompare("")) {
    showAlert("ERROR: Debes rellenar todos los campos", "danger");
  }else{
    let jsonCoche = {
      matricula: matricula,
      modelo: modelo,
      km: km
    };
  
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
      if (xhr.readyState == 4) {
        switch (xhr.status) {
          case 201:
            showAlert("CORRECTO: Vehículo creado.", "success");
            refrescarLista();
            break;
          case 409:
            showAlert("CONFLICTO: Esa matrícula ya existe en la DB.", "warning");
            break;
          case 400:
            showAlert(
              "ERROR: El formato de los campos introducidos no es correcto.",
              "danger"
            );
            break;
  
          default:
          showAlert("ERROR INESPERADO", "danger");
            break;
        }
      }
      console.debug(" STATUS " + xhr.status);
      refrescarLista();
    };
    xhr.open("POST", ENDPOINT);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(jsonCoche));
    limpiarCampos();
  }

}

function ponerDatos(index) {
  console.log("click editar [i: " + index + "]");

  document.getElementById("matricula").value = vehiculos[index].matricula;
  document.getElementById("modelo").value = vehiculos[index].modelo;
  document.getElementById("km").value = vehiculos[index].km;

  vehiculoSeleccionado = vehiculos[index];
}

function editar() {
  console.log("click editar");
  let aviso = "";
  let matricula = document.getElementById("matricula").value;
  let modelo = document.getElementById("modelo").value;
  let km = document.getElementById("km").value;


  if (!matricula.localeCompare("")) {
    matricula = vehiculoSeleccionado.matricula;
    aviso="¡¡¡Ande vas!!! Como no has puesto matrícula, se ha mantenido la misma";
  }
  if (!modelo.localeCompare("")) {
    modelo = vehiculoSeleccionado.modelo;
    aviso="Como no has puesto modelo, (¡¡¡IMBÉCIL!!!) se ha mantenido el mismo";
  }
  if (km<0) {
    km = 0;
    aviso="Como no has puesto un valor válido para kms, se ha puesto 0, ¡¡¡PAYASO!!!";
  }

  let jsonCoche = {
    matricula: matricula,
    modelo: modelo,
    km: km
  };

  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      switch (xhr.status) {
        case 200:
          showAlert("ACTUALIZACIÓN: Vehículo modificado." + aviso, "success");
          refrescarLista();
          break;
        case 409:
          showAlert("CONFLICTO: Esa matrícula ya existe en la DB.", "warning");
          break;
        case 400:
          showAlert(
            "ERROR: El formato de los campos introducidos no es correcto.",
            "danger"
          );
          break;
        default:
        showAlert("ERROR INESPERADO", "danger");
          break;
      }
    }
    console.debug(" STATUS " + xhr.status);
    refrescarLista();
  };
  xhr.open("PUT", ENDPOINT + vehiculoSeleccionado.id);
  xhr.setRequestHeader("Content-type", "application/json");
  xhr.send(JSON.stringify(jsonCoche));
}

function darDeBaja( index ) {
  console.log("click dar de baja");
  vehiculoSeleccionado = vehiculos[index];

  let jsonCoche = {
    matricula: vehiculoSeleccionado.matricula,
    modelo: vehiculoSeleccionado.modelo,
    km: vehiculoSeleccionado.km
  };

  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      switch (xhr.status) {
        case 200:
          showAlert("ACTUALIZACIÓN: Vehículo dado de baja.", "success");
          refrescarLista();
          break;
        case 404:
          showAlert("ATENCIÓN: El vehículo no existe en la DB.", "warning");
          break;
        case 400:
          showAlert(
            "ERROR: El formato de los de los parámetros no es correcto.",
            "danger"
          );
          break;
        default:
        showAlert("ERROR INESPERADO", "danger");
          break;
      }
    }
    console.debug(" STATUS " + xhr.status);
    refrescarLista();
  };
  xhr.open("PATCH", ENDPOINT + vehiculoSeleccionado.id);
  xhr.setRequestHeader("Content-type", "application/json");
  xhr.send(JSON.stringify(jsonCoche));
}

function limpiarCampos(){
  document.getElementById('matricula').value = "";
  document.getElementById('modelo').value = "";
  document.getElementById('km').value = "";
}

function showAlert(texto, tipo = "info") {
  let alertHTML = `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
        <p>${texto}</p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        </div>`;

  document.getElementById("alert").innerHTML = alertHTML;
} // showAlert
