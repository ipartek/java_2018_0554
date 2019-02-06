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

import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;
import com.ipartek.formacion.taller.service.exception.RolException;

@RestController
@RequestMapping("/api/rol/")
public class RolController {

	@Autowired
	RolService rolService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Rol>> listar() {

		ResponseEntity<ArrayList<Rol>> response = new ResponseEntity<ArrayList<Rol>>(HttpStatus.NOT_FOUND);
		try {

			ArrayList<Rol> rol = (ArrayList<Rol>) rolService.listar();
			if (!rol.isEmpty()) {
				response = new ResponseEntity<ArrayList<Rol>>(rol, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<ArrayList<Rol>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// ROL por id

	@RequestMapping(value = { "{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Rol> detalle(@PathVariable int id) {

		ResponseEntity<Rol> response = new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);

		try {

			Rol rol = (Rol) rolService.detalle(id);
			if (rol == null) {
				response = new ResponseEntity<Rol>(rol, HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<Rol>(rol, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// ELIMINAR
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		try {

			if (rolService.eliminar(id)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
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

	// INSERTAR
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Rol> insert(@RequestBody Rol rol) {

		ResponseEntity<Rol> response = new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);// 500

		try {
			if (rolService.crear(rol)) {
				response = new ResponseEntity<Rol>(rol, HttpStatus.CREATED);//201
			}else {
				response = new ResponseEntity<Rol>(HttpStatus.CONFLICT); // 409
			}
		} catch (RolException e) {
			
			Mensaje mensaje = new Mensaje( e.getMessage() );
			Set<ConstraintViolation<Rol>> violations = e.getViolations();
			
			if ( violations != null ) {
				mensaje.addViolationsRol(violations);
				response = new ResponseEntity( mensaje, HttpStatus.BAD_REQUEST); //400
			}else {
				response = new ResponseEntity( mensaje, HttpStatus.CONFLICT);
			}	

		} catch (Exception e) {
			response = new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	// MODIFICAR
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity modificar(@PathVariable int id, @RequestBody Rol rol) {

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
try {
			
			rol.setId(id);		
			
			if ( rolService.modificar(rol)) {
				response = new ResponseEntity(rol, HttpStatus.OK);
			}
			
		} catch (RolException e) {		
			
			Mensaje mensaje = new Mensaje( e.getMessage() );
			Set<ConstraintViolation<Rol>> violations = e.getViolations();
			
			if ( violations != null ) {
				mensaje.addViolationsRol(violations);
				response = new ResponseEntity( mensaje, HttpStatus.BAD_REQUEST);
			}else {
				response = new ResponseEntity( mensaje, HttpStatus.CONFLICT);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
