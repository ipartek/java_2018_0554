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

	// METODO PARA LISTAR PERSONAS
	@RequestMapping(value = { "/api/persona" }, method = RequestMethod.GET)
	public ArrayList<Persona> listar() {

		// llamamos al servicio, NO al DAO
		return personaService.listar();
	}

	// METODO PARSA LISTAR VEHICULOS POR IDPERSONA
	@RequestMapping(value = { "/api/persona/{id}/vehiculo" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Vehiculo>> listarVehiculos(@PathVariable int id) {

		ResponseEntity<ArrayList<Vehiculo>> response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.NOT_FOUND);

		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>(); // arrylist para meter los vehiculos
		try {

			Vehiculo v = new Vehiculo(); // vehiculo 1
			v.setId(2);
			v.setMatricula("BI-000-JM");
			vehiculos.add(v);

			v = new Vehiculo(); // vehiculo 2
			v.setId(45);
			v.setMatricula("45-0123-KM");
			vehiculos.add(v);

			response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.OK); // envio respuesta
																							// DONDE???????? PREGUNTA

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
