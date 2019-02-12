package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.animales.modelo.pojo.Animal;
import com.ipartek.formacion.animales.service.exception.AnimalException;

public interface AnimalService {

	// LISTAR - GET BY ALL
	/**
	 * Listado Animal ordenado por id descente
	 * 
	 * @return List<Animal>, Lista vacia si no hay datos
	 */
	List<Animal> listar(); // NO INCLUYE PARAMETRO

	// DETALLE - GET BY ID
	/**
	 * Obtener detalle Animal
	 * 
	 * @param idAnimal int identificador del Animal
	 * @return si encuentra Animal, si no <b>null</b>
	 */
	Animal detalle(int idAnimal); // PARAMETRO ID

	// no utilizo eliminar
	boolean eliminar(int idAnimal) throws AnimalException; // PARAMETRO ID

	// CREAR - INSERT
	/**
	 * Creamos una nueva Animal, al crear con exito actualiza el <b>id</b>
	 * 
	 * @param AnimalException Animal a crear
	 * @return true si lo crea, false si no puede crear, 
	 *		<b>idDieta</b>debe esistir en la base de datos
	 * 		<b>idTipo</b> debe esistir en la base de datos
	 * 		<b>listoVenta</b> boolean not null. 
	 * 		<b>nombre</b> minimo 1 letra y maximo 45
	 * 		<b>peso</b> float. not null
	 * 		<b>precio</b> float .not null
	 * 
	 * @throws AnimalException si el nombre de la Animal existe
	 * @see AnimalException.EXCEPTION_EXIST
	 */
	boolean crear(Animal animal) throws AnimalException; // PARAMETRO OBJETO

	// MODIFICAR - UPDATE
	/**
	 * Modifica el <b>nombre</b> de un Animal identificado por su <b>id</b>
	 * 
	 * @param AnimalException Animal a modificar
	 * @return true si no modifica, false si no la encuentra o <b>nombre</b> minimo
	 * 		<b>idDieta</b>debe esistir en la base de datos
	 * 		<b>idTipo</b> debe esistir en la base de datos
	 * 		<b>listoVenta</b> boolean not null. 
	 * 		<b>nombre</b> minimo 1 letra y maximo 45
	 * 		<b>peso</b> float. not null
	 * 		<b>precio</b> float .not null
	 * @throws AnimalException el nombre ya existe
	 * @see AnimalException.EXCEPTION_EXIST
	 */
	boolean modificar(Animal animal) throws AnimalException; // PARAMETRO OBJETO

}