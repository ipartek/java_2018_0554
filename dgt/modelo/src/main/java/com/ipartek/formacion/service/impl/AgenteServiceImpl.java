package com.ipartek.formacion.service.impl;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.Singleton;

public class AgenteServiceImpl implements AgenteService, Singleton{


		
		private static AgenteServiceImpl INSTANCE = null;

		private AgenteServiceImpl() {
			super();		
		}
		
		public synchronized static  AgenteServiceImpl getInstance() {
	        if (INSTANCE == null) {
	        	INSTANCE = new AgenteServiceImpl();
	        } 
	        return INSTANCE;
	    }
	
	private AgenteDAO agenteDAO;

	public Agente detalle(int placaAgente, String password) {
		// TODO Auto-generated method stub
		return agenteDAO.getAgente(placaAgente, password);
	}
	
	
//	public Agente existe(String numeroPlaca, String password) {
//		
//		
//		if
//	}
}
