package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;


public interface AgenteService {
	

	/**
	 * 	comprueba que exista el Agente en la bbdd
	 * @param numeroPlaca
	 * @param password
	 * @return Agente si existe, null si no existe
	 */
Agente existe( int numeroPlaca, String password);

boolean multar(Multa multa, long idCoche ) throws Exception;


/**
 * Todas las multas de un Agente
 * @param idAgente
 * @return listado, si no hay ninguna vacio, no null
 */
ArrayList<Multa> obtenerMultas(long idAgente);

boolean darBaja(int idMulta);
boolean darAlta(int idMulta);

}