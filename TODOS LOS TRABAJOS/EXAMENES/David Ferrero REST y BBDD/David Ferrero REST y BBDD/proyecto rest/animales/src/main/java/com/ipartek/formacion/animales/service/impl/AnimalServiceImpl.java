package com.ipartek.formacion.animales.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.modelo.dao.AnimalDAO;
import com.ipartek.formacion.animales.modelo.dao.DietaDAO;
import com.ipartek.formacion.animales.modelo.dao.TipoDAO;
import com.ipartek.formacion.animales.modelo.pojo.Animal;
import com.ipartek.formacion.animales.service.AnimalService;
import com.ipartek.formacion.animales.service.exception.AnimalException;

@Service
public class AnimalServiceImpl implements AnimalService {
	@Autowired
	AnimalDAO animalDAO;

	@Autowired
	TipoDAO tipoDAO;

	@Autowired
	DietaDAO dietaDAO;

	@Autowired
	private Validator validator;

	@Override
	public List<Animal> listar() {

		ArrayList<Animal> animales = new ArrayList<Animal>();
		animales = (ArrayList<Animal>) animalDAO.getAll();

		for (Animal a : animales) {
			a.setTipo(tipoDAO.getByIdTipoAnimal(a.getId()));
			a.setDieta(dietaDAO.getByIdDietaAnimal(a.getId()));
		}

		return animales;
	}

	// LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Animal detalle(int id) {
		Animal animal = animalDAO.getById(id);
		animal.setTipo(tipoDAO.getByIdTipoAnimal(animal.getId()));
		animal.setDieta(dietaDAO.getByIdDietaAnimal(animal.getId()));
		return animal;
	}

	@Override
	public boolean crear(Animal animal) throws AnimalException {
		boolean isCreado = false;
		try {

			Set<ConstraintViolation<Animal>> violations = validator.validate(animal);
			if (violations.isEmpty()) {
				isCreado = animalDAO.insert(animal);

				animal.setTipo(tipoDAO.getByIdTipoAnimal(animal.getId()));
				animal.setDieta(dietaDAO.getByIdDietaAnimal(animal.getId()));

			} else {
				throw new AnimalException(AnimalException.EXCEPTION_VIOLATIONS, violations);
			}

		} catch (SQLException e) {
			throw new AnimalException(AnimalException.EXCEPTION_CONSTRAINT);
		}
		return isCreado;
	}

	@Override
	public boolean modificar(Animal animal) throws AnimalException {
		boolean isModificado = false;
		try {

			Set<ConstraintViolation<Animal>> violations = validator.validate(animal);
			if (violations.isEmpty()) {
				isModificado = animalDAO.update(animal);
				animal.setTipo(tipoDAO.getByIdTipoAnimal(animal.getId()));
				animal.setDieta(dietaDAO.getByIdDietaAnimal(animal.getId()));
			} else {
				throw new AnimalException(AnimalException.EXCEPTION_VIOLATIONS, violations);
			}

		} catch (SQLException e) {
			throw new AnimalException(AnimalException.EXCEPTION_CONSTRAINT);
		}
		return isModificado;
	}

	@Override
	public boolean eliminar(int idAnimal) throws AnimalException {
		// TODO Auto-generated method stub
		return false;
	}
}
