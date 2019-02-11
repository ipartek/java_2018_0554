package com.ipartek.formacion.tienda.modelo.dao;

import java.util.List;

import com.ipartek.formacion.tienda.modelo.pojo.Animal;

public interface AnimalDao {
	
	/**
	 * Metodo que obtiene un listado de todos los animales de la tienda.
	 * 	Cada animal tiene su tipo de alimentacion y tipo de alimentacion.
	 * @return
	 */
	List<Animal> listar();
	
	/**
	 * Metodo que obtiene un animal de la tienda con todo detalle
	 * @param idAnimal
	 * @return
	 */
	Animal detalle(int idAnimal);
}
