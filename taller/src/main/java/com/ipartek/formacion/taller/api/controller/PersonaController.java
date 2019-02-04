package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.service.PersonaService;

@CrossOrigin
@RestController
public class PersonaController {
	
	/* instancia e implementa patron singleton - inyeccion de dependencias */	
	@Autowired
	PersonaService personaService;
	
	
	@RequestMapping( value= {"/api/persona"}, method = RequestMethod.GET)
	public ArrayList<Persona> listar(){		
		
		//llamamos al servicio, NO al DAO		
		return personaService.listar();
	}

}
