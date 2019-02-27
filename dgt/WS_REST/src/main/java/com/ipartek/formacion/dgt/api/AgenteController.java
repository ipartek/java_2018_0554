package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;
import java.util.List;

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
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

import io.swagger.annotations.Api;
@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces = "application/json", description="Gestión de multas por agente")
public class AgenteController  {

	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	private AgenteService agenteService;
	private ValidatorFactory factory;
	private Validator validator;
	
	public AgenteController() {
		super();
		agenteService = AgenteServiceImpl.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
	
	
	@RequestMapping( value= {"/api/agente/login/{numeroPlaca}/{pass}"}, method = RequestMethod.GET)
	public ResponseEntity<Agente> login( 
										@PathVariable String numeroPlaca, 
										@PathVariable String pass ){		
		
		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.FORBIDDEN);
		try {
			
			Agente agente = agenteService.existe(numeroPlaca, pass);
			if ( agente !=null ) {
				response = new ResponseEntity<Agente>(agente, HttpStatus.OK);
			}		
			
		}catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}
	
	
	
	@RequestMapping( value= {"/api/Agente/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> getAllByUser ( @PathVariable int id ){
		
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>( HttpStatus.NOT_FOUND );
		try {
			ArrayList<Multa> multas = new ArrayList<Multa>();
			multas =  (ArrayList<Multa>) agenteService.listarMultas(id);
			response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK );
			
		}catch(Exception e) {
			e.printStackTrace();  // falta log
		}
		return response;
	}






	






	
	
	
	
	
	
}
