package com.ipartek.formacion.tienda.modelo.dao;

import com.ipartek.formacion.tienda.modelo.pojo.Cliente;

public interface ClienteDao {
	/**
	 * Metodo que obtiene un cliente de la tienda con todo detalle
	 * @param idCliente
	 * @return
	 */
	Cliente detalle(int idCliente);
}
