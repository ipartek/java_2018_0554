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

import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Vehiculo;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

@CrossOrigin
@RestController
public class EstadisticaController {
	
	private final static Logger LOG = Logger.getLogger(EstadisticaController.class);
	private AgenteService agenteService;
	private ValidatorFactory factory;
	private Validator validator;
	
	public EstadisticaController() {
		super();
		//patron singelton para coger la instancia
		agenteService = AgenteServiceImpl.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
}
