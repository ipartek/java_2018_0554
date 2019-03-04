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
import com.ipartek.formacion.service.MultaService;
import com.ipartek.formacion.service.impl.MultaServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags = { "MULTA" }, produces = "application/json", description = "Gestión de multas")
public class MultaController {
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static MultaDAO multaDAO;
	private static CocheDAO cocheDAO;
	private static MultaService multaService;
	private ValidatorFactory factory;
	private Validator validator;

	public MultaController() {
		super();
		multaService = MultaServiceImpl.getInstance();
		multaDAO = MultaDAO.getInstance();
		cocheDAO = CocheDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(value = { "/api/multa/{idAgente}" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listar(@PathVariable String idAgente) {

		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
		try {
			long id = Long.parseLong(idAgente);
			ArrayList<Multa> multas = multaDAO.getAllByAgente(id);
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
//		int id = (int) idAgente;
//		return multaDAO.getAllByAgente(id);
	}
	@RequestMapping(value = { "/api/multa/matricula/{matricula}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> getIdByMatricula(@PathVariable String matricula) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			// OBTENER ID DEL COCHE CON MATRICULA QUE SE LE PASA
			Coche coche = multaService.conseguirId(matricula);
			response = new ResponseEntity<Coche>(coche, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		}
		
		return response;
		}

	@RequestMapping(value = { "/api/multa/" }, method = RequestMethod.POST)
	public ResponseEntity<Multa> crear(@RequestBody Multa multa) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		long idCoche = 0;
		boolean insertado = false;
		try {
			// OBTENER ID DEL COCHE CON MATRICULA QUE SE LE PASA
			Coche coche = multaService.conseguirId(multa.getCoche().getMatricula());
			idCoche = coche.getId();

		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}

		try {
			int id = (int) idCoche;
			insertado = multaService.insertar(multa, id);
//			insertado = multaDAO.insert(multa, idCoche);
			if (insertado == true) {
				response = new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}
	
	
	@RequestMapping(value = { "/api/multa/baja/{idMulta}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Multa> darDeBaja(@PathVariable int idMulta) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		boolean anulado = false;
		int id = -1;
		try {
			id = (int) idMulta;
		} catch (Exception e1) {
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}
		try {
			
			anulado = multaService.darDeBaja(id);
//			insertado = multaDAO.insert(multa, idCoche);
			if (anulado == true) {
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}

		return response;

	}
	
	@RequestMapping(value = { "/api/multa/alta/{idMulta}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Multa> darDeAlta(@PathVariable int idMulta) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		boolean alta = false;
		int id = -1;
		try {
			id = (int) idMulta;
		} catch (Exception e1) {
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}
		try {
			
			alta = multaService.darDeAlta(id);
//			insertado = multaDAO.insert(multa, idCoche);
			if (alta == true) {
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}

		return response;

	}


}

// getByMatricula

/*
 * @RequestMapping( value= {"/api/multa/{idAgente}"}, method =
 * RequestMethod.GET) public <ArrayList<Multa>> detalle( @PathVariable long
 * idAgente ){
 * 
 * return multaDAO.getAllByAgente(idAgente); ResponseEntity<Coche> response =
 * new ResponseEntity<Coche>( HttpStatus.NOT_FOUND ); try {
 * 
 * Coche coche = multaDAO.getAllByAgente(idAgente); if ( coche != null ) {
 * response = new ResponseEntity<Coche>( coche, HttpStatus.OK ); }
 * 
 * }catch ( NumberFormatException e) { response = new ResponseEntity<Coche>(
 * HttpStatus.BAD_REQUEST ); }catch (Exception e) { LOG.error(e); response = new
 * ResponseEntity<Coche>( HttpStatus.INTERNAL_SERVER_ERROR ); } return response;
 * } }
 */
