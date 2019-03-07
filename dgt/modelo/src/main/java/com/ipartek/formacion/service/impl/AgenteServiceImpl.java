package com.ipartek.formacion.service.impl;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.daos.EstadisticasDAO;
import com.ipartek.formacion.modelo.daos.LoginDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Estadistica;
import com.ipartek.formacion.service.AgenteService;

public class AgenteServiceImpl implements AgenteService {

	private static LoginDAO loginDAO;
	private static EstadisticasDAO estadisticasDAO;
//	private ValidatorFactory factory;
//	private Validator validator;
	private static AgenteServiceImpl INSTANCE = null;

	private AgenteServiceImpl() {
		super();
		loginDAO = LoginDAO.getInstance();
		estadisticasDAO = EstadisticasDAO.getInstance();
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
	
	@Override
	public ArrayList<Estadistica> objetivosMes(int idAgente, int anyo) {

		return estadisticasDAO.objetivosMes(idAgente, anyo);
	}
	@Override
	public float objetivosAnyo(int idAgente, int anyo) {

		return estadisticasDAO.objetivosAnyo(idAgente, anyo);
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
