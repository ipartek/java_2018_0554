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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin // aceptamos peticiones de javascript de otros origenes
@RestController
/*
 * @RequestMapping("/api/vehiculo/") Se puede marcar la ruta para todo el
 * controlador y en cada metodo se pondra el extra,es decir, esto sirve para
 * poner algo en comun.
 */
@Api(tags = { "VEHICULOS" }, produces = "application/json", description="Gestión de Vehiculos")
public class VehiculoController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	public static CocheDAO cocheDAO;
	private ValidatorFactory factory;
	private Validator validator;

	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Metodo que devuelve todos lo vehiculos que se encuentran en la base de datos
	 * 
	 * @return Devuelve un arraylist de coches
	 */
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Metodo que devuelve todos lo vehiculos que se encuentran en la base de datos")})
	@RequestMapping(value = ("/api/vehiculo"), method = RequestMethod.GET)
	public ArrayList<Coche> listar() {
		return cocheDAO.getAll();
	}

	/**
	 * Obtiene un coche a traves del id del coche
	 * @param id enviado para buscar el coche en concreto.
	 * @return Devuelve un ResponseEntity, el cual devuelve el coche y el código de
	 *         estado 404 o 200 200 --> Lo ha encontrado satisfactoriamente 404 -->
	 *         El recuros no se ha encontrado
	 */
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Obtiene un coche a traves del id del coche"),
			@ApiResponse(code=404, message="Vehículo no encontrado")})
	@RequestMapping(value = ("/api/vehiculo/{id}"), method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable long id) {
		Coche c = null;
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(c, HttpStatus.NOT_FOUND);

		if (id > 0) {
			c = cocheDAO.getBYId(id);
			response = new ResponseEntity<Coche>(c, HttpStatus.OK);
		}

		return response;
	}

	/**
	 * Este método inserta un nuevo vehículo/coche.
	 * @param coche Es el coche que se va a intentar introducir en la base de datos
	 * @return Devuelve un código de estado: 201 --> se ha creado el coche
	 *         correctamente. 404 --> El recurso no se ha encontrado. 409--> Hay un
	 *         coche ya registrado con esa matricula por eso devuelve un conflicto
	 */
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Este método crear un nuevo vehículo/coche y lo inserta en la BD."),
			@ApiResponse(code=409, message="Existe Matricula"),
			@ApiResponse(code=404, message="Datos Vehículo no valido")})
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = ("/api/vehiculo"), method = RequestMethod.POST)
	public ResponseEntity<Coche> crear(@RequestBody Coche coche) {
		// EL @Valid sirve para hacer las comprobaciones de Javaxx Validation
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Coche>> violations = validator.validate(coche);
			if (violations.size() > 0) {
				LOG.debug("Coche no valido " + violations);
				response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);

			} else {
				if(cocheDAO.insert(coche)) {
					response = new ResponseEntity<Coche>(HttpStatus.CREATED);
					LOG.info("Nuevo Coche creado " + coche);
				}
			}
		} catch (SQLException e) {
			LOG.debug("Ya existe matricula " + coche.getMatricula());
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * Elimina un coche,permanentemente, de la base de datos
	 * @param id Se le manda el id del coche que se quiere eliminar
	 * @return Devuelve un estado. 200 --> se ha realizado la consulta correctamente
	 *         404 --> El recurso no se ha encontrado. 409--> Ese coche tiene alguna
	 *         multa asociada, devuelve conflicto
	 */
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Elimina un coche,permanentemente, de la base de datos"),
			@ApiResponse(code=409, message="No se puede eliminar porque tiene multas asignadas"),
			@ApiResponse(code=404, message="Vehículo no encontrado")})
	@RequestMapping(value = ("/api/vehiculo/{id}"), method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable long id) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);// 404

		try {
			if (cocheDAO.delete(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);// 200
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);// 409
			e.printStackTrace();
		} catch (SQLException e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * Este metodo sirve para actualizar todo el coche
	 * @param id    Se le envia el id del coche.
	 * @param coche Se envia el coche modificado
	 * @return 200 -->se ha realizado la consulta correctamente 404 --> El recurso
	 *         no se ha encontrado. 409--> Hay un coche ya registrado con esa
	 *         matricula por eso devuelve un conflicto
	 */
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Este metodo sirve para actualizar todo el coche"),
			@ApiResponse(code=409, message="Existe un coche registrado con esa matrícula"),
			@ApiResponse(code=404, message="El vehículo no se ha encontrado")})
	@RequestMapping(value = ("/api/vehiculo/{id}"), method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@PathVariable long id, @RequestBody Coche coche) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);// 404
		try {
			
			Set<ConstraintViolation<Coche>> violations = validator.validate(coche);
			if (violations.size() > 0) {
				LOG.debug("Coche no valido " + violations);
				response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);

			} else {
				if (cocheDAO.updateCoche(coche)) {
					response = new ResponseEntity<Coche>(HttpStatus.OK);// 200
				}
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);// 409
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * Este update es "parcial", ya que actualiza solamente un campo-->"fecha_baja", de esta manera se realiza un borrado lógico.
	 * @param id Se le envia el id del coche para identificarlo
	 * @return Devuelve un código de estado: 200 -->se ha realizado la consulta
	 *         correctamente 404 --> El recurso no se ha encontrado.
	 * 
	 */
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Este update es \"parcial\", ya que actualiza solamente un campo-->\"fecha_baja\", de esta manera se realiza un borrado lógico."),
			@ApiResponse(code=201, message="Vehículo modificado"),
			@ApiResponse(code=404, message="El vehículo no se ha encontrado")})
	@RequestMapping(value = ("/api/vehiculo/{id}"), method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable long id) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);// 404

		try {
			if (cocheDAO.darDeBajaCoche(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);// 200
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return response;
	}

}
