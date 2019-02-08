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

import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.service.PersonaService;
import com.ipartek.formacion.taller.service.exception.PersonaException;

@CrossOrigin
@RestController
@RequestMapping("api/persona")
public class PersonaController {

	@Autowired
	PersonaService personaService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Persona>> listar() {
		ResponseEntity<ArrayList<Persona>> response = new ResponseEntity<ArrayList<Persona>>(
				HttpStatus.NOT_FOUND);
		try {
			ArrayList<Persona> personas = personaService.listar();
			if (!personas.isEmpty()) {
				response = new ResponseEntity<ArrayList<Persona>>(personas, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<ArrayList<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Persona> detalle(@PathVariable String id) {
		ResponseEntity<Persona> response = new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		try {
			int idInt = Integer.parseInt(id);
			Persona persona = personaService.detalle(idInt);
			if (persona != null) {
				response = new ResponseEntity<Persona>(persona, HttpStatus.OK);
			}

		} catch (NumberFormatException e) {
			response = new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			response = new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> delete(@PathVariable String id) {
		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		try {
			int idInt = Integer.parseInt(id);
			if (personaService.eliminar(idInt)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}

		} catch (PersonaException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);
		} catch (NumberFormatException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public ResponseEntity<Persona> insert(@RequestBody Persona persona) {
		ResponseEntity<Persona> response = new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		try {
			if (personaService.crear(persona)) {
				response = new ResponseEntity<Persona>(persona,HttpStatus.OK);
			}

		} catch (PersonaException e) {

			response = new ResponseEntity<Persona>( HttpStatus.CONFLICT);
		} catch (Exception e) {
		
			response = new ResponseEntity<Persona>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Persona> update(@PathVariable int id, @RequestBody Persona persona) {
		ResponseEntity<Persona> response = new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		try {
			persona.setId(id);
			if (personaService.modificar(persona)) {
				response = new ResponseEntity<Persona>(persona,HttpStatus.OK);
			}

		} catch (PersonaException e) {

			response = new ResponseEntity<Persona>( HttpStatus.CONFLICT);
		} catch (Exception e) {
		
			response = new ResponseEntity<Persona>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
