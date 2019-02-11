package com.ipartek.formacion.tienda.modelo.dao;

import com.ipartek.formacion.tienda.modelo.pojo.Stock;

public interface StockDao {

	/**
	 * Metodo que obtiene un Stock(animal seleccionado) de la tienda con todo detalle
	 * @param idStock
	 * @return
	 */
	Stock detalle(int idStock);
}
