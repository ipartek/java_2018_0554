package com.ipartek.formacion.tienda.service;

import java.util.List;

import com.ipartek.formacion.tienda.modelo.pojo.Animal;

public interface AnimalService {
	/**
	 * Listado Animales ordenado por id descente
	 * @return List<Animal>, Lista vacia si no hay datos
	 */
	List<Animal> listar();

	/**
	 * Obtener detalle Animal
	 * @param idAnimal int identificador del Animal
	 * @return si encuentra Animal, si no <b>null</b>
	 */
	Animal detalle(int idAnimal);


}
