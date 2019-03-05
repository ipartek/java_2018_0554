package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;
import com.ipartek.appMultas.modelo.service.impl.AgenteServiceImpl;
import com.ipartek.formacion.dgt.api.model.MultaPOST;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

	@CrossOrigin
	@RestController
	@Api(tags = { "AGENTES" }, produces = "application/json", value = "Gestor agentes")

public class AgenteController {

	private final static Logger LOG = Logger.getLogger(AgenteController.class);

	public static AgenteServiceImpl agenteService;
	public static MultaDAO multaDao;
	private ValidatorFactory factory;
	private Validator validator;

	public AgenteController() {

		super();
		agenteService = AgenteServiceImpl.getInstance();
		multaDao = MultaDAO.getInstance();

		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Método login que autoriza al agente
	 * @param placa    String
	 * @param password String
	 * @return si existe obtiene los datos, falla si no lo encuentra
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "LOGUEADO CON EXITO"),
			
		@ApiResponse(code = 403, message = "CREDENCIALES INCORRECTAS"),
		@ApiResponse(code = 500, message = "ERROR DEL SERVIDOR") })

	@RequestMapping(value = { "/api/login/{placa}/{pass}" }, method = RequestMethod.GET)
	public ResponseEntity<Agente> login(@PathVariable String placa, @PathVariable String pass) {
		
		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.FORBIDDEN);

		try {
				Agente agente = agenteService.existe(placa, pass);
	
				if (agente != null) {
					response = new ResponseEntity<Agente>(agente, HttpStatus.OK);
			}
		} catch (Exception e) {
			
				LOG.error(e);
				// Error 500
				response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	/**
	 * Método para registrar una multa
	 * @param coche
	 * @return 201 - Si lo encuentra, en caso contrario 400
	 * @return 500 - ERROR DEL SERVIDOR
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "multa registrada"),
			@ApiResponse(code = 400, message = "Los parametros son incorrectos"),
			@ApiResponse(code = 500, message = "Error no esperado en el servidor")
	
	})
	
	@ResponseStatus(HttpStatus.CREATED)
	
	@RequestMapping(value = { "/api/agente/{idAgente}/multa" }, method = RequestMethod.POST)
	public ResponseEntity<Multa> crear(@RequestBody MultaPOST m, @PathVariable Long idAgente) {
		
		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		m.setIdAgente(idAgente.intValue());
		Multa multa = null;
		
		try {
				Set<ConstraintViolation<MultaPOST>> violations = validator.validate(m);
				if (violations.size() > 0) {
					LOG.debug("Multa invalida, " + violations);
					response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
					
			} else {
				
					multa = agenteService.multar(m.getIdCoche(), idAgente.intValue(), m.getConcepto(), m.getImporte());
					response = new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
					LOG.info("Multa creada con exito" + m);
			}
				
		} catch (Exception e) {
			
			LOG.error(e);
			// Error 500
			response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	/**
	 * Metodo para mostrar una lista de las multas de un agente
	 * 
	 * @return multas de un determinado agente. Error si no las encuentra
	 * 
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Mostrando multas encontradas"),
			
			@ApiResponse(code = 404, message = " No se han encontrado multas") })
	
	@RequestMapping(value = { "/api/agente/{id}/multa" }, method = RequestMethod.GET)
	
	public ResponseEntity<ArrayList<Multa>> listar(@PathVariable Long id) {
		
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
		HashMap<Long, Multa> hashMultas;
		
		try {
			
			hashMultas = multaDao.getAllByIdAgente(id);
			ArrayList<Multa> multas = new ArrayList<Multa>(hashMultas.values());
			if (multas.size() > 0) {
				response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	
	/**
	 * Metodo para mostrar una lista de las multas anuladas por un agente
	 * @return multas de un determinado agente. Error 404 si no las encuentra
	 */
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Mostrando multas encontradas"),
			@ApiResponse(code = 404, message="No se han encontrado multas")
	})
	@RequestMapping( value= {"/api/agente/{id}/anuladas"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listarAnuladas(@PathVariable Long id){
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
		HashMap<Long, Multa> hashMultas;
		try {
			hashMultas = multaDao.getAllByIdAgenteAnulada(id);
			ArrayList<Multa> multas = new ArrayList<Multa>(hashMultas.values());
			if (multas.size() > 0) {
				response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
}
