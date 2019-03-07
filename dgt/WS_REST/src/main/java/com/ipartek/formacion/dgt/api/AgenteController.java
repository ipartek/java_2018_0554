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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces = "application/json", description = "Gestión de agentes y login")
public class AgenteController {
	
	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	private static AgenteDAO agenteDAO;
	private static AgenteServiceImpl agService ;
	private ValidatorFactory factory;
	private Validator validator;
	
	public AgenteController() {
		super();
		agenteDAO = AgenteDAO.getInstance();
		agService = AgenteServiceImpl.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@RequestMapping(value = { "/api/agente/login/{splaca}/{password}" }, method = RequestMethod.GET)
	public ResponseEntity<Agente> login(@PathVariable String splaca, 
			@PathVariable String password) {
		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		Agente agEncontrado = null;
		int placa=0;
		
		try {
			placa = Integer.parseInt(splaca);
		}catch(Exception e) {
			e.printStackTrace();
			LOG.error("No se ha parseado");
		}
		
		try {
			agEncontrado = agService.existe(placa, password);
		}catch(Exception e) {
			response = new ResponseEntity<Agente>(HttpStatus.BAD_REQUEST);
			LOG.error("No se han introducido bien los datos");
		}
		
		if(agEncontrado == null) {
			response = new ResponseEntity<Agente>(HttpStatus.NOT_FOUND);
			LOG.error("No existe el agente");
		}else {
			response = new ResponseEntity<Agente>(agEncontrado, HttpStatus.OK);
			LOG.info("Se ha encontrado el agente");
		}
		
		return response;
	}
	
	

}
