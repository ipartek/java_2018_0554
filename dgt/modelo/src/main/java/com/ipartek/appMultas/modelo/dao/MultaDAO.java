package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Coche;
import com.ipartek.appMultas.modelo.pojo.Multa;

public class MultaDAO {

	private final static String SQL_GETALLBYIDAGENTE = "{call multa_getAllByIdAgente(?)}";
	private final static String SQL_GETALLBYIDAGENTE_BAJA = "{call multa_getAllByIdAgenteBaja(?)}";

	private final static String SQL_GETBYID = "{call multa_getById(?)}";

	private final static String SQL_INSERT = "{call multa_insert(?,?,?,?,?)}";
	private final static String SQL_UPDATE_FECHA_BAJA = "{call multa_updateFechaBaja(?)}";
	private final static String SQL_DESANULAR = "{call multa_desAnular(?)}";

	private final static Logger LOG = Logger.getLogger(MultaDAO.class);
	private static MultaDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance
	private MultaDAO() {
		super();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static MultaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MultaDAO();
		}
		return INSTANCE;
	}
	/**
	 * Obtiene una multa con un ID concreto recibido por parámetro.
	 * @param idMulta ID de la multa en la BD. 
	 * @return Multa existente en la BD. 
	 */
	public Multa getById(Long idMulta) {
		Multa m = new Multa();

		String sql = SQL_GETBYID;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, idMulta);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					m = rowMapperBaja(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return m;
	}
	/**
	 * Obtiene todas las multas activas de un agente concreto. 
	 * @param idAgente ID del agente sobre el que se quieren obtener las multas. 
	 * @return HashMap de multas. 
	 * @throws SQLException Si el agente no tiene ninguna multa asignada.
	 */
	public HashMap<Long, Multa> getAllByIdAgente(Long idAgente) throws SQLException {
		HashMap<Long, Multa> multasAgente = new HashMap<>();
		Multa m = new Multa();
		String sql = SQL_GETALLBYIDAGENTE;
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
	 * Obtiene todas las multas anuladas de un agente concreto. 
	 * @param idAgente ID del agente sobre el que se quieren obtener las multas. 
	 * @return HashMap de multas anuladas. 
	 * @throws SQLException Si el agente no tiene ninguna multa anulada.
	 */
	public HashMap<Long, Multa> getAllByIdAgenteDarBaja(Long idAgente) throws SQLException {
		HashMap<Long, Multa> multasAgente = new HashMap<>();
		Multa m = new Multa();
		String sql = SQL_GETALLBYIDAGENTE_BAJA;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, idAgente);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					m = rowMapperBaja(rs);
					multasAgente.put(m.getId(), m);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return multasAgente;
	}
	/**
	 * Inserta una multa en la BD.
	 * @param m Objeto multa
	 * @param id_agente ID del creador de la multa
	 * @return True si todo es correcto. False si la inserción es errónea. 
	 * @throws SQLException Si alguno de los datos viene en formato erróneo.
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

	/**
	 * Método que anula una multa en la BD.
	 * @param id Identificador de la multa a anular
	 * @return True si todo es correcto. False si la actualización es errónea.
	 * @throws SQLException Si no puede borrarse la multa por las constraints.
	 */
	public boolean darBajaMulta(Long id) throws SQLException {
		boolean result = false;
		String sql = SQL_UPDATE_FECHA_BAJA;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
	}
	/**
	 * Método que desanula una multa en la BD.
	 * @param id Identificador de la multa a desanular
	 * @return True si todo es correcto. False si la actualización es errónea.
	 * @throws SQLException
	 */
	public boolean desAnularMulta(Long id) throws SQLException {
		boolean result = false;
		String sql = SQL_DESANULAR;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
	}
	/**
	 * Constructor de la multa obtenida de la BD. 
	 * @param rs ResultSet de la consulta realizada a la BD.
	 * @return Objeto multa creado a partir de datos de la BD.
	 * @throws SQLException
	 */
	private Multa rowMapper(ResultSet rs) throws SQLException {
		Multa m = new Multa();
		m.setId(rs.getLong("id_multa"));
		m.setConcepto(rs.getString("concepto"));
		m.setImporte(rs.getDouble("importe"));
		m.setFecha(rs.getTimestamp("fecha_alta"));
		// Seteo el coche
		m.setCoche( new Coche(
							rs.getLong("id_coche"), 
							rs.getString("matricula"), 
							rs.getString("modelo"), 
							rs.getLong("km")));
		return m;
	}
	/**
	 * Constructor de la multa obtenida de la BD con la inclusión del campo fecha_baja. 
	 * @param rs ResultSet de la consulta realizada a la BD.
	 * @return Objeto multa creado a partir de datos de la BD + fecha_baja.
	 * @throws SQLException
	 */
	private Multa rowMapperBaja(ResultSet rs) throws SQLException {
		Multa m = new Multa();
		m.setId(rs.getLong("id_multa"));
		m.setConcepto(rs.getString("concepto"));
		m.setImporte(rs.getDouble("importe"));
		m.setFecha(rs.getTimestamp("fecha_alta"));
		m.setFecha_baja(rs.getTimestamp("fecha_baja"));
		// Seteo el coche
		m.setCoche( new Coche(
							rs.getLong("id_coche"), 
							rs.getString("matricula"), 
							rs.getString("modelo"), 
							rs.getLong("km")));
		return m;
	}

}
