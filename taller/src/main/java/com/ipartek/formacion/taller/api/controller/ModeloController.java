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

import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.ModeloService;
import com.ipartek.formacion.taller.service.exception.ModeloException;


@RestController
@RequestMapping("/api/modelo/")
public class ModeloController {
	
	@Autowired
	ModeloService modeloService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Modelo>> listar() {

		ResponseEntity<ArrayList<Modelo>> response = new ResponseEntity<ArrayList<Modelo>>(HttpStatus.NOT_FOUND);
		try {

			ArrayList<Modelo> modelo = (ArrayList<Modelo>) modeloService.listar();
			if (!modelo.isEmpty()) {
				response = new ResponseEntity<ArrayList<Modelo>>(modelo, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace(); // TODO meter en LOG
			response = new ResponseEntity<ArrayList<Modelo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// ROL por id

	@RequestMapping(value = { "{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Modelo> detalle(@PathVariable int id) {

		ResponseEntity<Modelo> response = new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);

		try {

			Modelo modelo = (Modelo) modeloService.detalle(id);
			if (modelo == null) {
				response = new ResponseEntity<Modelo>(modelo, HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<Modelo>(modelo, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// ELIMINAR
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {

		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		try {

			if (modeloService.eliminar(id)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}
		} catch (ModeloException e) {

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
	public ResponseEntity<Modelo> insert(@RequestBody Modelo modelo) {

		ResponseEntity<Modelo> response = new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);// 404

		try {
			if (modeloService.crear(modelo)) {
				response = new ResponseEntity<Modelo>(modelo, HttpStatus.CREATED);// 201
			}
		} catch (ModeloException e) {

			response = new ResponseEntity<Modelo>(HttpStatus.CONFLICT); // 409

		} catch (Exception e) {
			response = new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	// MODIFICAR
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity modificar(@PathVariable int id, @RequestBody Modelo modelo) {

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		try {

			modelo.setId(id);

			if (modeloService.modificar(modelo)) {
				response = new ResponseEntity(modelo, HttpStatus.OK);
			} else {
				Mensaje mensaje = new Mensaje("Validacion Incorrecta");
				response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
			}

		} catch (ModeloException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity(mensaje, HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
