package com.ipartek.formacion.animales.service;

import com.ipartek.formacion.modelo.pojo.Venta;

public interface VentaService {
	/**
	 * Registrar una venta en la bbdd
	 * @param venta
	 * @return <b>true</b> si se pudo crear <b>false</b> si no se pudo crear
	 */
	boolean crear(Venta venta);
}
