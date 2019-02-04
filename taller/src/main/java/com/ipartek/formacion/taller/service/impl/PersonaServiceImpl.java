package com.ipartek.formacion.taller.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	PersonaDAO personaDAO;

	@Override
	public ArrayList<Persona> listar() {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.addAll(personaDAO.getAll().values());

		return personas;
	}

	@Override
	public ArrayList<Object> vehiculos(int idPersona) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
