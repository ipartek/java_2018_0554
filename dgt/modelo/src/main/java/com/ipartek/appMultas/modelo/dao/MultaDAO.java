package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Coche;
import com.ipartek.appMultas.modelo.pojo.Multa;

public class MultaDAO {

	private final static String SQL_GET_ALL_BY_ID_AGENTE = "{call pa_getMultasByIdAgente(?)}";

	private final static String SQL_GET_BY_ID = "{call pa_getMultaById(?)}";

	private final static String SQL_INSERT = "{call pa_multa_insert(?,?,?,?,?)}";
	private final static String SQL_UPDATE = "{call pa_multa_update(?)}";
	
	private final static Logger LOG = Logger.getLogger(MultaDAO.class);

	private static final String SQL_GET_ALL_BY_ID_AGENTE_ANULADA ="{call pa_getMultasByIdAgenteAnulada(?)}";
	private static MultaDAO INSTANCE = null;


	private MultaDAO() {
		super();
	}

	public synchronized static MultaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MultaDAO();
		}
		return INSTANCE;
	}
	
	/**
	 * Muestra todas las multas de un agente. 
	 * @param idAgente
	 * @return lista de multas
	 * @throws SQLException si no encuentra multas existentes
	 */
	public HashMap<Long, Multa> getAllByIdAgente(Long idAgente) throws SQLException {
		HashMap<Long, Multa> multasAgente = new HashMap<>();
		Multa m = new Multa();
		String sql = SQL_GET_ALL_BY_ID_AGENTE;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, idAgente);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					m = rowMapper(rs);
					multasAgente.put(m.getId(), m);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return multasAgente;
	}
	
	/**
	 * Muestra solo las multas anuladas 
	 * @param idAgente 
	 * @return lista de multas anuladas. 
	 * @throws SQLException si no encuentra multas que se hayan dado de baja
	 */
	public HashMap<Long, Multa> getAllByIdAgenteAnulada(Long idAgente) throws SQLException {
		HashMap<Long, Multa> multasAgente = new HashMap<>();
		Multa m = new Multa();
		String sql = SQL_GET_ALL_BY_ID_AGENTE_ANULADA;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, idAgente);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					m = rowMapperAnulada(rs);
					multasAgente.put(m.getId(), m);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return multasAgente;
	}
	
	public ArrayList<Multa> getAll(){
		ArrayList<Multa> multas = new ArrayList<Multa>();
		Multa m = null;
		String sql = SQL_GET_ALL_BY_ID_AGENTE;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					m = rowMapper(rs);
					multas.add(m);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return multas;
	}

	/**
	 *  Registra una multa nueva
	 * @param importe
	 * @param concepto
	 * @param idCoche
	 * @param idAgente
	 * @return
	 * @throws SQLException
	 */
	public Multa insert(Float importe, String concepto, int idCoche, int idAgente) throws SQLException {
		Multa m = null;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			// parametros de entrada
			cs.setDouble(1, importe);
			cs.setString(2, concepto);
			cs.setLong(3, idCoche);
			cs.setLong(4, idAgente);

			// parametros de salida
			cs.registerOutParameter(5, Types.INTEGER);

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				m = new Multa();
				// conseguir id generado
				m.setId(cs.getLong(5));
				m.setImporte(importe.doubleValue());
				m.setConcepto(concepto);
			}
		}
		return m;
	}

	
	

	private Multa rowMapper(ResultSet rs) throws SQLException {
		Multa m = new Multa();
		m.setId(rs.getLong("id_multa"));
		m.setConcepto(rs.getString("concepto"));
		m.setImporte(rs.getDouble("importe"));
		m.setFecha(rs.getTimestamp("fecha_alta"));
		
			m.setCoche( new Coche(
								rs.getLong("id_coche"), 
								rs.getString("matricula"), 
								rs.getString("modelo"), 
								rs.getLong("km")));
			return m;
	}

	//rowmap para solo las multas anuladas
	private Multa rowMapperAnulada(ResultSet rs) throws SQLException {
		Multa m = new Multa();
		m.setId(rs.getLong("id_multa"));
		m.setConcepto(rs.getString("concepto"));
		m.setImporte(rs.getDouble("importe"));
		m.setFecha(rs.getTimestamp("fecha_alta"));
		m.setFechaBaja(rs.getTimestamp("fecha_baja"));
		
			m.setCoche( new Coche(
								rs.getLong("id_coche"), 
								rs.getString("matricula"), 
								rs.getString("modelo"), 
								rs.getLong("km")));
			return m;
	}

}
