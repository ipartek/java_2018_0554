package com.ipartek.formacion.taller.api.controller;


import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;

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
	
	//COMBUSTIBLE por id
	
		@RequestMapping(value = { "{id}" }, method = RequestMethod.GET)
		public ResponseEntity<Combustible> detalle(@PathVariable int id) {
			
			ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
			
			try {			
			
				Combustible combustible = (Combustible)combustibleService.detalle(id);
				if (combustible == null) {
					response = new ResponseEntity<Combustible>(combustible, HttpStatus.NOT_FOUND);
				} else {
					response = new ResponseEntity<Combustible>(combustible, HttpStatus.OK);
				}
			 
			} catch (Exception e) {
				response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}
	
	//ELIMINAR
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
	
	//INSERTAR
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Combustible> insert(@RequestBody Combustible combustible) {		
		
		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);// 404
		
		try {
			if (combustibleService.crear(combustible)) {
				response = new ResponseEntity<Combustible>(combustible, HttpStatus.CREATED);//201
			} 
		} catch (CombustibleException e) {
			
			response = new ResponseEntity<Combustible>(HttpStatus.CONFLICT); // 409

		} catch (Exception e) {
			response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}
	
	//MODIFICAR
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity modificar( @PathVariable int id , 
			                         @RequestBody Combustible combustible) {
		
		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		try {
			
			combustible.setId(id);		
			
			if ( combustibleService.modificar(combustible)) {
				response = new ResponseEntity(combustible, HttpStatus.OK);
			}
			
		} catch (CombustibleException e) {		
			
			Mensaje mensaje = new Mensaje( e.getMessage() );
			Set<ConstraintViolation<Combustible>> violations = e.getViolations();
			
			if ( violations != null ) {
				mensaje.addViolations(violations);
				response = new ResponseEntity( mensaje, HttpStatus.BAD_REQUEST);
			}else {
				response = new ResponseEntity( mensaje, HttpStatus.CONFLICT);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
