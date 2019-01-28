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

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@CrossOrigin
@RestController
//@RequestMapping({"/api/vehiculo/"}) Podemos poner uno general para todos los métodos que hay dentro
public class VehiculoController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	public static CocheDAO cocheDao;
	private ValidatorFactory factory;
	 private Validator validator;
	
	public VehiculoController() {
		super();
		cocheDao = CocheDAO.getInstance();
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	/**
	 * Obtiene un listado de todos los vehículos registrados.
	 * @return OK(200) Si existen coches en la BD. Además, devolverá todos los coches.
	 * @return NOT_FOUND(404) Si no existen coches en la BD.
	 */
	@RequestMapping( value= {"/api/vehiculo"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Coche>> listar(){
		ResponseEntity<ArrayList<Coche>> response = new ResponseEntity<ArrayList<Coche>>(HttpStatus.NOT_FOUND);
		ArrayList<Coche> coches = cocheDao.getAll();
		if (coches.size() > 0) {
			response = new ResponseEntity<ArrayList<Coche>>(coches, HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Método para ver el detalle de un Coche mediante su ID.
	 * @param id Del coche sobre el que se quiere obtener el detalle.
	 * @return NOT_FOUND(404) Si el coche no existe.
	 * @return OK(200) Si el coche existe. Además, se devolverán los datos del coche.
	 * @return BAD_REQUEST(400) Si el formato del ID es incorrecto (letras).
	 */
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable Long id) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		Coche c = cocheDao.getBYId(id);
		try {
		if (c.getId() != null) {
			response = new ResponseEntity<Coche>(c, HttpStatus.OK);
		}
		}catch (NumberFormatException e) {
			response = new ResponseEntity<Coche>(c, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	/**
	 * Método para eliminar un coche que no tenga multas asociadas.
	 * @param id Del coche que se desea eliminar.
	 * @return NOT_FOUND (404) Si no existe.
	 * @return BAD_REQUEST (400) Si el formato no es válido.
	 * @return CONFLICT (409) Si no puede eliminarse porque tiene multas asociadas.
	 * @return OK (200) Si se ha eliminado correctamente.
	 */
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable Long id) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		try {
			if (cocheDao.delete(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);
			}
		}catch (NumberFormatException e) {
			//400
			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
		}catch (MySQLIntegrityConstraintViolationException e) {
			//409 cuando no se pueda eliminar coche cuando tenga multas asociadas
			//Enviar mensaje en la response????
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Método que da de baja el coche cuyo ID recibe por parámetro. 
	 * Rellena su campo fecha_baja con la fecha actual en el momento de la ejecución de este método. 
	 * @param id Del coche que se quiere dar de baja. 
	 * @param coche NO IMPLEMENTADO.
	 * @return NOT_FOUND (404) El coche no existe en la BD.
	 * @return OK (200) El coche se ha dado de baja.
	 * @return BAD_REQUEST (400) Si el formato del ID no es válido (letras).
	 */
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable Long id, @RequestBody Coche coche) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		try {
			if (cocheDao.darDeBaja(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);
			}
		}catch (NumberFormatException e) {
			//400
			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	/**
	 * Método que permite la creación de un nuevo coche en la base de datos.
	 * @param coche a insertar en la base de datos.
	 * @return BAD_REQUEST (400) Si los datos del coche no son correctos.  P.E: sin matrícula o vacía
	 * @return NOT_FOUND (404) Si ocurre un error inesperado.
	 * @return CONFLICT (409) Si la matricula del coche a insertar ya existe en la BD.
	 * @return CREATED (201) Si la inserción es correcta.
	 * @return INTERNAL_SERVER_ERROR (500) Si ocurre cualquier otra Excepción (Mirar log para más info).
	 */
	@RequestMapping( value= {"/api/vehiculo/"}, method = RequestMethod.POST)
	public ResponseEntity<Coche> crear(@RequestBody Coche coche) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
			//TODO Crear coche
			try {
				Set<ConstraintViolation<Coche>> violations = validator.validate(coche);
				if (violations.size() > 0) {
					LOG.debug("Coche no válido " + violations);
					response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
				}else {
				//201 crear y retornar coche con id actualizado
				cocheDao.insert(coche);
				response = new ResponseEntity<Coche>(coche, HttpStatus.CREATED);
				LOG.info("Nuevo coche creado" + coche);
				}
			}catch (MySQLIntegrityConstraintViolationException e) {
				//409 Ya existe la matrícula del coche
				LOG.debug("Ya existe la matrícula " + coche.getMatricula());
				response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
			} 
			catch (Exception e) {
				LOG.error(e);
				//Error 500
				response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		return response;
	}
	
	/**
	 * Método para actualizar los datos de un coche
	 * @param id del coche a actualizar 
	 * @param coche datos nuevos del coche
	 * @return NOT_FOUND(404) Ha ocurrido un error actualizando el coche, P.E: Datos no válidos (error en el formato).
	 * @return OK(200) El coche ha sido actualizado correctamente.
	 */
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@PathVariable Long id, @RequestBody Coche coche) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		
		try {
			cocheDao.update(coche);
			response = new ResponseEntity<Coche>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return response;
	}
	
}
