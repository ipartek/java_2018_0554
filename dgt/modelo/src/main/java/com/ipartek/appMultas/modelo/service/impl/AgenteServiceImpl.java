package com.ipartek.appMultas.modelo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.appMultas.modelo.dao.AgenteDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;
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

	@Override
	public Multa multar(Multa m, Long idAgente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Multa> obtenerMultas(Long idAgente) {
		// TODO Auto-generated method stub
		return null;
	}

}
