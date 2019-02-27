package com.ipartek.appMultas.modelo.service;

import com.ipartek.appMultas.modelo.pojo.Agente;

public interface AgenteService {
	
	/**
	 * Comprueba que la placa y la contraseña recibidos por parámetros existen en la BD.
	 * @param placa Nº de placa del agente.
	 * @param password Contraseña del agente.
	 * @return El objeto agente registrado en la BD. Retorna un agente nulo si los datos introducidos no son correctos.
	 */
	Agente login(String placa, String password);
	

}
