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

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "MULTA" }, produces = "application/json", description = "Gestión de multas")
public class MultaController {

	private final static Logger LOG = Logger.getLogger(MultaController.class);
	private static MultaDAO multaDAO;
	private static CocheDAO cocheDAO;
	private static AgenteServiceImpl agService;
	private ValidatorFactory factory;
	private Validator validator;

	public MultaController() {
		super();
		multaDAO = MultaDAO.getInstance();
		cocheDAO = CocheDAO.getInstance();
		agService = AgenteServiceImpl.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@RequestMapping(value = { "/api/multa/matricula/{matricula}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> getIdByMatricula(@PathVariable String matricula) {
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Coche coche = cocheDAO.getByMatricula(matricula);
			response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
		} catch (Exception e1) {
			response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		}
		
		
		return response;
		
		
		
	}

	@RequestMapping(value = { "/api/multa/{idAgente}" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> detalleByIdAgente(@PathVariable String idAgente) {

		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
		try {
			long id = Long.parseLong(idAgente);
			ArrayList<Multa> multas = agService.obtenerMultas(id);
			if (multas != null) {
				response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);
			}

		} catch (NumberFormatException e) {
			response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

//		

	}

	@RequestMapping(value = { "/api/multa/" }, method = RequestMethod.POST)
	@ApiResponses({ @ApiResponse(code = 201, message = "Multa Creada"),
			@ApiResponse(code = 409, message = "Existe Multa"),
			@ApiResponse(code = 400, message = "Datos Multas No Validos") })
	
	public ResponseEntity<Multa> crear(@RequestBody Multa multa) {
		long idCoche = 0;
		boolean insertado = false;
		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Coche coche = cocheDAO.getByMatricula(multa.getCoche().getMatricula());
			idCoche = coche.getId();
		} catch (Exception e1) {
			response = new ResponseEntity<Multa>(multa, HttpStatus.NOT_FOUND);
		}

		try {
			insertado = agService.multar(multa, idCoche);
			if (insertado == true) {
				response = new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
				LOG.info("Nuevo Coche creado " + multa);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Multa>(multa, HttpStatus.BAD_REQUEST);
		}
		return response;

	}
	
	@RequestMapping(value = { "/api/multa/alta/" }, method = RequestMethod.PATCH)
	@ApiResponses({ @ApiResponse(code = 201, message = "Multa Creada"),
			@ApiResponse(code = 409, message = "Existe Multa"),
			@ApiResponse(code = 400, message = "Datos Multas No Validos") })
	
	public ResponseEntity<Multa> darAlta(@RequestBody Multa multa) {
		boolean recuperado = false;
		
		long id = multa.getId();
		int idMulta = -1;
		
		try {
			idMulta = (int)id;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			recuperado = agService.darAlta(idMulta);
			if (recuperado == true) {
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}
		return response;

	}
	
	@RequestMapping(value = { "/api/multa/baja/" }, method = RequestMethod.PATCH)
	@ApiResponses({ @ApiResponse(code = 201, message = "Multa Creada"),
			@ApiResponse(code = 409, message = "Existe Multa"),
			@ApiResponse(code = 400, message = "Datos Multas No Validos") })
	
	public ResponseEntity<Multa> darBaja(@RequestBody Multa multa) {
		boolean anulado = false;
		long id = multa.getId();
		int idMulta = -1;
		
		try {
			idMulta = (int)id;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			anulado = agService.darBaja(idMulta);
			if (anulado == true) {
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}
		return response;

	}
	
	

}
