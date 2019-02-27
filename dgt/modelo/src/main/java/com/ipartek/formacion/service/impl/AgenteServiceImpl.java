package com.ipartek.formacion.service.impl;

import java.util.List;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.AgenteService;


public class AgenteServiceImpl implements AgenteService {
	
	
	private AgenteDAO agenteDAO;
	

	private static AgenteServiceImpl INSTANCE = null;

	private AgenteServiceImpl() {
		super();
		agenteDAO = AgenteDAO.getInstance();
		
	}
	
	public static synchronized AgenteServiceImpl getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new AgenteServiceImpl();
        } 
        return INSTANCE;
	}

	@Override
	public Agente existe(String placa, String password) {
		// TODO llamar al DAO
				//Agente agente = null;
				
				
				/*if ( "admin".equals(password) && "admin".equals(numeroPlaca)) {
					agente = new Agente(1l, "Takelberry", "12345678", "");
				}*/
				
				
				return agenteDAO.getByPlaca(placa, password);
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

}
