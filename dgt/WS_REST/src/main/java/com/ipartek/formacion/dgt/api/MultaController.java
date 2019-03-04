package com.ipartek.formacion.dgt.api;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.appMultas.modelo.pojo.Multa;
import com.ipartek.appMultas.modelo.service.impl.MultaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "MULTAS" }, produces="application/json", value="Gestión de Multas")

public class MultaController {

	private final static Logger LOG = Logger.getLogger(MultaController.class);
	public static MultaServiceImpl multaService;
	// private ValidatorFactory factory;
	// private Validator validator;
	
	public MultaController() {
		super();
		multaService = MultaServiceImpl.getInstance();
		//Crear Factoria y Validador
		// factory = Validation.buildDefaultValidatorFactory();
		// validator = factory.getValidator();
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
	@RequestMapping( value= {"/api/multa/{idMulta}/{accion}"}, method = RequestMethod.PATCH)
	public ResponseEntity<Multa> anular(@PathVariable int idMulta, 
										@PathVariable String accion) {
		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.FORBIDDEN);
		
			try {
				
				if ("baja".equals(accion)) {
					if (multaService.darDeBaja(idMulta)) {
						response = new ResponseEntity<Multa>(HttpStatus.OK);
						LOG.debug("Multa [idMulta: " + idMulta + "] dada de baja");
					}
				}else if ("alta".equals(accion)) {
					if (multaService.darDeAlta(idMulta)) {
						response = new ResponseEntity<Multa>(HttpStatus.OK);
						LOG.debug("Multa [idMulta: " + idMulta + "] dada de alta");
					}
				}
			
			} 
			catch (Exception e) {
				LOG.error(e);
				//Error 500
				response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		return response;
	}
	
	
	
	
}
