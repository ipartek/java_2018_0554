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
	 * Metodo que devuelve todos lo vehiculos que se encuentran en la base de datos
	 * @return Devuelve un arraylist de coches
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
	 * Obtiene un coche a traves del id del coche
	 * @param id enviado para buscar el coche en concreto.
	 * @return Devuelve un ResponseEntity, el cual devuelve el coche y el código de estado 404 o 200
	 * 200 -->	Lo ha encontrado satisfactoriamente
	 * 404 -->	El recuros no se ha encontrado
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
	 * Este método inserta un nuevo vehículo/coche.
	 * @param coche Es el coche que se va a intentar introducir en la base de datos
	 * @return Devuelve un código de estado:
	 * 201 --> se ha creado el coche correctamente.
	 * 404 --> El recurso no se ha encontrado.
	 * 409--> Hay un coche ya registrado con esa matricula por eso devuelve un conflicto
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
	 * Elimina un coche,permanentemente, de la base de datos
	 * @param id Se le manda el id del coche que se quiere eliminar
	 * @return Devuelve un estado.
	 * 200 --> se ha realizado la consulta correctamente
	 * 404 --> El recurso no se ha encontrado.
	 * 409--> Ese coche tiene alguna multa asociada, devuelve conflicto
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
	 * Este metodo sirve para actualizar todo el coche
	 * @param id Se le envia el id del coche.
	 * @param coche Se envia el coche modificado
	 * @return
	 * 200 -->se ha realizado la consulta correctamente
	 * 404 --> El recurso no se ha encontrado.
	 * 409--> Hay un coche ya registrado con esa matricula por eso devuelve un conflicto
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
	 * Este update es "parcial", ya que actualiza solamente un campo--> "fecha_baja", de esta manera
	 * se realiza un borrado lógico.
	 * @param id Se le envia el id del coche para identificarlo
	 * @return  Devuelve un código de estado:
	 * 200 -->se ha realizado la consulta correctamente
	 * 404 --> El recurso no se ha encontrado.
	 * 
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
