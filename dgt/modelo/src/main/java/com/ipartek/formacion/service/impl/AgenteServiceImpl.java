package com.ipartek.formacion.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.Singleton;

public class AgenteServiceImpl implements AgenteService, Singleton {

	private AgenteDAO agenteDao;
	private MultaDAO multaDao;
	private CocheDAO cocheDao;
	private static AgenteServiceImpl INSTANCE = null;
	
	private AgenteServiceImpl() {
		super();	
		agenteDao = AgenteDAO.getInstance();
		multaDao = MultaDAO.getInstance();
		cocheDao = CocheDAO.getInstance();
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
	public boolean multar(Multa multa, int idCoche) {
		boolean resultado = false;
		try {
			resultado = multaDao.insert(multa, idCoche);
		} catch (SQLException e) {
			return false;
		}
		return resultado;
	}

	@Override
	public List<Multa> obtenerMultas(long idAgente) {
		return multaDao.getAllByIdAgente(idAgente);
	}

	@Override
	public List<Multa> obtenerMultasAnuladas(long idAgente) {
		return multaDao.getMultasAnuladas(idAgente);
	}

	@Override
	public Coche idCoche(String matricula) {
		return cocheDao.getByMatricula(matricula);
	}
	
	


}