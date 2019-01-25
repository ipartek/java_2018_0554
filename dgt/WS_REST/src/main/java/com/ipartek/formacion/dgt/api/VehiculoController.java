package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
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

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@CrossOrigin //aceptamos peticiones de javascript de otros origenes
@RestController
public class VehiculoController {
	
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	public static CocheDAO cocheDAO;
	
	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
	}
	
	/**
	 * GETALL
	 * @return
	 */
	@RequestMapping(value=("/api/vehiculo"), method=RequestMethod.GET)
	public ArrayList<Coche> listar(){
		return cocheDAO.getAll();
	}
	
	/*
	 * RequestParam para parametros. ej: ?id=1 @RequestParam(value="id") Long id
	 * PathVariable para uris. ej: @PathVariable long id
	 */
	/**
	 * GET BY ID
	 * @param id
	 * @return
	 */
	@RequestMapping(value=("/api/vehiculo/{id}"),method=RequestMethod.GET)
	public ResponseEntity<Coche> detalle(@PathVariable long id){
		Coche c = null;
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(c,HttpStatus.NOT_FOUND);
		
		if(id>0) {
			c= cocheDAO.getBYId(id);
			response = new ResponseEntity<Coche>(c,HttpStatus.OK);
		}
		
		return response;
	}
	
	/**
	 * INSERT
	 * @param coche
	 * @return
	 */
	@RequestMapping(value=("/api/vehiculo"), method=RequestMethod.POST)
	public ResponseEntity<Coche> crear(@RequestBody Coche coche){
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);//404
	
		try {
			if(cocheDAO.insert(coche)) {
				response = new ResponseEntity<Coche>(HttpStatus.CREATED);//201
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);//409
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * DELETE
	 * @param id
	 * @return
	 */
	@RequestMapping(value=("/api/vehiculo/{id}"),method=RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable long id){
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);//404
		
		try {
			if(cocheDAO.delete(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);//200
			}
		}catch (MySQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);//409
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * UPDATE
	 * @param id
	 * @param coche
	 * @return
	 */
	@RequestMapping(value=("/api/vehiculo/{id}"), method=RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(
			@PathVariable long id,
			@RequestBody Coche coche){
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);//404
		
		try {
			if(cocheDAO.updateCoche(coche)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);//200
			}
		}catch (MySQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);//409
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	

	/**
	 * UPDATE PARCIAL, fecha baja
	 * @param id
	 * @param coche
	 * @return
	 */
	@RequestMapping(value=("/api/vehiculo/{id}"),method=RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable long id){
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);//404
		
		try {
			if(cocheDAO.darDeBajaCoche(id)) {
				response = new ResponseEntity<Coche>(HttpStatus.OK);//200
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return response;
	}
	
	
}
