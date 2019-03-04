package com.ipartek.appMultas.modelo.service;

public interface MultaService {
	
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
