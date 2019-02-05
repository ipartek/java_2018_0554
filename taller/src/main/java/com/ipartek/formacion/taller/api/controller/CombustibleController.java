package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Mensaje;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;


@RestController
@RequestMapping("/api/combustible/")
public class CombustibleController {

	@Autowired
	CombustibleService combustibleService;

	
	
	// LISTAR  (GET BY ALL)
	@RequestMapping(value = "", method = RequestMethod.GET)  											// sin parametro , metodo get
	public ResponseEntity<ArrayList<Combustible>> listar() { 											// metodo listar

		ResponseEntity<ArrayList<Combustible>> response = 
				new ResponseEntity<ArrayList<Combustible>>(	HttpStatus.NOT_FOUND);  					// 404 por defecto devuelve not_Found
		try {
			ArrayList<Combustible> combustibles = (ArrayList<Combustible>) combustibleService.listar(); // llamada al servicio listar para que llame al DAO
			
			if (!combustibles.isEmpty()) {																// si el array no esta vacio
				response = new ResponseEntity<ArrayList<Combustible>>(combustibles, HttpStatus.OK);		// envio array y codigo estado 200
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.INTERNAL_SERVER_ERROR);    // si el array esta vacio, codigo 500
		}

		return response;  
	}

	
	// LISTAR POR DETALLE POR ID (GETBYID)
		@RequestMapping(value = "{id}", method = RequestMethod.GET)
		public ResponseEntity<Combustible> detalle(@PathVariable int id ) {  							  // @PathVariable para enviar parametro

			ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND); // por defecto devuelve not_Found
			
			try {
				Combustible combustible = (Combustible) combustibleService.detalle(id);					  // lamada a servicio para que llame al DAO
				if (combustible== null) {
					response = new ResponseEntity<Combustible>(combustible, HttpStatus.NOT_FOUND);
				}else {
					response = new ResponseEntity<Combustible>(combustible, HttpStatus.OK);
				}

			} catch (Exception e) {
				e.printStackTrace(); // TODO meter en LOG
				response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}
	
	// METODO ELIMINAR (DELETE)
		@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Mensaje> eliminar( @PathVariable int id) {

			ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);   // POR DEFECTO
			
			try {

				if ( combustibleService.eliminar(id) ) {
					response = new ResponseEntity<Mensaje>(HttpStatus.OK);
				}
			} catch (CombustibleException e) {	                                             // si falla la consulta
				
				Mensaje mensaje = new Mensaje( e.getMessage() );
				response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);
				
			} catch (Exception e) {															// 	PORQUE HAY DOS CATCH PARA LO MISMO? PREGUNTA
				e.printStackTrace();
				response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}

		
	// METODO CREAR (INSERT)
		@RequestMapping(value = "", method = RequestMethod.POST)
		public ResponseEntity<Mensaje> crear( @RequestBody Combustible combustible) {

			ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
			
	
			try {

				if ( combustibleService.crear(combustible) ) {
					response = new ResponseEntity(combustible,HttpStatus.OK);   			// he quitado <Mensaje> para poder meter combustible
				}
			} catch (CombustibleException e) {	
				
				Mensaje mensaje = new Mensaje( e.getMessage() );
				response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);
				
			} catch (Exception e) {
				e.printStackTrace();
				response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return response;
		}

		// METODO MODIFICAR (UPDATE)
		@RequestMapping(value = "{id}", method = RequestMethod.PUT)
		public ResponseEntity modificar( @PathVariable int id ,                                   // LOS WARNINS SON POR QUITAR MENSAJE     (public ResponseEntity<Mensaje>)
				                         @RequestBody Combustible combustible) {    			// QUITO  <Mensaje> PARA PODER INCLUIR @PathVariable Y  @RequestBody  A LA VEZ
			
			ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
			
			try {
				
				combustible.setId(id);		
				
				if ( combustibleService.modificar(combustible)) {
					response = new ResponseEntity(combustible, HttpStatus.OK);
				}else {
					Mensaje mensaje = new Mensaje( "Validacion Incorrecta" );
					response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
				}
				
			} catch (CombustibleException e) {				
				Mensaje mensaje = new Mensaje( e.getMessage() );
				response = new ResponseEntity( mensaje, HttpStatus.CONFLICT);
			} catch (Exception e) {
				e.printStackTrace();
				response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return response;
		}
		
	
	
}// FIN COMBUSTIBLE CONTROLLER