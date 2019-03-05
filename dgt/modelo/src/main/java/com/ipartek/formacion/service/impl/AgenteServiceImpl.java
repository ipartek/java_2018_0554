package com.ipartek.formacion.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.daos.AgenteDAO;
import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.daos.VehiculoDAO;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Multa;
import com.ipartek.formacion.modelo.pojo.MultaNueva;
import com.ipartek.formacion.modelo.pojo.Vehiculo;
import com.ipartek.formacion.service.AgenteService;


public class AgenteServiceImpl implements AgenteService {
	
	
	private AgenteDAO agenteDAO;
	private MultaDAO multaDAO;
	private VehiculoDAO vehiculoDAO;

	private static AgenteServiceImpl INSTANCE = null;
	
	private final static Logger LOG = Logger.getLogger(AgenteServiceImpl.class);

	private AgenteServiceImpl() {
		super();
		agenteDAO = AgenteDAO.getInstance();
		multaDAO = MultaDAO.getInstance();
		vehiculoDAO = VehiculoDAO.getInstance();
		
	}
	
	public static synchronized AgenteServiceImpl getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new AgenteServiceImpl();
        } 
        return INSTANCE;
	}

	@Override
	public Agente existe(String placa, String password) {

				//Agente agente = null;
				
				
				/*if ( "admin".equals(password) && "admin".equals(numeroPlaca)) {
					agente = new Agente(1l, "Takelberry", "12345678", "");
				}*/
				
				
				return agenteDAO.getByPlaca(placa, password);
	}

	

	

	@Override
	public List<Multa> listarMultas(long id) {
		return multaDAO.getAllByIdAgente(id);
	}

	@Override
	public Vehiculo buscarMatricula(String matricula) {
		
		return vehiculoDAO.getByMatricula(matricula);
	}

	/*@Override
	public boolean insertar(Multa multa, int idCoche) {
		boolean resultado = false;
		try {
			resultado = multaDAO.insert(multa, idCoche);
		} catch (SQLException e) {
			return false;
		}
		return resultado;
	
	}*/

	@Override
	public Vehiculo conseguirId(String matricula) {
		return vehiculoDAO.getByMatricula(matricula);
	}

	

	@Override
	public boolean insertar(MultaNueva multa) {
		boolean resultado = false;
		try {
			resultado = multaDAO.insert(multa);
		} catch (SQLException e) {
			return false;
		}
		return resultado;
	
	}

	@Override
	public List<Multa> listarMultasAnuladas(long id) {
		return multaDAO.getAnulada(id);
	}

	@Override
	public boolean anular(int idMulta) {
		boolean resultado = false;
		try {
			resultado = multaDAO.anularMulta(idMulta);
		} catch (SQLException e) {
			return false;
		}
		return resultado;
	}
	

	
	
	
	

}
