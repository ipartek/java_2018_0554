package com.ipartek.appMultas.modelo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.dao.AgenteDAO;
import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;
import com.ipartek.appMultas.modelo.service.AgenteService;


public class AgenteServiceImpl implements AgenteService{
	
	private AgenteDAO agenteDAO;
	private MultaDAO multaDAO;
	private static AgenteServiceImpl INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(AgenteServiceImpl.class);
	
	private AgenteServiceImpl() {
		super();
		agenteDAO = AgenteDAO.getInstance();
		multaDAO = MultaDAO.getInstance();
	}
	
	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static AgenteServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgenteServiceImpl();
		}
		return INSTANCE;
	}

	@Override
	public Agente existe(String placa, String password) {
		//TODO Obtener: 
		//- Multas
		//- Objetivo Anual
		//- Objetivo Mensual
		//- Objetivo Meses ( ArrayList<Objetivo> )
		return agenteDAO.login(placa, password);
	}


	@Override
	public Multa multar(int idCoche, int idAgente, String concepto, float importe) throws Exception {
		Multa m = null;
		try {
			m = multaDAO.insert(importe, concepto, idCoche, idAgente);
		}catch (Exception e) {
			LOG.error(e);
		}
		
		return m;
	}

	@Override
	public List<Multa> obtenerMultas(int idAgente) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
