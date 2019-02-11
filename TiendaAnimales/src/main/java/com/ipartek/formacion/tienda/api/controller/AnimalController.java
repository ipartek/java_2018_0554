package com.ipartek.formacion.tienda.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.tienda.modelo.pojo.Animal;
import com.ipartek.formacion.tienda.service.AnimalService;

@CrossOrigin
@RestController
@RequestMapping("api/animal")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	/**
	 * Método para listar todos los tipos de animales existentes en la Base de Datos
	 * @return ArrayList<Animal>
	 * @return 200 <b>Si se devuelve un array con animales</b>
	 * @return 404 Si <b>no existen animales en la Base de Datos</b> (P.E: Si la BD está vacia)
	 * @return 500 Si ocurre un <b>error inesperado</b> (P.E: Si se introducen mal los datos)
	 */
	public ResponseEntity<ArrayList<Animal>> listar() {
		ResponseEntity<ArrayList<Animal>> response = new ResponseEntity<ArrayList<Animal>>(
				HttpStatus.NOT_FOUND);
		try {
			ArrayList<Animal> animales = animalService.listar();
			if (!animales.isEmpty()) {
				response = new ResponseEntity<ArrayList<Animal>>(animales, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<ArrayList<Animal>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
