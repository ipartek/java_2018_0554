package com.ipartek.formacion.dgt.api;

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

import com.ipartek.formacion.modelo.daos.LoginDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces = "application/json", description = "Gestión de agente")
public class AgenteController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static LoginDAO loginDAO;
	private static AgenteService agenteService;
	private ValidatorFactory factory;
	private Validator validator;

	public AgenteController() {
		super();
		loginDAO = LoginDAO.getInstance();
		agenteService = AgenteServiceImpl.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(value = { "/api/agente/{placa}/{password}" }, method = RequestMethod.GET)
	public ResponseEntity<Agente> login(@PathVariable String password, @PathVariable int placa ) {

		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		Agente agenteEncontrado = null;
		

		
		//BUSCA SI EXISTE AGENTE
		try {
			agenteEncontrado = agenteService.existe(placa, password);
		} catch (Exception e) {
			response = new ResponseEntity<Agente>(HttpStatus.BAD_REQUEST);
		}
		
		//SI NO EXISTE
		if(agenteEncontrado == null) {
			response = new ResponseEntity<Agente>(HttpStatus.FORBIDDEN);
		}
		
		//SI EXISTE
		else {
		//SI ENCUENTRA AGENTE
		response = new ResponseEntity<Agente>(agenteEncontrado, HttpStatus.OK);
	
		}
		return response;
		//		try {
//			long id = Long.parseLong(idAgente);
//			ArrayList<Multa> multas = multaDAO.getAllByAgente(id);
//			if (multas != null) {
//				response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);
//			}
//
//		} catch (NumberFormatException e) {
//			response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			LOG.error(e);
//			response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return response;
//		int id = (int) idAgente;
//		return multaDAO.getAllByAgente(id);
	}
	
	
	
	
}
