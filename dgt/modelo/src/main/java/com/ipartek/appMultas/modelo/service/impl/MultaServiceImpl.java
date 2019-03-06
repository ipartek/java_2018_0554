package com.ipartek.appMultas.modelo.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Multa;
import com.ipartek.appMultas.modelo.service.MultaService;

public class MultaServiceImpl implements MultaService {

	private MultaDAO multaDAO;
	private final static Logger LOG = Logger.getLogger(MultaServiceImpl.class);
	private static MultaServiceImpl INSTANCE = null;

	private MultaServiceImpl() {
		super();
		multaDAO = MultaDAO.getInstance();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static MultaServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MultaServiceImpl();
		}
		return INSTANCE;
	}

	@Override
	public Multa getById(int idMulta) {
		Multa m = null;
			try {
				m = multaDAO.getById(Long.valueOf(idMulta));
			}catch (Exception e) {
				LOG.error(e);
			}
		
		return m;
	}
	
	@Override
	public boolean darDeBaja(int idMulta) {
		boolean isBaja = false;

		try {
			isBaja = multaDAO.darBajaMulta(Long.valueOf(idMulta));
		} catch (SQLException e) {
			LOG.error(e);
		}

		return isBaja;
	}

	@Override
	public boolean darDeAlta(int idMulta) {
		boolean isAlta = false;
		
		try {
			isAlta = multaDAO.desAnularMulta(Long.valueOf(idMulta));
		} catch (SQLException e) {
			LOG.error(e);
		}
		return isAlta;
	}

}
