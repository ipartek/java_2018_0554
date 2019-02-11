package com.ipartek.formacion.tienda.modelo.dao;

import java.sql.SQLException;

import com.ipartek.formacion.tienda.modelo.pojo.Pedido;

public interface PedidoDao {

	/**
	 * Metodo que inserta un pedido.
	 * @param pedido Objeto Pedido
	 * @return devuelve true si se ha realizado correctamente y false si ha fallado
	 * @throws SQLException 
	 */
	boolean insert(Pedido pedido) throws SQLException;
	
}
