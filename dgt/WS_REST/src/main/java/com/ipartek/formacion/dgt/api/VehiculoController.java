package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.VehiculoDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import com.ipartek.formacion.modelo.pojo.Vehiculo;

@CrossOrigin // restriccion de js
@RestController
@Api(tags = { "VEHICULO" }, produces = "application/json", description = "Gestión de Vehiculos")
public class VehiculoController {
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static VehiculoDAO cocheDAO;

	private ValidatorFactory factory;
	private Validator validator;

	public VehiculoController() {
		super();
		cocheDAO = VehiculoDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// LISTAR
	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Vehiculo> listar() {

		/*
		 * ArrayList<Coche> coches = new ArrayList<Coche>(); coches.add(new Coche (1L,
		 * "BI0000CM", "Fiat", 3455)); coches.add(new Coche (2L, "ZA0000HK",
		 * "Flagoneta", 3455));
		 */
		// return coches;
		return cocheDAO.getAll();
	}

	/*
	 * @RequestMapping(value= {"/api/vehiculo/{id}"}, method = RequestMethod.GET)
	 * public Coche detalle(@PathVariable long id){
	 * 
	 * Coche c = new Coche (2L, "ZA0000HK", "Flagoneta", 3455); c.setId(id);
	 * 
	 * return c;
	 * 
	 * }
	 */

	// VEHICULO por id

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Vehiculo> detalleId(@PathVariable String id) {
		/*
		 * ResponseEntity<Coche> response = null;
		 * 
		 * if (id > 0) { Coche c = new Coche(2L, "ZA0000HK", "Flagoneta", 3455);
		 * c.setId(id); response = new ResponseEntity<Coche>(c, HttpStatus.OK); } else
		 * {// coche no existe
		 * 
		 * response = new ResponseEntity<Coche>(c, HttpStatus.NOT_FOUND); }
		 */
		ResponseEntity<Vehiculo> response = new ResponseEntity<Vehiculo>(HttpStatus.BAD_REQUEST);

		try {
			long identificador = Long.parseLong(id);
			Vehiculo coche = cocheDAO.getById(identificador);
			if (coche == null) {
				response = new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<Vehiculo>(HttpStatus.OK);
			}
		} catch (NumberFormatException e) {
			response = new ResponseEntity<Vehiculo>(HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Vehiculo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
		// TODO con dao
	}

	// ELIMINAR
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Vehiculo> eliminar(@PathVariable long id) throws SQLException {

		ResponseEntity<Vehiculo> response = new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);

		try {

			if (cocheDAO.eliminar(id)) {

				response = new ResponseEntity<Vehiculo>(HttpStatus.OK);
			}
		} catch (SQLException e) {
			// TODO 409 cuando no se pueda eliminar Coche porque tiene multas asociadas
			LOG.debug("No se puede eliminar coche con multas identificador = " + id);
			response = new ResponseEntity<Vehiculo>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Vehiculo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	// CREAR
	@RequestMapping(value = ("/api/vehiculo"), method = RequestMethod.POST)
	@ApiResponses({ @ApiResponse(code = 201, message = "Vehiculo creado"),
			@ApiResponse(code = 409, message = "Existe Matricula") })
	public ResponseEntity<Vehiculo> crear(@Valid @RequestBody Vehiculo coche) {
		ResponseEntity<Vehiculo> response = new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);// 404

		try {
			Set<ConstraintViolation<Vehiculo>> violations = validator.validate(coche);
			if (violations.size() > 0) {
				response = new ResponseEntity<Vehiculo>(HttpStatus.BAD_REQUEST);
			} else {
				Vehiculo c = cocheDAO.insert(coche);
				response = new ResponseEntity<Vehiculo>(HttpStatus.CREATED);
				LOG.info("Nuevo Coche creado " + c);
			}
		} catch (SQLException e) {
			LOG.debug("Ya existe matricula " + coche.getMatricula());
			response = new ResponseEntity<Vehiculo>(HttpStatus.CONFLICT);

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Vehiculo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	

	// MODIFICAR
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Vehiculo> modificar(@Valid @PathVariable long id, @RequestBody Vehiculo coche) {
		ResponseEntity<Vehiculo> response = new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);

		try {
			Set<ConstraintViolation<Vehiculo>> violations = validator.validate(coche);
			if (violations.size() > 0) {
				LOG.debug("Coche no valido " + violations);
				response = new ResponseEntity<Vehiculo>(HttpStatus.BAD_REQUEST);

			} else {
				coche.setId(id);
				if (cocheDAO.update(coche)) {
					response = new ResponseEntity<Vehiculo>(coche, HttpStatus.OK);
				}

			}
		} catch (SQLException e) {
			LOG.debug("Ya existe matricula " + coche.getMatricula());
			response = new ResponseEntity<Vehiculo>(HttpStatus.CONFLICT);

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Vehiculo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	// DAR DE BAJA
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Vehiculo> darDeBaja(@PathVariable String id, @RequestBody Vehiculo coche) throws SQLException {
		ResponseEntity<Vehiculo> response = new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);
		try {
			int identificador = Integer.parseInt(id);
			Vehiculo c = cocheDAO.getById(identificador);
			if (c != null) {
				c.setModelo(coche.getModelo());
				c.setKm(coche.getKm());
				if (cocheDAO.update(c)) {
					response = new ResponseEntity<Vehiculo>(c, HttpStatus.OK);
				}
			}
		} catch (SQLException e) {
			LOG.debug(e);
			response = new ResponseEntity<Vehiculo>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Vehiculo>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}