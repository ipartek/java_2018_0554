package com.ipartek.formacion.service.impl;

import com.ipartek.formacion.modelo.daos.LoginDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.service.AgenteService;

public class AgenteServiceImpl implements AgenteService {

	private static LoginDAO loginDAO;
//	private ValidatorFactory factory;
//	private Validator validator;
	private static AgenteServiceImpl INSTANCE = null;

	private AgenteServiceImpl() {
		super();
		loginDAO = LoginDAO.getInstance();
//		factory = Validation.buildDefaultValidatorFactory();
//		validator = factory.getValidator();
//		
	}

	public static synchronized AgenteServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgenteServiceImpl();
		}
		return INSTANCE;
	}

	@Override
	public Agente existe(int placa, String password) {

		return loginDAO.login(placa, password);
	}

//	@Override
//	public Multa multar(int idCoche, int idAgente, String concepto, float importe) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Multa> obtenerMultas(int idAgente) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
