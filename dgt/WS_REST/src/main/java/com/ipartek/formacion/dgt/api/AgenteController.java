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
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;

import io.swagger.annotations.Api;
@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces = "application/json", description="Gestión de multas por agente")
public class AgenteController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static MultaDAO multaDAO;
	private ValidatorFactory factory;
	private Validator validator;
	
	public AgenteController() {
		super();
		multaDAO = MultaDAO.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
	
	@RequestMapping( value= {"/api/Agente/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<Multa> listar ( @PathVariable long id ){
		ResponseEntity<Multa> response = new ResponseEntity<Multa>( HttpStatus.NOT_FOUND );
		ArrayList<Multa> multas = new ArrayList<Multa>();
		multas=multaDAO.getAllByUser(id);
		response = new ResponseEntity<Multa>(multas, HttpStatus.OK );
		
		return response;
	}

	
	
	
	
	
	
}
