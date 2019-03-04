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
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;


public class MultaDAO {
	private final static Logger LOG = Logger.getLogger(MultaDAO.class);
	private static MultaDAO INSTANCE = null;
	private boolean isGetById = false;
	private boolean isBaja = false;
	
	
	private static final String MULTAS_ANULADAS = "baja";
	//private static final String MULTAS_ACTIVAS = "activas";

	private static final String SQL_GETBYID = "{call pa_multa_getById(?)}";
	private static final String SQL_GETALL_BYUSER = "SELECT multa.id as 'id_multa', coche.id as 'id_coche', multa.concepto as 'concepto', multa.fecha_alta as 'fecha_alta', multa.fecha_baja as 'fecha_baja', coche.matricula as 'matricula', coche.modelo as 'modelo', multa.importe as 'importe' FROM multa inner join coche on multa.id_coche = coche.id inner join agente on multa.id_agente = agente.id WHERE multa.id_agente = ? ORDER BY multa.id DESC LIMIT 1000;";
	private static final String SQL_INSERT = "{call pa_multa_insert(?,?,?,?,?)}";
	private static final String SQL_UPDATE = "{call pa_multa_update(?,?)}";
	private static final String SQL_DAR_DE_BAJA = "update multa set fecha_baja = current_timestamp where id = ?";
	private static final String SQL_DAR_DE_ALTA = "update multa set fecha_baja = null where id = ?";

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

	public Multa getById(long id, String opm) {

		Multa m = null;

		isGetById = true;

		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETBYID);) {
			cs.setLong(1, id);
			
			if ("baja".equals(opm)) {
				isBaja = true;
			} else {
				isBaja = false;
			}

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

	public ArrayList<Multa> getAllByAgente(long id) {

		ArrayList<Multa> multas = new ArrayList<Multa>();
		isGetById = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL_BYUSER);) {

			pst.setLong(1, id);
			try (ResultSet rs = pst.executeQuery()) {
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

	public boolean insert(Multa m, long idCoche) throws SQLException {

		boolean resul = false;
		isGetById = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_INSERT);) {

			cs.setDouble(1, m.getImporte());
			cs.setString(2, m.getConcepto());
			cs.setLong(3, idCoche);
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
	
	
	public boolean darDeBaja(int idMulta) throws SQLException {

		boolean resul = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DAR_DE_BAJA);) {
			
			pst.setInt(1, idMulta);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}
	
	public boolean darDeAlta(int idMulta) throws SQLException {

		boolean resul = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DAR_DE_ALTA);) {
			
			pst.setInt(1, idMulta);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}

	public boolean update(Multa m, String opr) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_UPDATE);) {

			cs.setLong(1, m.getId());
			cs.setString(2, opr);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}
	private Multa rowMapper(ResultSet rs) throws SQLException {
		Multa multa = new Multa();
		Coche coche = new Coche();
		multa.setId((long)rs.getInt("id_multa"));
		multa.setConcepto(rs.getString("concepto"));
		multa.setFechaAlta(rs.getDate("fecha_alta"));
		multa.setFechaBaja(rs.getDate("fecha_baja"));
		multa.setImporte(rs.getDouble("importe"));
		coche.setId((long)rs.getInt("id_coche"));
		coche.setMatricula(rs.getString("matricula"));
		coche.setModelo(rs.getString("modelo"));
		
		multa.setCoche(coche);
		return multa;
	}
		/*
	private Multa rowMapper(ResultSet rs) throws SQLException {
		Multa m = new Multa();
		Coche c = new Coche();
		Timestamp timestampalta = rs.getTimestamp("fecha_alta");
		m.setFechaAlta(new java.util.Date(timestampalta.getTime()));
		if (isBaja) {
			Timestamp timestampbaja = rs.getTimestamp("fecha_baja");
			if(timestampbaja==null) {
				m.setFechaBaja(null);
			}else {
				m.setFechaBaja(new java.util.Date(timestampbaja.getTime()));
			}
			
		}
		m.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		if (isGetById) {
			m.setImporte(rs.getDouble("importe"));
			m.setConcepto(rs.getString("concepto"));
			c.setId(rs.getLong("id_coche"));
			c.setModelo(rs.getString("modelo"));
			c.setKm(rs.getInt("km"));
		}
		m.setCoche(c);
		return m;
	}*/

}
