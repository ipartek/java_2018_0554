package com.ipartek.formacion.tienda.service;

import com.ipartek.formacion.tienda.modelo.pojo.Pedido;

public interface PedidoService {

	/**
	 * Metodo que inserta un pedido.
	 * @param pedido Objeto Pedido
	 * @return devuelve true si se ha realizado correctamente y false si ha fallado
	 */
	boolean insert(Pedido pedido);
}
