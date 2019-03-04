package com.ipartek.formacion.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;


public class AgenteServiceImpl implements AgenteService {
	
	private static AgenteServiceImpl INSTANCE = null;
	private static AgenteDAO agenteDAO;
	private static MultaDAO multaDAO;
	
	private AgenteServiceImpl() {
		super();
		agenteDAO = AgenteDAO.getInstance();
		multaDAO = MultaDAO.getInstance();
	}

	public static synchronized AgenteServiceImpl getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new AgenteServiceImpl();
        } 
        return INSTANCE;
	}

	@Override
	public Agente existe(int placa, String password) {
		
		return agenteDAO.getLogin(placa, password);
	}

	@Override
	public boolean multar(Multa multa, long idCoche) throws Exception {
		boolean insertado = false;
		try {
		
		insertado = multaDAO.insert(multa, idCoche);
		
		} catch(SQLException e){
			return false;
			
		}
		return insertado;
	}

	@Override
	public ArrayList<Multa> obtenerMultas(long idAgente) {
		
		return multaDAO.getAllByUser(idAgente);
	}

	@Override
	public boolean darBaja(int idMulta) {
		boolean anular = false;
		
		try {
			anular = multaDAO.darBaja(idMulta);
		} catch (SQLException e) {
			return false;
		}
		
		return anular;
	}

	@Override
	public boolean darAlta(int idMulta) {
		boolean recuperar = false;
		
		try {
			recuperar = multaDAO.darAlta(idMulta);
		} catch (SQLException e) {
			return false;
		}
		
		return recuperar;
	}

}
