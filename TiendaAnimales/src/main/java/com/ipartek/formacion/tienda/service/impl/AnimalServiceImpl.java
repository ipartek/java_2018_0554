package com.ipartek.formacion.tienda.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.tienda.modelo.dao.AnimalDAO;
import com.ipartek.formacion.tienda.modelo.pojo.Animal;
import com.ipartek.formacion.tienda.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	AnimalDAO animalDAO;

	@Override
	public ArrayList<Animal> listar() {

		ArrayList<Animal> personas = animalDAO.getAll();

		return personas;

	}

}
