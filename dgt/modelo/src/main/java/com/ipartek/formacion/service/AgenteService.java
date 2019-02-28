package com.ipartek.formacion.service;

import com.ipartek.formacion.modelo.pojo.Agente;

public interface AgenteService {

	/**
	 * Obtener detalle Agente
	 * @param placaAgente int identificador del Agente
	 * @return si encuentra Agente, si no <b>null</b>
	 */
	

	Agente detalle(int placaAgente, String password);
	
}
