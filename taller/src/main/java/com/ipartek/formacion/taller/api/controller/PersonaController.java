package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Persona;

@CrossOrigin
@RestController
public class PersonaController {
	
	
	@RequestMapping( value= {"/api/persona"}, method = RequestMethod.GET)
	public ArrayList<Persona> listar(){		
		
		//TODO crear DAO
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		Persona p = new Persona();
		p.setNombre("Manolo");
		personas.add(p);
		
		p = new Persona();
		p.setNombre("Jose MAri");
		personas.add(p);		
		
		return personas;
	}

}
