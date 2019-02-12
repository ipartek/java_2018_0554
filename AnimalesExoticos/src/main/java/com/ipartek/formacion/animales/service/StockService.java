package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.modelo.pojo.Stock;

public interface StockService {
	/**
	 * Listado Stock ordenado por id descendente
	 * @return List<Stock>, Lista vacia si no hay datos
	 */
	List<Stock> listar();
}
