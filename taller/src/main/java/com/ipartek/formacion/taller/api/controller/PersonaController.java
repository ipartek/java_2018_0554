package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Persona;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "PERSONA" }, produces = "application/json", description = "Gestión de taller")
public class PersonaController {

	@ApiResponses({
		@ApiResponse(code = 201 , message = "Persona creada"),
		@ApiResponse(code = 400 , message = "Datos No Validos")
	})
	@RequestMapping(value = { "/api/persona" }, method = RequestMethod.GET)
	public ArrayList<Persona> listar() {

		// TODO crear DAO
		ArrayList<Persona> personas = new ArrayList<Persona>();

		Persona p = new Persona();
		p.setNombre("manolo");
		personas.add(p);

		new Persona();
		p.setNombre("jose mari");
		personas.add(p);

		return personas;
	}

}
