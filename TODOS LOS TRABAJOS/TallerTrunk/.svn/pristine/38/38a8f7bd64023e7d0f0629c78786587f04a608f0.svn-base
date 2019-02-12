package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.ModeloService;
import com.ipartek.formacion.taller.service.exception.ModeloException;

@RestController
@RequestMapping("/api/modelo/")
public class ModeloController {

	@Autowired		
	ModeloService modeloService;

	// LISTAR (GET BY ALL)
	@RequestMapping(value = "", method = RequestMethod.GET) // sin parametro , metodo get
	public ResponseEntity<ArrayList<Modelo>> listar() { // metodo listar

		ResponseEntity<ArrayList<Modelo>> response = new ResponseEntity<ArrayList<Modelo>>(HttpStatus.NOT_FOUND); // 404
																													// por
																													// defecto
																													// devuelve
																													// not_Found
		try {
			ArrayList<Modelo> modelos = (ArrayList<Modelo>) modeloService.listar(); // llamada al
																					// servicio
																					// listar para
																					// que llame al
																					// DAO

			if (!modelos.isEmpty()) { // si el array no esta vacio
				response = new ResponseEntity<ArrayList<Modelo>>(modelos, HttpStatus.OK); // envio array y
																							// codigo estado 200
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<ArrayList<Modelo>>(HttpStatus.INTERNAL_SERVER_ERROR); // si el array esta
																								// vacio, codigo
																								// 500
		}

		return response;
	}

	// LISTAR POR DETALLE POR ID (GETBYID)
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Modelo> detalle(@PathVariable int id) { // @PathVariable para enviar parametro

		ResponseEntity<Modelo> response = new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND); // por defecto
																							// devuelve
																							// not_Found

		try {
			Modelo modelo = (Modelo) modeloService.detalle(id); // lamada a servicio para que llame
																// al DAO
			if (modelo == null) {
				response = new ResponseEntity<Modelo>(modelo, HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<Modelo>(modelo, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// METODO ELIMINAR (DELETE)
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND); // POR DEFECTO

		try {

			if (modeloService.eliminar(id)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}
		} catch (ModeloException e) { // si falla la consulta

			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);

		} catch (Exception e) { // PORQUE HAY DOS CATCH PARA LO MISMO? PREGUNTA
			e.printStackTrace();
			response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// METODO CREAR (INSERT)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Mensaje> crear(@RequestBody Modelo modelo) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			if (modeloService.crear(modelo)) {
				response = new ResponseEntity(modelo, HttpStatus.CREATED); // he quitado <Mensaje> para poder meter
																			// Modelo
			} else {
				response = new ResponseEntity(HttpStatus.CONFLICT);
			}
		} catch (ModeloException e) {

			Mensaje mensaje = new Mensaje(e.getMessage());
			Set<ConstraintViolation<Modelo>> violations = e.getViolations();

			if (violations != null) {
				mensaje.addViolationsM(e.getViolations());
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

	// METODO MODIFICAR (UPDATE) // QUE LANZA SUS PROPIAS EXCEPCIONES
	// PERSONALIZADAS. CODIGO MAS FINO Y ELEGANTE
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity modificar(@PathVariable int id, // PIDO LA ID POR PARMETRO // LOS WARNINS SON POR QUITAR
															// MENSAJE (public ResponseEntity<Mensaje>)
			@RequestBody Modelo modelo) { // PIDO Modelo POR BODY // QUITO <Mensaje> PARA PODER INCLUIR
											// @PathVariable Y @RequestBody A LA VEZ

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);

		try {

			modelo.setId(id); // A COMUBUSTIBLE LE PONGO LA ID QUE RECIBO POR PARAMETRO CON @PachVariable in
								// id

			if (modeloService.modificar(modelo)) { // llamo al servicio para llamar al dao
				response = new ResponseEntity(modelo, HttpStatus.OK); // guardo en response el objeto con los datos
																		// y el codigo de estado 200
			}

		} catch (ModeloException e) {

			Mensaje mensaje = new Mensaje(e.getMessage()); // inizializo mensaje y le incluyo las esxepciones de
															// Modelo Exception
			Set<ConstraintViolation<Modelo>> violations = e.getViolations();

			if (violations != null) {
				mensaje.addViolationsM(violations);
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

}// FIN Modelo CONTROLLER