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

import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.impl.AgenteServiceImpl;

@CrossOrigin
@RestController
public class AgenteController {

	private final static Logger LOG = Logger.getLogger(AgenteController.class);
	private AgenteService agenteService;
	private ValidatorFactory factory;
	private Validator validator;
	
	public AgenteController() {
		super();
		agenteService = AgenteServiceImpl.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	
	
	
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
	

	@RequestMapping(value = { "/api/agente/{id}/multas" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listar(@PathVariable long id) {
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);

		try {

			ArrayList<Multa> multas = new ArrayList<Multa>();
			multas = (ArrayList<Multa>) agenteService.obtenerMultas(id);

			response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
//	
//	@RequestMapping(value = { "/api/agente/{id}/multasbaja" }, method = RequestMethod.GET)
//	public ResponseEntity<ArrayList<Multa>> listarAnuladas(@PathVariable long id) {
//		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
//
//		try {
//
//			ArrayList<Multa> multas = new ArrayList<Multa>();
//			multas = (ArrayList<Multa>) agenteService.obtenerMultasAnuladas(id);
//
//			response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return response;
//	}
	
	@RequestMapping(value = { "/api/multa/" }, method = RequestMethod.POST)
	public ResponseEntity<Multa> crear(@RequestBody Multa multa) {

		ResponseEntity<Multa> response = new ResponseEntity<Multa>(HttpStatus.INTERNAL_SERVER_ERROR);
		long idCoche = 0;
		boolean insertado = false;
		try {
			// OBTENER ID DEL COCHE CON MATRICULA QUE SE LE PASA
			Coche coche = agenteService.idCoche(multa.getCoche().getMatricula());
			idCoche = coche.getId();

		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.NOT_FOUND);
		}

		try {
			int id = (int) idCoche;
			insertado = agenteService.multar(multa, id);
//			insertado = multaDAO.insert(multa, idCoche);
			if (insertado == true) {
				response = new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Multa>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}
	
	
	
	
}