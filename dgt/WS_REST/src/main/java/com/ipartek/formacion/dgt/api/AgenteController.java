package com.ipartek.formacion.dgt.api;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

@CrossOrigin
@RestController
public class AgenteController {

	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	private AgenteService agenteService;
	private static MultaDAO multaDAO;
	private ValidatorFactory factory;
	private Validator validator;
	
	public AgenteController() {
		super();
		agenteService = AgenteServiceImpl.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
	
	
	@RequestMapping( value= {"/api/agente/login/{placa}/{password}"}, method = RequestMethod.GET)
	public ResponseEntity<Agente> login( 
										@PathVariable String placa, 
										@PathVariable String password ){		
		
		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.FORBIDDEN);
		try {
			
			Agente agente = agenteService.existe(placa, password);
			if ( agente !=null ) {
				response = new ResponseEntity<Agente>(agente, HttpStatus.OK);
			}		
			
		}catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}
	
//	@RequestMapping( value= {"/api/agente/login/{idAgente}/multas"}, method = RequestMethod.GET)
//	public ResponseEntity<Multa> obtenerMultas( 
//										@PathVariable Long id){		
//		
//		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.FORBIDDEN);
//		try {
//			
//			Multa multa = (Multa) agenteService.obtenerMultas(id);
//			if ( multa !=null ) {
//				response = new ResponseEntity<Multa>(multa, HttpStatus.OK);
//			}		
//			
//		}catch (Exception e) {
//			LOG.error(e);
//			response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		return response;
//		
//	}
	

	@RequestMapping( value= {"/api/agente/{id}/multa"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listar(){
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
		try {

			ArrayList<Multa> asignaturas = (ArrayList<Multa>) agenteService.listar();
			if (!asignaturas.isEmpty()) {
				response = new ResponseEntity<ArrayList<Multa>>(asignaturas, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	
	
	
}