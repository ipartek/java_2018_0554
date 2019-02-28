package com.ipartek.formacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.daos.LoginDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.Singleton;

public class AgenteServiceImpl implements AgenteService, Singleton {

	private static MultaDAO multaDAO;
	private static CocheDAO cocheDAO;
	private static LoginDAO loginDAO;
	private static AgenteServiceImpl INSTANCE = null;
	
	private AgenteServiceImpl() {
		super();	
		multaDAO = MultaDAO.getInstance();
		cocheDAO = CocheDAO.getInstance();
		loginDAO = LoginDAO.getInstance();
	}

	public static synchronized AgenteServiceImpl getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new AgenteServiceImpl();
        } 
        return INSTANCE;
    }

//LOGIN AGENTE GET
	@Override
	public Agente existe(String placa, String password) {
	
		
		return loginDAO.login(placa, password);
	}
// CREAR MULTA POST
	@Override
	public Multa multar(int idCoche, int idAgente, String concepto, float importe) throws Exception {
		return null;
	}

	
// GET ALL MULTAS BY ID AGENTE
	@Override
	public List<Multa> listarMultas(int id) {
		return multaDAO.getAllByUser(id);
	}
	
//BUSCAR POR MATRICULA
	@Override
	public Coche buscarMatricula(String matricula) {	
		return cocheDAO.getByMatricula(matricula);
	}


}