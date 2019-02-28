package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

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
import com.ipartek.formacion.modelo.pojo.Multa;

import io.swagger.annotations.Api;


	@CrossOrigin
	@RestController
	@Api(tags = { "MULTA" }, produces = "application/json", description="Gestión de las multas")
	public class MultaController {

		private final static Logger LOG = Logger.getLogger(MultaController.class);
		private static MultaDAO multaDAO;
		private ValidatorFactory factory;
		private Validator validator;
		
		 public MultaController() {
			// TODO Auto-generated constructor stub
			super();
			multaDAO = MultaDAO.getInstance();
			factory  = Validation.buildDefaultValidatorFactory();
	    	validator  = factory.getValidator();
		}
		
			@RequestMapping( value= {"/api/multa"}, method = RequestMethod.GET)
			public ArrayList<Multa> listar(){		
				
				return multaDAO.getAll();
			}
			
			
		@RequestMapping( value= {"/api/multa/{id_agente}"}, method = RequestMethod.GET)
		public ResponseEntity<Multa> detalle(@PathVariable long id){		
			
			ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
			
			try {
				
				long identificador = id;
				Multa m = multaDAO.getMultaActivaByAgente(identificador);
				if ( m != null ) {
					response = new ResponseEntity<Multa>( m,  HttpStatus.OK );
				}
				
			}catch ( NumberFormatException e) {	
				response = new ResponseEntity<Multa>( HttpStatus.BAD_REQUEST );
			}catch (Exception e) {
				LOG.error(e);
				response = new ResponseEntity<Multa>( HttpStatus.INTERNAL_SERVER_ERROR );
			}	 	
			return response;
		}
		
		
		
	
	
	
	
}
