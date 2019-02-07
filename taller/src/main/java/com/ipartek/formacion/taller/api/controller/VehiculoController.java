package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.api.pojo.VehiculoPost;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.PersonaService;
import com.ipartek.formacion.taller.service.VehiculoService;

@CrossOrigin
@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

	@Autowired
	VehiculoService vehiculoService;
	
	@Autowired
	PersonaService personaService;

	
	//listar
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Vehiculo>> listar() {

		ResponseEntity<ArrayList<Vehiculo>> response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.NOT_FOUND); //RESPUESTA DE TIPO ARRAY LIST DE OBJETOS DE TIPO VEHICULO CON CODIGO DE ESTADO POR DEFECTO 404
		try {
			ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) vehiculoService.listar(); 			// llenar el array list de vehiculos con LOS DATOS QUE obtiene el DAO. Al dao se le llama a traves del service
			if (!vehiculos.isEmpty()) {   																// si el array que devuelve el SERVICIO esta lleno. (distinto a empty . OJO AL ! PARA DISTINTO)
				response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.OK);			// CREO LA RESPUESTA con los vehiculos y el codigo de estado 200
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	
	// detalle
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehiculo> detalle(@PathVariable int id) {

 		ResponseEntity<Vehiculo> response = new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);
		try {
			Vehiculo vehiculo = (Vehiculo) vehiculoService.detalle(id);
			if (vehiculo != null) {
				response = new ResponseEntity<Vehiculo>(vehiculo, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Vehiculo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	
	// eliminar
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar(@PathVariable int id) {

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		try {
			if (vehiculoService.eliminar(id)) {
				response = new ResponseEntity(HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	
	// crear
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity crear(@RequestBody VehiculoPost vehiculoPost) {  // nuevo  POJO VEHICULOPOST EN API.POJO

		ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);  //inicializo respuesta con codigo 404 por defecto
		try {

			//TODO validar
			
			
			//mapear veiculoPost a un vehiculo
			
			Vehiculo v = new Vehiculo();   // creo un vehiculo donde introduzco los datos que me llegan por parametros
			v.setMatricula(vehiculoPost.getMatricula());
			v.setNumeroBastidor(vehiculoPost.getNumeroBastidor());
			v.setCombustible(new Combustible(vehiculoPost.getIdCombustible(), ""));  // combustible modelo y persona son objetos
			v.setModelo(new Modelo (vehiculoPost.getIdModelo(), ""));
			v.setPersona(new Persona (vehiculoPost.getIdPropietario(), "", "", "",""));  // el pojo vehiucloPost tieene 5 parametros. uno es la id del propietario. los demas en blanco 
		
			
			// TODO SERVICE IMPLEMENTAR propietario dentro de pojo vehiculo
			
			if (vehiculoService.crear(v)) {  							// SI EL SERVICIO DEVUELVE TRUE. (NO HACE FALTA PONER == true CUANDO ES TRUE
				
				response = new ResponseEntity(v, HttpStatus.CREATED);  	// CREO LA RESPUESTA. envio el vehiculo que he creado
			} else {
				response = new ResponseEntity(HttpStatus.CONFLICT);    	// si hay conflicto con los datos y por ejemplo estan repetidos 
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	
	// modificar
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity modificar(@PathVariable int id, @RequestBody Vehiculo vehiculo) {

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		try {

			vehiculo.setId(id);

			if (vehiculoService.modificar(vehiculo)) {
				response = new ResponseEntity(vehiculo, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
