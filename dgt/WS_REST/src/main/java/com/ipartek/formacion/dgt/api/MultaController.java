package com.ipartek.formacion.dgt.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	private final static Logger LOG = Logger.getLogger(MultaController.class);
	private static MultaDAO multaDAO;
	private static MultaService multaService;

	public MultaController() {
		super();
		multaService = MultaServiceImpl.getInstance();
		multaDAO = MultaDAO.getInstance();

	}

	@RequestMapping(value = { "/api/multa/{idAgente}" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listar(@PathVariable String idAgente) {

		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
		try {
			long id = Long.parseLong(idAgente);
			LOG.trace("Intenta parsear el id de agente pasado a int");

			ArrayList<Multa> multas = multaDAO.getAllByAgente(id);
			LOG.trace("Busca con el id agente las multas asociadas");

			if (multas != null) {
				LOG.trace("Si encuentra multas, devuelve arraylist y el OK");
				response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);
			}

		} catch (NumberFormatException e) {
			LOG.error("BAD REQUEST(Number format exception) si el id que se le pasa no es numerico" + e);
			response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOG.error("INTERNAL_SERVER_ERROR error inesperado del servidor" + e);
			response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@RequestMapping(value = { "/api/multa/matricula/{matricula}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> getIdByMatricula(@PathVariable String matricula) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			// OBTENER ID DEL COCHE CON MATRICULA QUE SE LE PASA
			LOG.trace("Al pasar la matricula obtiene todos los datos del coche");
			Coche coche = multaService.conseguirId(matricula);
			response = new ResponseEntity<Coche>(coche, HttpStatus.OK);

		} catch (Exception e) {
			LOG.warn("No ha encontrado coche con la matricula pasada" + e);
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
			LOG.trace("Consigue id del coche a traves de la matricula");
			Coche coche = multaService.conseguirId(multa.getCoche().getMatricula());
			idCoche = coche.getId();

		} catch (Exception e) {
			LOG.trace("Si no encuentra la matricula" + e);
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}

		try {
			int id = (int) idCoche;
			LOG.trace("Intenta insertar la multa");
			insertado = multaService.insertar(multa, id);
//			insertado = multaDAO.insert(multa, idCoche);
			if (insertado == true) {
				LOG.trace("Se ha insertado la multa");
				response = new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			LOG.error("Se ha hecho mal el body de la multa" + e);
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@RequestMapping(value = { "/api/multa/baja/" }, method = RequestMethod.PATCH)
	public ResponseEntity<Multa> darDeBaja(@RequestBody Multa multa) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		boolean anulado = false;
		long id = multa.getId();
		int idMulta = -1;
		try {
			LOG.trace("Coge el id multa para darla de baja");
			idMulta = (int) id;
		} catch (Exception e1) {
			LOG.trace("No ha conseguido coger el id de la multa");
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}
		try {
			LOG.trace("Intenta dar de baja la multa");
			anulado = multaService.darDeBaja(idMulta);
//			insertado = multaDAO.insert(multa, idCoche);
			if (anulado == true) {
				LOG.trace("La multa se ha dado de baja correctamente");
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			LOG.trace("Si no encuentra la multa con ese id" + e);
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}

		return response;

	}

	@RequestMapping(value = { "/api/multa/alta/" }, method = RequestMethod.PATCH)
	public ResponseEntity<Multa> darDeAlta(@RequestBody Multa multa) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		boolean alta = false;
		long id = multa.getId();
		int idMulta = -1;
		try {
			LOG.trace("Coge el id multa para darla de alta");
			idMulta = (int) id;
		} catch (Exception e1) {
			LOG.trace("No ha conseguido coger el id de la multa");
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}
		try {
			LOG.trace("Intenta dar de alta la multa");
			alta = multaService.darDeAlta(idMulta);
//			insertado = multaDAO.insert(multa, idCoche);
			if (alta == true) {
				LOG.trace("La multa se ha dado de alta correctamente");
				response = new ResponseEntity<Multa>(HttpStatus.OK);
			}
		} catch (Exception e) {
			LOG.trace("Si no encuentra la multa con ese id" + e);
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
