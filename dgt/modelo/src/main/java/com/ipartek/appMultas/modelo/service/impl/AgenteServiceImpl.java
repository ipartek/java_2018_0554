package com.ipartek.appMultas.modelo.service.impl;

import java.util.ArrayList;

import com.ipartek.appMultas.modelo.dao.AgenteDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Objetivo;
import com.ipartek.appMultas.modelo.service.AgenteService;


public class AgenteServiceImpl implements AgenteService{
	
	private AgenteDAO agenteDAO;
	private static AgenteServiceImpl INSTANCE = null;
	
	private AgenteServiceImpl() {
		super();
		agenteDAO = AgenteDAO.getInstance();
	}
	
	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static AgenteServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgenteServiceImpl();
		}
		return INSTANCE;
	}

	@Override
	public Agente login(String placa, String password) {
		//TODO Obtener: 
		//- Multas
		//- Objetivo Anual
		//- Objetivo Mensual
		//- Objetivo Meses ( ArrayList<Objetivo> )
		return agenteDAO.login(placa, password);
	}

}
