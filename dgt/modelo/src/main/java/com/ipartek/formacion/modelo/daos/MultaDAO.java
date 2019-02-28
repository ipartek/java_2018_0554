package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;

public class MultaDAO {
	private final static Logger LOG = Logger.getLogger(MultaDAO.class);
	private static MultaDAO INSTANCE = null;
	private boolean isGetById = false;
	private boolean isBaja = false;

	private static final String MULTAS_ANULADAS = "baja";
	// private static final String MULTAS_ACTIVAS = "activas";

	private static final String SQL_GETBYID = "{call pa_multa_getById(?)}";
	private static final String SQL_GETALL_BYUSER = "{call pa_multa_getByAgenteId(?,?)}";
	private static final String SQL_INSERT = "{call pa_multa_insert(?,?,?,?,?)}";
	private static final String SQL_UPDATE = "{call pa_multa_update(?,?)}";
	private static final String SQL_GET_ACTIVA_BYUSER = "SELECT m.id, m.concepto, m.importe , m.fecha_alta, m.fecha_mod, a.id, a.nombre, a.placa FROM multa as m, agente as a where a.id=m.id_agente and a.id=?";
	// private static final String SQL_GETALL = "SELECT m.id, m.concepto, m.importe
	// , m.fecha_alta, m.fecha_mod, a.id, a.nombre, a.placa FROM multa as m, agente
	// as a where a.id=m.id_agente";
	private static final String SQL_GETALL = "SELECT m.id, m.concepto, m.importe , m.fecha_alta, m.fecha_mod, a.id, a.nombre, a.placa FROM multa as m, agente as a where a.id=m.id_agente";

	// constructor privado, solo acceso por getInstance()
	private MultaDAO() {
		super();
	}

	public synchronized static MultaDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new MultaDAO();
		}
		return INSTANCE;
	}

	public Multa getById(long id) {

		Multa m = null;

		isGetById = true;

		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETBYID);) {
			cs.setLong(1, id);

			

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					m = rowMapper(rs);
				}
				LOG.debug("Multa encontrada");
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return m;
	}

	public ArrayList<Multa> getAll() {

		ArrayList<Multa> multas = new ArrayList<Multa>();
		isGetById = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				multas.add(rowMapper(rs));
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return multas;
	}

	public Multa getMultaActivaByAgente(long id) {

		Multa multas = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_ACTIVA_BYUSER);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					try {
						multas = rowMapper(rs);
					} catch (Exception e) {
						LOG.error(e);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return multas;
	}

	public ArrayList<Multa> getAllByUser(long id) {

		ArrayList<Multa> multas = new ArrayList<Multa>();
		isGetById = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETALL_BYUSER);) {
			
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					try {
						multas.add(rowMapper(rs));
					} catch (Exception e) {
						LOG.error(e);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return multas;
	}

	public boolean insert(Multa m) throws SQLException {

		boolean resul = false;
		isGetById = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_INSERT);) {

			cs.setDouble(1, m.getImporte());
			cs.setString(2, m.getConcepto());
			cs.setLong(3, m.getCoche().getId());
			cs.setLong(4, m.getAgente().getId());
			cs.registerOutParameter(5, Types.INTEGER);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				m.setId(cs.getLong(5));
				resul = true;
			}

		}
		return resul;

	}

	public boolean update(Multa m) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_UPDATE);) {

			cs.setLong(1, m.getId());
		
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}

	private Multa rowMapper(ResultSet rs) throws SQLException {
		Multa m = new Multa();
		Coche c = new Coche();
		Agente a = new Agente();
		Timestamp timestampalta = rs.getTimestamp("fecha_alta");
		m.setFechaAlta(new java.util.Date(timestampalta.getTime()));
		if (isBaja) {
			Timestamp timestampbaja = rs.getTimestamp("fecha_baja");
			if (timestampbaja == null) {
				m.setFechaBaja(null);
			} else {
				m.setFechaBaja(new java.util.Date(timestampbaja.getTime()));
			}

		}
		m.setId(rs.getLong("id"));
		m.setConcepto(rs.getString("concepto"));
		m.setImporte(rs.getDouble("importe"));

		if (isGetById) {
			c.setMatricula(rs.getString("matricula"));
			a.setId(rs.getLong("id"));
			m.setImporte(rs.getDouble("importe"));
			m.setConcepto(rs.getString("concepto"));
			c.setId(rs.getLong("id_coche"));
			c.setModelo(rs.getString("modelo"));
			c.setKm(rs.getInt("km"));
			a.setId(rs.getLong("id_agente"));
		}
		m.setCoche(c);
		m.setAgente(a);
		return m;
	}

}
