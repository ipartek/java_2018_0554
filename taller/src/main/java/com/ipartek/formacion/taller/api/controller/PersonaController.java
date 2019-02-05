package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.PersonaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "PERSONA" }, produces = "application/json", description = "Gestión de taller")
public class PersonaController {
	// LOG
	private final static Logger LOG = Logger.getLogger(PersonaController.class);

	/* instancia e implementa patron singleton - inyeccion de dependencias */
	@Autowired
	PersonaService personaService;

	@ApiResponses({ @ApiResponse(code = 200, message = "Listar ok"),
			@ApiResponse(code = 500, message = "Error interno"),
			@ApiResponse(code = 404, message = "Dato no encontrado") })
	@RequestMapping(value = { "/api/persona/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Persona>> personaById(@PathVariable int id) {
		ResponseEntity<ArrayList<Persona>> response = new ResponseEntity<ArrayList<Persona>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			personas = personaService.persona(id);
			if (personas.size() != 0) {
				response = new ResponseEntity<ArrayList<Persona>>(personas, HttpStatus.OK);
			} else {
				response = new ResponseEntity<ArrayList<Persona>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return response;
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "Listar ok"),
			@ApiResponse(code = 500, message = "Error interno"),
			@ApiResponse(code = 404, message = "Datos no encontrados") })
	@RequestMapping(value = { "/api/persona" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Persona>> listarPersona() {
		ResponseEntity<ArrayList<Persona>> response = new ResponseEntity<ArrayList<Persona>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			personas = personaService.listar();
			if (personas.size() != 0) {
				response = new ResponseEntity<ArrayList<Persona>>(personas, HttpStatus.OK);
			} else {
				response = new ResponseEntity<ArrayList<Persona>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return response;
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "Listar ok"),
			@ApiResponse(code = 500, message = "Error interno"),
			@ApiResponse(code = 404, message = "Datos no encontrados") })
	@RequestMapping(value = { "/api/persona/{id}/vehiculo" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Vehiculo>> listarVehiculosByPersonaId(@PathVariable int id) {

		ResponseEntity<ArrayList<Vehiculo>> response = new ResponseEntity<ArrayList<Vehiculo>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		try {
			vehiculos = personaService.vehiculos(id);
			if (vehiculos.size() != 0) {
				response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.OK);
			} else {
				response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return response;
	}

}