package com.ipartek.formacion.cervezas.api.controller;

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

import com.ipartek.formacion.cervezas.api.pojo.CompraPost;
import com.ipartek.formacion.cervezas.api.pojo.Mensaje;
import com.ipartek.formacion.cervezas.modelo.pojo.Cliente;
import com.ipartek.formacion.cervezas.modelo.pojo.Compra;
import com.ipartek.formacion.cervezas.modelo.pojo.Tipo;
import com.ipartek.formacion.cervezas.service.CompraService;
import com.ipartek.formacion.cervezas.service.exception.CompraException;

	@CrossOrigin
	@RestController
	@RequestMapping("/api/compra")
	public class CompraController {

		@Autowired
		CompraService compraService;
		
		
		
		
		

				// METODO ELIMINAR (DELETE)
				@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
				public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

					ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND); // POR DEFECTO

					try {

						if (compraService.eliminar(id)) {
							response = new ResponseEntity<Mensaje>(HttpStatus.OK);
						}
					} catch (CompraException e) { // si falla la consulta

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
		public ResponseEntity crear(@RequestBody CompraPost compraPost) {  // nuevo  POJO VEHICULOPOST EN API.POJO

			ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);  //inicializo respuesta con codigo 404 por defecto
			try {
		
				Compra c = new Compra();   // creo un vehiculo donde introduzco los datos que me llegan por parametros
				
				c.setCantidad (compraPost.getCantidad());
				c.setTipo(new Tipo(compraPost.getIdTipo(), ""));   // utilizo compraPost para pedir los parametros @RequestBody y modifico la id del objeto Tipo que hay en el constructor de Compra Pojo por la id del parametro. El parametro nombre lo dejo en blanco ""
				c.setCliente(new Cliente(compraPost.getIdCliente(), ""));
				

				
				if (compraService.crear(c)) {  							// SI EL SERVICIO DEVUELVE TRUE. (NO HACE FALTA PONER == true CUANDO ES TRUE
					
					response = new ResponseEntity(c, HttpStatus.CREATED);  	// CREO LA RESPUESTA. envio el vehiculo que he creado
				} else {
					response = new ResponseEntity(HttpStatus.CONFLICT);    	// si hay conflicto con los datos y por ejemplo estan repetidos 
				}

			} catch (CompraException e) {

				Mensaje mensaje = new Mensaje(e.getMessage());
				Set<ConstraintViolation<Compra>> violations = e.getViolations();

				if (violations != null) {
					mensaje.addViolationsCr(e.getViolations());
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

		
	}

	
	

