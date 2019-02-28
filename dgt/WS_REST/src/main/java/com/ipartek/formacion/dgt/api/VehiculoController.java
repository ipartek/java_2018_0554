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

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "VEHICULO" }, produces = "application/json", description="Gestión de vehiculos")
public class VehiculoController {

	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;
	private ValidatorFactory factory;
	private Validator validator;
	
	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
	@RequestMapping( value= {"/api/vehiculo"}, method = RequestMethod.GET)
	public ArrayList<Coche> listar(){		
		
		return cocheDAO.getAll();
	}
	
	
	@RequestMapping( value= {"/api/vehiculo/{matricula}"}, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle( @PathVariable String matricula ){		
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>( HttpStatus.NOT_FOUND );
		try {
			
			String identificador = matricula;
			Coche c = cocheDAO.getByMatricula(identificador);
			if ( c != null ) {
				response = new ResponseEntity<Coche>( c,  HttpStatus.OK );
			}
			
		}catch ( NumberFormatException e) {	
			response = new ResponseEntity<Coche>( HttpStatus.BAD_REQUEST );
		}catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>( HttpStatus.INTERNAL_SERVER_ERROR );
		}	 	
		return response;
	}
	
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar( @PathVariable long id ){		
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>( HttpStatus.NOT_FOUND );
		try {
			
			if ( cocheDAO.delete(id) ) {
				response = new ResponseEntity<Coche>( HttpStatus.OK );
			}
		}catch (SQLException e) {
			
			LOG.debug("No se puede eliminar coche con multas identificador= " + id);
			response = new ResponseEntity<Coche>( HttpStatus.CONFLICT );
		}catch (Exception e) {
			
			LOG.error(e);
			response = new ResponseEntity<Coche>( HttpStatus.INTERNAL_SERVER_ERROR );
		}		
		return response;
	}
	
	
	@RequestMapping( value= {"/api/vehiculo/"}, method = RequestMethod.POST)	
	@ApiResponses({
			@ApiResponse(code = 201 , message = "Vehiculo Creado"),
			@ApiResponse(code = 409 , message = "Existe Matricula"),
			@ApiResponse(code = 400 , message = "Datos Vehiculos No Validos")
	})
	public ResponseEntity<Coche> crear( @RequestBody Coche coche ){
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>( HttpStatus.INTERNAL_SERVER_ERROR );
		try {
			
			Set<ConstraintViolation<Coche>> violations = validator.validate(coche);
			if ( violations.size() > 0) {		
				LOG.debug("Coche no valido " + violations);
				response = new ResponseEntity<Coche>( HttpStatus.BAD_REQUEST );				
				
			}else {				
				Coche c  = cocheDAO.insert(coche);
				response = new ResponseEntity<Coche>( c, HttpStatus.CREATED );		
				LOG.info("Nuevo Coche creado " + c );
			}
		}catch (SQLException e) {	
			LOG.debug("Ya existe matricula " + coche.getMatricula());
			response = new ResponseEntity<Coche>( HttpStatus.CONFLICT );
			
		}catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>( HttpStatus.INTERNAL_SERVER_ERROR );
		}		
		return response;		
	}
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(  
				@PathVariable long id, 
				@RequestBody Coche coche ){
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>( HttpStatus.NOT_FOUND );
		try {
			
			Set<ConstraintViolation<Coche>> violations = validator.validate(coche);
			if ( violations.size() > 0) {		
				LOG.debug("Coche no valido " + violations);
				response = new ResponseEntity<Coche>( HttpStatus.BAD_REQUEST );				
				
			}else {				
				coche.setId(id);
				if ( cocheDAO.update(coche) ) {
					response = new ResponseEntity<Coche>( coche, HttpStatus.OK );	
				}
				
			}
		}catch (SQLException e) {	
			LOG.debug("Ya existe matricula " + coche.getMatricula());
			response = new ResponseEntity<Coche>( HttpStatus.CONFLICT );
			
		}catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>( HttpStatus.INTERNAL_SERVER_ERROR );
		}		
		return response;	
	}
	
	@RequestMapping( value= {"/api/vehiculo/{id}"}, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja( @PathVariable long id,  @RequestBody Coche coche ){		
		
		//TODO terminar
		return new ResponseEntity<Coche>( HttpStatus.NOT_IMPLEMENTED );
	}
	
	
	
	
	
}
