package com.ipartek.formacion.taller.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@RestController
@RequestMapping("/api/combustible/")
public class CombustibleController {
	private final static Logger LOG = Logger.getLogger(CombustibleController.class);
	private static CombustibleDAO combustibleDAO;

	private ValidatorFactory factory;
	private Validator validator;
	
	public CombustibleController() {
		super();
		
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

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
	public ResponseEntity<Combustible> crear(@Valid @RequestBody Combustible combustible) {
		
		
		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);// 404
		try {
			Set<ConstraintViolation<Combustible>> violations = validator.validate(combustible);
			if (violations.size() > 0) {
				response = new ResponseEntity<Combustible>(HttpStatus.BAD_REQUEST);
			} else {
				boolean c = combustibleDAO.insert(combustible);
				response = new ResponseEntity<Combustible>(HttpStatus.CREATED); //201
				LOG.info("Nuevo Coche creado " + c);
			}
		} catch (SQLException e) {
			LOG.debug("Ya existe este combustible " + combustible.getNombre());
			response = new ResponseEntity<Combustible>(HttpStatus.CONFLICT); // 409

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}
	

}
