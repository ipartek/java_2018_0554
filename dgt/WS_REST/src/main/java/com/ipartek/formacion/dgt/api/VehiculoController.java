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

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;

@CrossOrigin
@RestController
public class VehiculoController {
	
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;

	public  VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}
	
	
	
	@RequestMapping( value= {"/api/vehiculo"},method = RequestMethod.GET)
	public ArrayList<Coche> listar(){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		coches=cocheDAO.getAll();
		return coches;
	}
	
	
	
	@RequestMapping( value= {"/api/vehiculo/{id}"},method = RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable String id){
		Coche c = new Coche();
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);

		try {
			Long idp=Long.parseLong(id);
			c = cocheDAO.getById(idp);
			if (c!=null) {//coche encontrado
				 response = new ResponseEntity<Coche>(c,HttpStatus.OK);
			}
		}catch(Exception e) {//Captura la excepcion del parseo y envia status error: 400
			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
			LOG.debug(HttpStatus.BAD_REQUEST+" "+ e);
		}
		
		return response;
	}
	
	
	
	
	@RequestMapping( value= {"/api/vehiculo/{id}"},method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable String id){
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		Long idp=0L;
		try {
			idp=Long.parseLong(id);//se intenta parsear si no puede es k no es numero 
	
					try {
						boolean b = cocheDAO.delete(idp);
						if (b==true) {//coche eliminado 200 
							 response = new ResponseEntity<Coche>(HttpStatus.OK);
						}else if(b==false) {
							response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
						}
					}catch(Exception e) {//coche con conflicto 409
						response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
						LOG.debug(HttpStatus.CONFLICT+" "+ e);
					}
		}catch(Exception e) {//Captura la excepcion del parseo y envia status error: 400
			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
			LOG.debug(HttpStatus.BAD_REQUEST+" "+ e);
		}
		return response;
	}
	
	
	@RequestMapping( value= {"/api/vehiculo"},method = RequestMethod.POST)
	public ResponseEntity<Coche> crear(@RequestBody Coche c){
		
		//201 creado y retornar coche con id
		// TODO 400 datso incorrectos
		//409 ya existe la matricual del coche UQ
		
		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		
		try {
			boolean b = cocheDAO.insert(c);
			if (b==true) {//coche insertado 200 
				 response = new ResponseEntity<Coche>(HttpStatus.OK);
			}
		}catch(Exception e) {//coche con conflicto 409 poruqe la matricula ya existe
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
			LOG.debug(HttpStatus.CONFLICT+" "+ e);
		}
		
		return response;
	}
	
	
	
	
	
	
	@RequestMapping( value= {"/api/vehiculo/{id}"},method = RequestMethod.PATCH)
	public ResponseEntity<Coche> baja(@PathVariable String id, @RequestBody Coche c){
		
//TODO 409 cuando no se pueda eliminar coche pork tien multas asociadas
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
	}
	

	
	
	
	
	
	
	
	
	@RequestMapping( value= {"/api/vehiculo/{id}"},method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@PathVariable String id, @RequestBody Coche c){
		//TODO terminar
		//201 creado y retornar coche con id
		//400 datso incorrectos
		//409 ya existe la matricual del coche UQ
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
	}
	
}
