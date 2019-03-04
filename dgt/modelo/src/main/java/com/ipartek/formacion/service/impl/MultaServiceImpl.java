

package com.ipartek.formacion.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.service.MultaService;



public class MultaServiceImpl implements MultaService {

	private static MultaDAO multaDAO;
	private static CocheDAO cocheDAO;
//	private ValidatorFactory factory;
//	private Validator validator;
	private static MultaServiceImpl INSTANCE = null;

	private MultaServiceImpl() {
		super();
		multaDAO = MultaDAO.getInstance();
		cocheDAO = CocheDAO.getInstance();
//		factory = Validation.buildDefaultValidatorFactory();
//		validator = factory.getValidator();
//		
	}

	public static synchronized MultaServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MultaServiceImpl();
		}
		return INSTANCE;
	}



	@Override
	public boolean insertar(Multa multa, int idCoche) {
		boolean resultado = false;
		try {
			resultado = multaDAO.insert(multa, idCoche);
		} catch (SQLException e) {
			return false;
		}
		return resultado;
	}
	
	@Override
	public boolean darDeBaja(int idAgente) {
		boolean resultado = false;
		try {
			resultado = multaDAO.darDeBaja(idAgente);
		} catch (SQLException e) {
			return false;
		}
		return resultado;
	}
	
	@Override
	public boolean darDeAlta(int idAgente) {
		boolean resultado = false;
		try {
			resultado = multaDAO.darDeAlta(idAgente);
		} catch (SQLException e) {
			return false;
		}
		return resultado;
	}

	@Override
	public ArrayList<Multa> listar(int idAgente) {
		return multaDAO.getAllByAgente(idAgente);
	}

	@Override
	public Coche conseguirId(String matricula) {
		return cocheDAO.getByMatricula(matricula);
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
