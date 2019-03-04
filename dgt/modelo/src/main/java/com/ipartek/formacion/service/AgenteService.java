package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.modelo.pojo.MultaCreada;

public interface AgenteService {

	/**
	 * comprueba que exista el Agente en la bbdd
	 * 
	 * @param numeroPlaca
	 * @param password
	 * @return Agente si existe, null si no existe
	 */
	Agente existe(String numeroPlaca, String password);

	/**
	 * Multar un Vehiculo
	 * 
	 * @param idCoche
	 * @param idAgente
	 * @param concepto
	 * @param importe
	 * @return
	 * @throws Exception si el concepto es null, el idAgente o idCoche no existen,
	 *                   importe < 0
	 */
	boolean multar(MultaCreada multa);

	/**
	 * Todas las multas de un Agente
	 * 
	 * @param idAgente
	 * @return listado, si no hay ninguna vacio, no null
	 */
	List<Multa> listarMultas(int id);

	/**
	 * Todas las multas de un Agente
	 * 
	 * @param idAgente
	 * @return listado, si no hay ninguna vacio, no null
	 */
	List<Multa> listarMultasAnuladas(int id);

	/**
	 * Busca un coche por su matricula
	 * 
	 * @param matricula
	 * @return datos vehiculo, si no hay matricula vacio, null
	 */
	Coche buscarMatricula(String matricula);
	
	/**
	 * conseguir la id de un vehiculo por su matricula
	 * 
	 * @param matricula
	 * @return id vehiculo, si no hay matricula vacio, null
	 */
	Coche conseguirId(String matricula);

}