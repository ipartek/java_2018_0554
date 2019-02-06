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

	
	//Instancia e implementa patron singleton, se denomina inyeccion de dependencias
	@Autowired
	PersonaService personaService;
	
	
	@RequestMapping(value = ("/api/persona"), method = RequestMethod.GET)
	public ArrayList<Persona> listar() {

		//llamar Service en vez de al dao.El service es el que llama al DAO
		return personaService.listar();
	}
	
	@RequestMapping(value = ("/api/persona/{id}/vehiculo"), method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Vehiculo>> listaVehiculos(@PathVariable int id) {
		
		ResponseEntity<ArrayList<Vehiculo>> response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.NOT_FOUND);
		try {
			
			//llamar Service en vez de al dao.El service es el que llama al DAO
			ArrayList<Vehiculo> vehiculos =  personaService.vehiculos(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		
		return response;
	}

}
