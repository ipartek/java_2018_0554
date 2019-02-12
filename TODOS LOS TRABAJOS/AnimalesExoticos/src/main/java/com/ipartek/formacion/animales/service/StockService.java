package com.ipartek.formacion.animales.service;

import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.modelo.pojo.Animal;


public interface StockService {
	
	/**
	 * Listado Catalogo Animales
	 * @return List<Animal>, Lista vacia si no hay datos
	 */
	List<Animal> catalogo();
	
	/**
	 * Realizamos la venta de un Animal a un Usuario, 
	 * y al ser online buscara el primero que encuentre en Stock
	 * @param idAnimal int identificador Animal
	 * @param idUsuario int identificador Usuario
	 * @return true si realizamos venta, false si no hay stock
	 * @throws SQLException si idAnimal o idUsuario no existen
	 */
	boolean comprar( int idAnimal , int idUsuario ) throws SQLException;
	


}
