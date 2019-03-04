package com.ipartek.formacion.service.impl;

import java.util.List;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.Singleton;

public class AgenteServiceImpl implements AgenteService, Singleton {

	private AgenteDAO agenteDao;
	private MultaDAO multaDao;
	private static AgenteServiceImpl INSTANCE = null;
	
	private AgenteServiceImpl() {
		super();	
		agenteDao = AgenteDAO.getInstance();
		multaDao = MultaDAO.getInstance();		
	}

	public static synchronized AgenteServiceImpl getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new AgenteServiceImpl();
        } 
        return INSTANCE;
    }


	@Override
	public Agente existe(String placa, String password) {		 
		
		return agenteDao.login(placa, password);
	}

	@Override
	public Multa multar(int idCoche, int idAgente, String concepto, float importe) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Multa> obtenerMultas(int idAgente) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Multa> detalle(long id) {
		return (List<Multa>) multaDao.detalle(id);
	}

	@Override
	public List<Multa> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}