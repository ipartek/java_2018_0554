package com.ipartek.formacion.taller.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
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
import com.ipartek.formacion.modelo.pojo.Coche;

@CrossOrigin
@RestController
public class VehiculoController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;
	private ValidatorFactory factory;
	private Validator validator;

	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Coche> listar() {

		return cocheDAO.getMatriculas();
	}

	/**
	 * 
	 * 
	 * @param id el identificador del coche
	 * @return
	 */
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable String id) {

		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		try {

			long identificador = Long.parseLong(id);
			Coche coche = cocheDAO.getById(identificador);
			if (coche != null) {
				response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
			}

		} catch (NumberFormatException e) {
			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return elimina el campo si todo funciona, lanza excepcion si no lo hace
	 */
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable long id) {

		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		try {

			if (cocheDAO.delete(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);
			}
		} catch (SQLException e) {

			LOG.debug("No se puede eliminar coche con multas identificador= " + id);
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
		} catch (Exception e) {

			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * 
	 * 
	 * @param coche los datos del coche
	 * @return crear un nuevo coche si todo funciona, si falla lanza excepcion
	 */
//	@RequestMapping(value = { "/api/vehiculo/" }, method = RequestMethod.POST)
//	public ResponseEntity<Coche> crear(@RequestBody Coche coche) {
//
//		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
//		try {
//
//			Set<ConstraintViolation<Coche>> violations = validator.validate(coche);
//			if (violations.size() > 0) {
//				LOG.debug("Coche no valido " + violations);
//				response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
//
//			} else {
//				Coche c = cocheDAO.insertarCoche(coche);
//				response = new ResponseEntity<Coche>(c, HttpStatus.CREATED);
//				LOG.info("Nuevo Coche creado " + c);
//			}
//		} catch (SQLException e) {
//			LOG.debug("Ya existe matricula " + coche.getMatricula());
//			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
//
//		} catch (Exception e) {
//			LOG.error(e);
//			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return response;
//	}

	// Método aún no implementados

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@Valid @PathVariable long id, @RequestBody Coche coche) {

		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		try {
			if (cocheDAO.update(coche)) {
				response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
				LOG.info("Nuevos valores:  " + coche);

			}
		} catch (SQLException e) {

			LOG.error("No se ha podido actualizar los datos");
			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable long id, @RequestBody Coche coche) {

		// TODO terminar
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
	}

}