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

import com.ipartek.formacion.taller.modelo.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;
import com.ipartek.formacion.taller.service.exception.RolException;

@RestController
@RequestMapping("/api/rol/")
public class RolController {

	@Autowired
	RolService rolService;

	// LISTAR (GET BY ALL)
	@RequestMapping(value = "", method = RequestMethod.GET) // sin parametro , metodo get
	public ResponseEntity<ArrayList<Rol>> listar() { // metodo listar

		ResponseEntity<ArrayList<Rol>> response = new ResponseEntity<ArrayList<Rol>>(HttpStatus.NOT_FOUND); // 404 por
																											// defecto
																											// devuelve
																											// not_Found
		try {
			ArrayList<Rol> roles = (ArrayList<Rol>) rolService.listar(); // llamada al servicio listar para que llame al
																			// DAO

			if (!roles.isEmpty()) { // si el array no esta vacio
				response = new ResponseEntity<ArrayList<Rol>>(roles, HttpStatus.OK); // envio array y codigo estado 200
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<ArrayList<Rol>>(HttpStatus.INTERNAL_SERVER_ERROR); // si el array esta vacio,
																								// codigo 500
		}

		return response;
	}

	// LISTAR POR DETALLE POR ID (GETBYID)
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Rol> detalle(@PathVariable int id) { // @PathVariable para enviar parametro

		ResponseEntity<Rol> response = new ResponseEntity<Rol>(HttpStatus.NOT_FOUND); // por defecto devuelve not_Found

		try {

			Rol rol = (Rol) rolService.detalle(id); // lamada a servicio para que llame al DAO

			if (rol == null) {
				response = new ResponseEntity<Rol>(rol, HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<Rol>(rol, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// METODO ELIMINAR (DELETE)
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND); // POR DEFECTO

		try {

			if (rolService.eliminar(id)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}
		} catch (RolException e) { // si falla la consulta

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
	public ResponseEntity<Mensaje> crear(@RequestBody Rol rol) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);

		try {

			if (rolService.crear(rol)) {
				response = new ResponseEntity(rol, HttpStatus.OK); // he quitado <Mensaje> para poder meter rol
			}
		} catch (RolException e) {

			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Mensaje>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// METODO MODIFICAR (UPDATE)
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity modificar(@PathVariable int id, // LOS WARNINS SON POR QUITAR MENSAJE (public
															// ResponseEntity<Mensaje>)
			@RequestBody Rol rol) { // QUITO <Mensaje> PARA PODER INCLUIR @PathVariable Y @RequestBody A LA VEZ

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);

		try {

			rol.setId(id);

			if (rolService.modificar(rol)) {
				response = new ResponseEntity(rol, HttpStatus.OK);
			} else {
				Mensaje mensaje = new Mensaje("Validacion Incorrecta");
				response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
			}

		} catch (RolException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}// fin