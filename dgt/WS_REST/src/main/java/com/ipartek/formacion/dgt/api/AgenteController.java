package com.ipartek.formacion.dgt.api;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.service.impl.AgenteServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces="application/json", value="Gestión de Agentes")

public class AgenteController {

	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	public static AgenteServiceImpl agenteService;
	//private ValidatorFactory factory;
	//private Validator validator;
	
	public AgenteController() {
		super();
		agenteService = AgenteServiceImpl.getInstance();
		//Crear Factoria y Validador
		//factory = Validation.buildDefaultValidatorFactory();
		//validator = factory.getValidator();
	}
	

	/**
	 * Método que permite realizar login con los datos de un agente en la DB.
	 * @param placa String Nº de Placa del Agente
	 * @param password String Contraseña del Agente
	 * @return NOT_FOUND (403) Si no existe ese Agente en la DB.
	 * @return OK (200) Si existe el Agente en la DB.
	 * @return INTERNAL_SERVER_ERROR (500) Si ocurre cualquier otra Excepción (Mirar log para más info).
	 */
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Login correcto."),
			@ApiResponse(code = 403, message="Login incorrecto."),
			@ApiResponse(code = 500, message="Error interno del servidor.")
	})
	@RequestMapping( value= {"/api/login/{placa}/{pass}"}, method = RequestMethod.GET)
	public ResponseEntity<Agente> login(@PathVariable String placa, @PathVariable String pass) {
		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.FORBIDDEN);
		
			try {
				Agente agente = agenteService.login(placa, pass);
				
				if (agente != null) {
					response = new ResponseEntity<Agente>(agente, HttpStatus.OK);
				}
			} 
			catch (Exception e) {
				LOG.error(e);
				//Error 500
				response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		return response;
	}
	
	
}
