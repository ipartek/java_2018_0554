package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.PersonaService;

@CrossOrigin
@RestController
public class PersonaController {

	/* instancia e implementa patron singleton - inyeccion de dependencias */
	@Autowired
	PersonaService personaService;

	// PEDIMOS LAS PERSONAS

	@RequestMapping(value = { "/api/persona" }, method = RequestMethod.GET)
	public ArrayList<Persona> listar() {

		// llamamos al servicio, NO al DAO
		return personaService.listar();
	}

	// PEDIMOS LOS VEHICULOS DE ESAS PERSONAS (AQUI, NO EN VehiculoController)

	@RequestMapping(value = { "/api/persona/{id}/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Vehiculo> listarVehiculos(@PathVariable int id) {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		ResponseEntity<ArrayList<Vehiculo>> response;
		try {
			Vehiculo v = new Vehiculo();
			v.setId(2);
			v.setMatricula("BI-000-JM");
			vehiculos.add(v);

			v.setId(3);
			v.setMatricula("45-0123-KM");
			vehiculos.add(v);

			response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return vehiculos;

	}

//	@RequestMapping(value = { "/api/persona/{id}/vehiculo" }, method = RequestMethod.POST)

}