package com.ipartek.appMultas.modelo.service;

import com.ipartek.appMultas.modelo.pojo.Multa;

public interface MultaService {
	
	/**
	 * Método para obtener una multa de la DB por su ID
	 * @param idMulta
	 * @return Multa, Null si no existe
	 */
	Multa getById(int idMulta);
	
	/**
	 * Método para dar de baja una multa (marcar como anulada)
	 * @param idMulta 
	 */
	boolean darDeBaja(int idMulta);
	
	/**
	 * Método para dar de alta una multa de nuevo (marcar como desanulada)
	 * @param idMulta
	 */
	boolean darDeAlta(int idMulta);

}
