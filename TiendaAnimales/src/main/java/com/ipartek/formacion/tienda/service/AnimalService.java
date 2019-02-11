package com.ipartek.formacion.tienda.service;

import java.util.ArrayList;

import com.ipartek.formacion.tienda.modelo.pojo.Animal;

public interface AnimalService {
	
	/**
	 * Listado de animales ordenado por id descendente
	 * @return ArrayList<Animal>, vacio si no hay datos
	 */
	ArrayList<Animal> listar();

}
