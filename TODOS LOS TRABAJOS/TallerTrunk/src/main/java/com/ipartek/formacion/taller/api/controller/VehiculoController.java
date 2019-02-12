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

import com.ipartek.formacion.taller.api.controller.pojo.VehiculoPost;
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
	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Vehiculo>> listar() {

		ResponseEntity<ArrayList<Vehiculo>> response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.NOT_FOUND);
		try {
			ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) vehiculoService.listar();
			if (!vehiculos.isEmpty()) {
				response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

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

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity crear(@RequestBody VehiculoPost vehiculoPost ) {

		ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			//TODO validar VehiculoPost
			
			
			// mapear VehiculoPost => Vehiculo
			
			Vehiculo v = new Vehiculo();
			v.setMatricula( vehiculoPost.getMatricula() );
			v.setNumeroBastidor( vehiculoPost.getNumeroBastidor() );
			v.setCombustible( new Combustible( vehiculoPost.getIdCombustible() , ""));
			v.setModelo( new Modelo( vehiculoPost.getIdModelo() , ""));
				 
			Persona persona = new Persona();
			persona.setId(vehiculoPost.getIdPropietario());
			v.setPropietario( persona );
			
			if (vehiculoService.crear(v)) {
				response = new ResponseEntity(v, HttpStatus.CREATED);
			} else {
				response = new ResponseEntity(HttpStatus.CONFLICT);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

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
