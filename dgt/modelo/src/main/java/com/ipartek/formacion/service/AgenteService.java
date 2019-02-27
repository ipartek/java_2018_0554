package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;

public interface AgenteService {
	

	/**
	 * 	comprueba que exista el Agente en la bbdd
	 * @param numeroPlaca
	 * @param password
	 * @return Agente si existe, null si no existe
	 */
	Agente existe( String numeroPlaca, String password);
	

	/**
	 * Multar un Vehiculo
	 * @param idCoche
	 * @param idAgente
	 * @param concepto
	 * @param importe
	 * @return
	 * @throws Exception si el concepto es null, el idAgente o idCoche no existen, importe < 0
	 */
	Multa multar( int idCoche, int idAgente, String concepto, float importe  ) throws Exception;
	
	
	/**
	 * Todas las multas de un Agente
	 * @param idAgente
	 * @return listado, si no hay ninguna vacio, no null
	 */
	List<Multa> obtenerMultas(int idAgente);
	

}
