package com.ipartek.formacion.cervezas.api.controller;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.cervezas.api.pojo.CervezaPost;
import com.ipartek.formacion.cervezas.api.pojo.Mensaje;
import com.ipartek.formacion.cervezas.modelo.pojo.Cerveza;
import com.ipartek.formacion.cervezas.modelo.pojo.Tipo;
import com.ipartek.formacion.cervezas.service.CervezaService;
import com.ipartek.formacion.cervezas.service.exception.CervezaException;

	@CrossOrigin
	@RestController
	@RequestMapping("/api/cerveza")
	public class CervezaController {

		@Autowired
		CervezaService cervezaService;
		
	

		
		//listar
		@RequestMapping(value = "", method = RequestMethod.GET)
		public ResponseEntity<ArrayList<Cerveza>> listar() {

			ResponseEntity<ArrayList<Cerveza>> response = new ResponseEntity<ArrayList<Cerveza>>(HttpStatus.NOT_FOUND); //RESPUESTA DE TIPO ARRAY LIST DE OBJETOS DE TIPO Cerveza CON CODIGO DE ESTADO POR DEFECTO 404
			try {
				ArrayList<Cerveza> cervezas = (ArrayList<Cerveza>) cervezaService.listar(); 			// llenar el array list de Cervezas con LOS DATOS QUE obtiene el DAO. Al dao se le llama a traves del service
				if (!cervezas.isEmpty()) {   																// si el array que devuelve el SERVICIO esta lleno. (distinto a empty . OJO AL ! PARA DISTINTO)
					response = new ResponseEntity<ArrayList<Cerveza>>(cervezas, HttpStatus.OK);			// CREO LA RESPUESTA con los Cervezas y el codigo de estado 200
				}
			} catch (Exception e) {
				e.printStackTrace();
				response = new ResponseEntity<ArrayList<Cerveza>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}

		
		// detalle
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Cerveza> detalle(@PathVariable int id) {

	 		ResponseEntity<Cerveza> response = new ResponseEntity<Cerveza>(HttpStatus.NOT_FOUND);
			try {
				Cerveza cerveza = (Cerveza) cervezaService.detalle(id);
				if (cerveza != null) {
					
					response = new ResponseEntity<Cerveza>(cerveza, HttpStatus.OK);
				}
			} catch (Exception e) {
				e.printStackTrace(); // Meter LOG
				response = new ResponseEntity<Cerveza>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}

		// METODO ELIMINAR (DELETE)
		@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

			ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND); // POR DEFECTO

			try {

				if (cervezaService.eliminar(id)) {
					response = new ResponseEntity<Mensaje>(HttpStatus.OK);
				}
			} catch (CervezaException e) { // si falla la consulta

				Mensaje mensaje = new Mensaje(e.getMessage());
				response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);

			} catch (Exception e) { 
				e.printStackTrace();
				response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}
		
		
		// crear
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public ResponseEntity crear(@RequestBody CervezaPost cervezaPost) {  // nuevo  POJO VEHICULOPOST EN API.POJO

			ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);  //inicializo respuesta con codigo 404 por defecto
			try {
		
				Cerveza c = new Cerveza();   // creo un vehiculo donde introduzco los datos que me llegan por parametros
				
				c.setNombre (cervezaPost.getNombre());
				c.setTipo(new Tipo(cervezaPost.getIdTipo(), ""));   // utilizo cervezaPost para pedir los parametros @RequestBody y modifico la id del objeto Tipo que hay en el constructor de Cerveza Pojo por la id del parametro. El parametro nombre lo dejo en blanco ""
				c.setPrecio (cervezaPost.getPrecio());
				

				
				if (cervezaService.crear(c)) {  							// SI EL SERVICIO DEVUELVE TRUE. (NO HACE FALTA PONER == true CUANDO ES TRUE
					
					response = new ResponseEntity(c, HttpStatus.CREATED);  	// CREO LA RESPUESTA. envio el vehiculo que he creado
				} else {
					response = new ResponseEntity(HttpStatus.CONFLICT);    	// si hay conflicto con los datos y por ejemplo estan repetidos 
				}

			} catch (CervezaException e) {

				Mensaje mensaje = new Mensaje(e.getMessage());
				Set<ConstraintViolation<Cerveza>> violations = e.getViolations();

				if (violations != null) {
					mensaje.addViolationsC(e.getViolations());
					response = new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
				} else {
					response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
				}

			} catch (Exception e) {
				e.printStackTrace();
				response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return response;

		}

		
		// modificar
		@RequestMapping(value = "{id}", method = RequestMethod.PUT)
		public ResponseEntity modificar(@PathVariable int id, @RequestBody CervezaPost cervezaPost) {

			ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
			try {

				
				Cerveza c = new Cerveza();   // creo un vehiculo donde introduzco los datos que me llegan por parametros
				c.setId(id);
				c.setNombre (cervezaPost.getNombre());
				c.setTipo(new Tipo(cervezaPost.getIdTipo(), ""));
				c.setPrecio (cervezaPost.getPrecio());
				

				if (cervezaService.modificar(c)) {
					response = new ResponseEntity(c, HttpStatus.OK);
				}

			} catch (Exception e) {
				e.printStackTrace();
				response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return response;
		}

	}

	
	

