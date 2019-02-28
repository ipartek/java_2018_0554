package com.ipartek.formacion.dgt.api;

import java.util.Set;

import javax.validation.ConstraintViolation;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;
import com.ipartek.appMultas.modelo.service.impl.AgenteServiceImpl;
import com.ipartek.formacion.dgt.api.model.MultaPOST;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces="application/json", value="Gestión de Agentes")

public class AgenteController {

	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	public static AgenteServiceImpl agenteService;
	private ValidatorFactory factory;
	private Validator validator;
	
	public AgenteController() {
		super();
		agenteService = AgenteServiceImpl.getInstance();
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
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
				Agente agente = agenteService.existe(placa, pass);
				
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
	
	/**
	 * Método que permite la creación de una nueva multa en la base de datos.
	 * @param coche a insertar en la base de datos.
	 * @return BAD_REQUEST (400) Si los datos del coche no son correctos.  P.E: sin matrícula o vacía.
	 * @return CREATED (201) Si la inserción es correcta.
	 * @return INTERNAL_SERVER_ERROR (500) Si ocurre cualquier otra Excepción (Mirar log para más info).
	 */
	@ApiResponses(value = {
			@ApiResponse(code = 201, message="Se ha creado una nueva multa"),
			@ApiResponse(code = 400, message="Los datos de la multa no son válidos (P.E: formato erróneo, fuera de la longitud establecida, etc.)"),
			@ApiResponse(code = 500, message="Error no esperado en el servidor")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( value= {"/api/agente/{idAgente}/multa"}, method = RequestMethod.POST)
	public ResponseEntity<Multa> crear(@RequestBody MultaPOST m,
									   @PathVariable Long idAgente) {
		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
			m.setIdAgente(idAgente.intValue());
			Multa multa = null;
			try {
				Set<ConstraintViolation<MultaPOST>> violations = validator.validate(m);
				if (violations.size() > 0) {
					LOG.debug("Multa no válida " + violations);
					response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
				}else {
					multa = agenteService.multar(m.getIdCoche(), idAgente.intValue(), m.getConcepto(), m.getImporte());
					response = new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
					LOG.info("Nueva multa creada" + m);
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
