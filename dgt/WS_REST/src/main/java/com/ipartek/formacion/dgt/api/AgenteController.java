package com.ipartek.formacion.dgt.api;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

//import io.swagger.annotations.Api;

@CrossOrigin
@RestController
public class AgenteController {
	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	private AgenteService agenteService;
	private ValidatorFactory factory;
	private Validator validator;

	public AgenteController() {
		super();
		agenteService = AgenteServiceImpl.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(value = { "/api/agente/{placa}/{password}" }, method = RequestMethod.GET)
	public ResponseEntity<Agente> detalle(@PathVariable int placa, String password) {
		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.NOT_FOUND);
		try {

			Agente a = agenteService.detalle(placa, password);
			if (a != null) {
				response = new ResponseEntity<Agente>(a, HttpStatus.OK);
			}

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
}
