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

@CrossOrigin
@RestController
@Api(tags = { "VEHICULO" }, produces="application/json", value="Gestión de Vehículos")
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
	 * Muestra ona lista de todos los vehiculos.
	 * @return  todos los coches
	 * @return error 404 si no se encuentran
	 */
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Mostrando vehiculos encontrados"),
			@ApiResponse(code = 404, message="No se han encontrado vehiculos")
	})
	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Coche>> listar() {
		ResponseEntity<ArrayList<Coche>> response = new ResponseEntity<ArrayList<Coche>>(HttpStatus.NOT_FOUND);
		ArrayList<Coche> coches = cocheDao.getAll();
		if (coches.size() > 0) {
			response = new ResponseEntity<ArrayList<Coche>>(coches, HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Muestra el coche correspondiente a cierta matricula
	 * @param matricula
	 * @return El vehiculo correspondiente a la matricula. 404 si no lo encuentra
	 */
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Mostrando el vehiculo enconteado"),
			@ApiResponse(code = 404, message="La matricula no existe"),
			@ApiResponse(code = 400, message="Matricula escrita de forma incorrecta - 0000XYZ")
})
	@RequestMapping( value= {"/api/vehiculo/{matricula}"}, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable String matricula) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		Coche c = cocheDao.getByMatricula(matricula);
		try {
		if (c != null) {
			response = new ResponseEntity<Coche>(c, HttpStatus.OK);
		}
		}catch (NumberFormatException e) {
			response = new ResponseEntity<Coche>(c, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	
	
	
	
}
