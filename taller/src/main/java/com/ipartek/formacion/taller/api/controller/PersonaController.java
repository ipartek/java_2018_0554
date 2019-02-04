package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	/*instancia e implementa patron singleton - inyeccion de dependencias*/
	
	@Autowired
	PersonaService personaService;
	

	// LISTAR
	@RequestMapping(value = { "/api/persona" }, method = RequestMethod.GET)
	public ArrayList<Persona> listar() {

		//llamamos al servicio, NO al DAO
		
		return personaService.listar();
	}

	// LISTAR VEHICULOS PROPIETARIO
		@RequestMapping(value = { "/api/persona/{id}/vehiculo" }, method = RequestMethod.GET)
		public ArrayList<Vehiculo> listarVehiculos(@PathVariable int id) {
			
			ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo> ();
			try {
				Vehiculo v = new Vehiculo();
				v.setId(2);
				v.setMatricula("BI-0000-ZA");
				vehiculos.add(v);
				
				v = new Vehiculo();
				v.setId(4);
				v.setMatricula("0000-CZA");
				vehiculos.add(v);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			return vehiculos;
		}
	
}
