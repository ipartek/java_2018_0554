package com.ipartek.formacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;
import com.ipartek.formacion.service.Singleton;

public class AgenteServiceImpl implements AgenteService, Singleton {

	private static MultaDAO multaDAO;
	private static AgenteServiceImpl INSTANCE = null;
	
	private AgenteServiceImpl() {
		super();	
		multaDAO = MultaDAO.getInstance();
	}

	public static synchronized AgenteServiceImpl getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new AgenteServiceImpl();
        } 
        return INSTANCE;
    }

//LOGIN AGENTE GET
	@Override
	public Agente existe(String numeroPlaca, String password) {
		// TODO llamar al DAO
		Agente agente = null;
		
		if ( "admin".equals(password) && "admin".equals(numeroPlaca)) {
			agente = new Agente(1l, "Takelberry", "12345678", "");
		}
		
		
		return agente;
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
	
	


}