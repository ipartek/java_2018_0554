package com.ipartek.appMultas.modelo.service;

import java.sql.Timestamp;
import java.util.List;

import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Coche;
import com.ipartek.appMultas.modelo.pojo.Multa;

public interface AgenteService {
	
	/**
	 * Comprueba que la placa y la contraseña recibidos por parámetros existen en la BD.
	 * @param placa Nº de placa del agente.
	 * @param password Contraseña del agente.
	 * @return El objeto agente registrado en la BD. Retorna un agente nulo si los datos introducidos no son correctos.
	 */
	Agente login(String placa, String password);
	
	/**
	 * 
	 * @param m Multa(Long id, Double importe, String concepto, Timestamp fecha, Coche coche)
	 * @param idAgente Identificador del Agente
	 * @return Multa 
	 * @throws Exception Si el concepto es null, el idAgente o el idCoche no existen,
	 * cuando importe < 0
	 */
	Multa multar(Multa m, Long idAgente) throws Exception;
	
	/**
	 * Todas las multas de un agente
	 * @param idAgente
	 * @return listado, si no hay ninguna vacio, no null
	 */
	List<Multa> obtenerMultas(Long idAgente);
	

}
