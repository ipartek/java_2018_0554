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

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@CrossOrigin

@RestController
public class VehiculoController {
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;


	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();

	}

	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Coche> listar() {

		/*
		 * ArrayList<Coche> coches = new ArrayList<Coche>(); coches.add(new Coche (1L,
		 * "BI0000CM", "Fiat", 3455)); coches.add(new Coche (2L, "ZA0000HK",
		 * "Flagoneta", 3455));
		 */
		// return coches;
		return cocheDAO.getCoche();
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
	
	//VEHICULO por id

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalleId(@PathVariable long id){
		/*
		 * ResponseEntity<Coche> response = null;
		 * 
		 * if (id > 0) { Coche c = new Coche(2L, "ZA0000HK", "Flagoneta", 3455);
		 * c.setId(id); response = new ResponseEntity<Coche>(c, HttpStatus.OK); } else
		 * {// coche no existe
		 * 
		 * response = new ResponseEntity<Coche>(c, HttpStatus.NOT_FOUND); }
		 */
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);

		if (id > 0) {
			Coche c = new Coche();
			
			c = cocheDAO.getById(id);
			
			response = new ResponseEntity<Coche>(c, HttpStatus.OK);
			
		}

		return response;
		//TODO con dao
	}
	
	//VEHICULO por matricula
	
	
	
	
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable long id) throws SQLException {

		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
	

		try {
			
			if (cocheDAO.eliminar(id)) {
				

				response = new ResponseEntity<Coche>(HttpStatus.OK);


				
			}
		} catch (Exception e) {
			//TODO 409 cuando no se pueda eliminar Coche porque tiene multas asociadas
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
		}

		return response;

	}
	
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
		
		
		
		//TODO terminar
		//201 creado y retornar coche con id actualizado
		//400 datos del coche no son correctos, por ejemplo sin matricula o vacia
		//409 ya existe la matricula UK 
	
		
	
	
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@PathVariable long id, @RequestBody Coche coche ) {
		
		//TODO terminar
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
		
	}
	
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable long id, @RequestBody Coche coche) {
		
		//TODO terminar
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
		
	}
	
	
}
