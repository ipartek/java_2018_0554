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
@RequestMapping("/api/combustible/")
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
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Combustible> detalle(@PathVariable int id) {
		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
		try {

			Combustible c = combustibleService.detalle(id);
			if ( c != null) {
				response = new ResponseEntity<Combustible>(c, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar( @PathVariable int id) {

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		try {

			if ( combustibleService.eliminar(id) ) {
				response = new ResponseEntity(HttpStatus.OK);
			}
		} catch (CombustibleException e) {	
			
			Mensaje mensaje = new Mensaje( e.getMessage() );
			response = new ResponseEntity( mensaje, HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity modificar( @PathVariable int id , 
			                         @RequestBody Combustible combustible) {
		
		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		try {
			
			combustible.setId(id);		
			
			if ( combustibleService.modificar(combustible)) {
				response = new ResponseEntity(combustible, HttpStatus.OK);
			}else {
				Mensaje mensaje = new Mensaje( "Validacion Incorrecta" );
				response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
			}
			
		} catch (CombustibleException e) {				
			Mensaje mensaje = new Mensaje( e.getMessage() );
			response = new ResponseEntity( mensaje, HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	

}
