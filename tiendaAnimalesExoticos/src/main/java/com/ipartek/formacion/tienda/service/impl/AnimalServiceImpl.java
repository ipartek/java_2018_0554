package com.ipartek.formacion.tienda.service.impl;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.tienda.modelo.dao.AnimalDao;
import com.ipartek.formacion.tienda.modelo.pojo.Animal;
import com.ipartek.formacion.tienda.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService{
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Animal> listar() {
		return animalDao.listar();
	}

	@Override
	public Animal detalle(int idAnimal) {
		return null;
	}
}
