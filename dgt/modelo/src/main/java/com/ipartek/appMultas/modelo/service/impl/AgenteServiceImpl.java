package com.ipartek.appMultas.modelo.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.dao.AgenteDAO;
import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;
import com.ipartek.appMultas.modelo.service.AgenteService;

public class AgenteServiceImpl implements AgenteService {

	private AgenteDAO agenteDAO;
	private MultaDAO multaDAO;
	private ValidatorFactory factory;
	private Validator validator;
	private static AgenteServiceImpl INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(AgenteServiceImpl.class);

	private AgenteServiceImpl() {
		super();
		agenteDAO = AgenteDAO.getInstance();
		multaDAO = MultaDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static AgenteServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgenteServiceImpl();
		}
		return INSTANCE;
	}

	@Override
	public Agente existe(String placa, String password) {
		// TODO Obtener:
		// - Multas
		// - Objetivo Anual
		// - Objetivo Mensual
		// - Objetivo Meses ( ArrayList<Objetivo> )
		return agenteDAO.login(placa, password);
	}

	@Override
	public Multa multar(int idCoche, int idAgente, String concepto, float importe) throws Exception {
		Multa m = null;
		try {
			m = new Multa();
			m.setConcepto(concepto);
			m.setImporte((double) importe);
			Set<ConstraintViolation<Multa>> violations = validator.validate(m);
			if (violations.size() > 0) {
				throw new Exception(violations.toString());
			} else {
				m = multaDAO.insert(importe, concepto, idCoche, idAgente);
			}

		} catch (Exception e) {
			LOG.error(e);
			throw new Exception(e.getMessage());
		}

		return m;
	}

	@Override
	public List<Multa> obtenerMultas(int idAgente) {
		HashMap<Long, Multa> hmMultas;
		ArrayList<Multa> multas = new ArrayList<Multa>();
		try {
			hmMultas = multaDAO.getAllByIdAgente(Long.valueOf(idAgente));
			multas = new ArrayList<Multa>(hmMultas.values());
		} catch (SQLException e) {
			LOG.error(e);
		}
		return multas;
	}

	public List<Multa> obtenerMultasAnuladas(int idAgente) {
		HashMap<Long, Multa> hmMultas;
		ArrayList<Multa> multas = new ArrayList<Multa>();
		try {
			hmMultas = multaDAO.getAllByIdAgenteDarBaja(Long.valueOf(idAgente));
			multas = new ArrayList<Multa>(hmMultas.values());
		} catch (SQLException e) {
			LOG.error(e);
		}
		return multas;
	}

}
