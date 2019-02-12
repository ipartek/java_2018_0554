package com.ipartek.formacion.animales.api.controller;

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

import com.ipartek.formacion.animales.api.pojo.AnimalPost;
import com.ipartek.formacion.animales.api.pojo.Mensaje;
import com.ipartek.formacion.animales.modelo.pojo.Animal;
import com.ipartek.formacion.animales.modelo.pojo.Dieta;
import com.ipartek.formacion.animales.modelo.pojo.Tipo;
import com.ipartek.formacion.animales.service.AnimalService;
import com.ipartek.formacion.animales.service.exception.AnimalException;

@CrossOrigin
@RestController
@RequestMapping("/api/animal")
public class AnimalController {

	@Autowired
	AnimalService animalService;

	// listar
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Animal>> listar() {

		ResponseEntity<ArrayList<Animal>> response = new ResponseEntity<ArrayList<Animal>>(HttpStatus.NOT_FOUND);
		try {
			ArrayList<Animal> animales = (ArrayList<Animal>) animalService.listar();
			if (!animales.isEmpty()) {
				response = new ResponseEntity<ArrayList<Animal>>(animales, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<ArrayList<Animal>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// detalle
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Animal> detalle(@PathVariable int id) {

		ResponseEntity<Animal> response = new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		try {
			Animal animal = (Animal) animalService.detalle(id);
			if (animal != null) {

				response = new ResponseEntity<Animal>(animal, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace(); // Meter LOG
			response = new ResponseEntity<Animal>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// crear
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity crear(@RequestBody AnimalPost animalPost) {

		ResponseEntity response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Animal a = new Animal();

			a.setNombre(animalPost.getNombre());
			a.setPeso(animalPost.getPeso());
			a.setPrecio(animalPost.getPrecio());
			a.setListoVenta(animalPost.isListoVenta());
			a.setTipo(new Tipo(animalPost.getIdTipo(), ""));
			a.setDieta(new Dieta(animalPost.getIdDieta(), ""));

			if (animalService.crear(a)) {

				response = new ResponseEntity(a, HttpStatus.CREATED);

			} else {
				response = new ResponseEntity(HttpStatus.CONFLICT);

			}

		} catch (AnimalException e) {

			Mensaje mensaje = new Mensaje(e.getMessage());
			Set<ConstraintViolation<Animal>> violations = e.getViolations();

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
	public ResponseEntity modificar(@PathVariable int id, @RequestBody AnimalPost animalPost) {

		ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
		try {

			Animal a = new Animal();
			a.setId(id);
			a.setNombre(animalPost.getNombre());
			a.setPeso(animalPost.getPeso());
			a.setPrecio(animalPost.getPrecio());
			a.setListoVenta(animalPost.isListoVenta());
			a.setTipo(new Tipo(animalPost.getIdTipo(), ""));
			a.setDieta(new Dieta(animalPost.getIdDieta(), ""));

			if (animalService.modificar(a)) {
				response = new ResponseEntity(a, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
