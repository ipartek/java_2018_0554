package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@RestController
@RequestMapping("/api/combustible")
public class CombustibleController {

	@Autowired
	CombustibleService combustibleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Combustible>> listar() {

		ResponseEntity<ArrayList<Combustible>> response = new ResponseEntity<ArrayList<Combustible>>(
				HttpStatus.NOT_FOUND);
		try {
			ArrayList<Combustible> combustibles = (ArrayList<Combustible>) combustibleService.listar();
			if (!combustibles.isEmpty()) {
				response = new ResponseEntity<ArrayList<Combustible>>(combustibles, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Combustible> detalle(@PathVariable int id) {

		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
		try {
			Combustible combustibles = (Combustible) combustibleService.detalle(id);
			if (combustibles != null) {
				response = new ResponseEntity<Combustible>(combustibles, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		try {
			if (combustibleService.eliminar(id)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}

		} catch (CombustibleException e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Mensaje>(new Mensaje(e.getMessage()), HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Mensaje> crear(@RequestBody Combustible combustible) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			if (combustibleService.crear(combustible)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.CREATED);
			}

		} catch (CombustibleException e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Mensaje>(new Mensaje(e.getMessage()), HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Mensaje> modificar(@PathVariable int id, @RequestBody Combustible combustible) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		combustible.setId(id);
		try {
			if (combustibleService.modificar(combustible)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}

		} catch (CombustibleException e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Mensaje>(new Mensaje(e.getMessage()), HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Mensaje>(new Mensaje(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
