package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.modelo.pojo.MultaCreada;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin
@RestController
@Api(tags = { "AGENTE" }, produces = "application/json", description="Gestión de multas por agente")
public class LogicaController  {

	private final static Logger LOG = Logger.getLogger(LogicaController.class);
	private AgenteService agenteService;
	private ValidatorFactory factory;
	private Validator validator;
	
	public LogicaController() {
		super();
		agenteService = AgenteServiceImpl.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
	//LOGIN
	
	@RequestMapping( value= {"/api/agente/login/{placa}/{password}"}, method = RequestMethod.GET)
	public ResponseEntity<Agente> login( 
										@PathVariable String placa, 
										@PathVariable String password ){		
		
		ResponseEntity<Agente> response = new ResponseEntity<Agente>(HttpStatus.FORBIDDEN);
		try {
			
			Agente agente = agenteService.existe(placa, password);
			if ( agente !=null ) {
				response = new ResponseEntity<Agente>(agente, HttpStatus.OK);
			}		
			
		}catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Agente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}
	
	
	// LISTAR MULTAS POR ID AGENTE
	@RequestMapping( value= {"/api/agente/{id}/multas"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> getMultasByIdAgente ( @PathVariable int id ){
		
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>( HttpStatus.NOT_FOUND );
		try {
			ArrayList<Multa> multas = new ArrayList<Multa>();
			multas =  (ArrayList<Multa>) agenteService.listarMultas(id);
			response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK );
			
		}catch(Exception e) {
			e.printStackTrace();  // falta log
		}
		return response;
	}

	// LISTAR MULTAS ANULADAS POR ID AGENTE
	@RequestMapping( value= {"/api/agente/{id}/multasAnuladas"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> getMultasAnuladasByIdAgente ( @PathVariable int id ){
		
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>( HttpStatus.NOT_FOUND );
		try {
			ArrayList<Multa> multas = new ArrayList<Multa>();
			multas =  (ArrayList<Multa>) agenteService.listarMultasAnuladas(id);
			response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK );
			
		}catch(Exception e) {
			e.printStackTrace();  // falta log
		}
		return response;
	}

	
	// buscar por matricula
	@RequestMapping( value= {"/api/agente/{matricula}"}, method = RequestMethod.GET)
	public ResponseEntity<Coche> getByMatricula ( @PathVariable String matricula ){
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>( HttpStatus.NOT_FOUND );
		try {
			Coche coche = new Coche();
			coche =  (Coche) agenteService.buscarMatricula(matricula);
			
			if(coche==null) {
				response = new ResponseEntity<Coche>(coche, HttpStatus.NOT_FOUND );
			}else {
				response = new ResponseEntity<Coche>(coche, HttpStatus.OK );
			}
		
		}catch(Exception e) {
			LOG.debug("Ya existe matricula ");
		}
		return response;
	}



// CREAR MULTA
	
	@RequestMapping( value= {"/api/vehiculo/multas"}, method = RequestMethod.POST)	
	@ApiResponses({
			@ApiResponse(code = 201 , message = "multa creada"),
			@ApiResponse(code = 409 , message = "Existe Multa"),
			@ApiResponse(code = 400 , message = "Datos Multa No Validos")
	})
	public ResponseEntity<MultaCreada> insert(@RequestBody MultaCreada multa) {

		ResponseEntity<MultaCreada> response = new ResponseEntity<MultaCreada>(HttpStatus.INTERNAL_SERVER_ERROR);
	
		boolean insertado = false;

		response = new ResponseEntity<MultaCreada>(HttpStatus.NOT_FOUND);

		try {
			
			insertado = agenteService.multar(multa);

			if (insertado == true) {
				response = new ResponseEntity<MultaCreada>(multa, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			response = new ResponseEntity<MultaCreada>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}
	

}