package com.ipartek.formacion.taller.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.service.PersonaService;
import com.ipartek.formacion.taller.service.exception.PersonaException;



@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaDAO personaDAO;
	
	@Autowired
	private Validator validator;

	@Override
	public ArrayList<Persona> listar() {

		ArrayList<Persona> personas = personaDAO.getAll();

		return personas;

	}

	@Override
	public Persona detalle(int idPersona) {
		Persona persona = personaDAO.getById(idPersona);
		return persona;
	}

	@Override
	public boolean eliminar(int idPersona) throws PersonaException {
		boolean eliminado = false;
		try {
			eliminado = personaDAO.delete(idPersona);
		} catch (Exception e) {
			throw new PersonaException(PersonaException.EXCEPTION_COSTRAINT);
		}
		return eliminado;

	}

	@Override
	public boolean crear(Persona persona) throws PersonaException {
		boolean creado = false;
		try {

			creado = personaDAO.insert(persona);

		} catch (SQLException e) {
			throw new PersonaException(PersonaException.EXCEPTION_EXISTS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return creado;
	}

	@Override
	public boolean modificar(Persona persona) throws PersonaException {
		boolean modificado = false;
		try {
			Set<ConstraintViolation<Persona>> violations = validator.validate(persona);
			if(violations.size()!=0) {
				throw new PersonaException("Tus datos son mierda pura");
			}
			modificado = personaDAO.update(persona);

		} catch (SQLException e) {
			throw new PersonaException(PersonaException.EXCEPTION_EXISTS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modificado;
	}



}
