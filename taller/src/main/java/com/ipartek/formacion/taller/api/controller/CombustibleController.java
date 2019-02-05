package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Mensaje;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@RestController
@RequestMapping("/api/combustible/")
public class CombustibleController {

	@Autowired
	CombustibleService combustibleService;

	
	
	// LISTAR 
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Combustible>> listar() {

		ResponseEntity<ArrayList<Combustible>> response = new ResponseEntity<ArrayList<Combustible>>(
				HttpStatus.NOT_FOUND);  // por defecto devuelve not_Found
		try {

			ArrayList<Combustible> combustibles = (ArrayList<Combustible>) combustibleService.listar();
			if (!combustibles.isEmpty()) {
				response = new ResponseEntity<ArrayList<Combustible>>(combustibles, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	
	// DETALLE POR ID (GETBYID)
		@RequestMapping(value = "{id}", method = RequestMethod.GET)
		public ResponseEntity<Combustible> detalle(@PathVariable int id ) {

			ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);  // por defecto devuelve not_Found
			try {

				Combustible combustible = (Combustible) combustibleService.detalle(id);
				if (combustible== null) {
					response = new ResponseEntity<Combustible>(combustible, HttpStatus.NOT_FOUND);
				}else {
					response = new ResponseEntity<Combustible>(combustible, HttpStatus.OK);
				}

			} catch (Exception e) {
				e.printStackTrace(); // TODO meter en LOG
				response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}
	
	// METODO ELIMINAR (DELETE)
		@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Mensaje> eliminar( @PathVariable int id) {

			ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
			try {

				if ( combustibleService.eliminar(id) ) {
					response = new ResponseEntity<Mensaje>(HttpStatus.OK);
				}
			} catch (CombustibleException e) {	
				
				Mensaje mensaje = new Mensaje( e.getMessage() );
				response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);
				
			} catch (Exception e) {
				e.printStackTrace();
				response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}

	
	
}// FIN COMBUSTIBLE CONTROLLER