package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	
	//private static final String MULTAS_ANULADAS = "baja";
	//private static final String MULTAS_ACTIVAS = "activas";

	private static final String SQL_GETBYID = "{call pa_multa_getById(?)}";
	private static final String SQL_GETALL_BYUSER = "SELECT m.id, m.fecha_alta, m.fecha_baja, c.matricula, m.importe, m.concepto, c.modelo FROM multa m, coche c WHERE m.id_coche = c.id AND m.id_agente = ? AND m.fecha_baja IS NULL ORDER BY m.fecha_alta DESC LIMIT 1000;";
	private static final String SQL_INSERT = "{call pa_multa_insert(?,?,?,?,?)}";
	private static final String SQL_UPDATE = "{call pa_multa_update(?,?)}";
	private static final String SQL_GETALL_BYUSER_ANULADA = "SELECT m.id, m.fecha_alta, m.fecha_baja, c.matricula, m.importe, m.concepto, c.modelo FROM multa m, coche c WHERE m.id_coche = c.id AND m.id_agente = ? AND m.fecha_baja IS NOT NULL ORDER BY m.fecha_alta DESC LIMIT 1000;";

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

	public ArrayList<Multa> getAllByIdAgente(long id) {

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
	
	public ArrayList<Multa> getMultasAnuladas(long id) {
		isBaja = true;
		ArrayList<Multa> multas = new ArrayList<Multa>();
		isGetById = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL_BYUSER_ANULADA);) {
			
			pst.setLong(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				isGetById = true;
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
	
	public Multa detalle(long id) {
		Multa m = null;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL_BYUSER);
				) {
				pst.setInt(1, (int) id);
				try(ResultSet rs  = pst.executeQuery()){
					while(rs.next()) {
						m = rowMapper(rs);
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}
	
//	public HashMap<Long, Multa> getAllByIdAgente(Long idAgente) throws SQLException {
//		HashMap<Long, Multa> multasAgente = new HashMap<>();
//		Multa m = new Multa();
//		String sql = SQL_GETALL_BYUSER;
//		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
//			cs.setLong(1, idAgente);
//			try (ResultSet rs = cs.executeQuery()) {
//				while (rs.next()) {
//					m = rowMapper(rs);
//					multasAgente.put(m.getId(), m);
//				}
//			}
//		} catch (Exception e) {
//			LOG.debug(e);
//		}
//		return multasAgente;
//	}

	public boolean insert(Multa m, int idCoche) throws SQLException {

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
		Multa m = new Multa();
		Coche c = new Coche();
		Agente a = new Agente();
		m.setFechaAlta(rs.getDate("fecha_alta"));
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
		m.setImporte(rs.getFloat("importe"));
		m.setConcepto(rs.getString("concepto"));
		m.setFechaBaja(rs.getDate("fecha_alta"));
		
		if (isGetById) {
			
			
			c.setId(rs.getLong("coche_id"));
			c.setId(rs.getLong("id_coche"));
			c.setId(rs.getLong("id_agente"));
			c.setModelo(rs.getString("modelo"));
			c.setKm(rs.getInt("km"));
			a.setId(rs.getLong("agente_id"));
			a.setNombre(rs.getString("nombre"));
			a.setPlaca(rs.getString("placa"));
		}
		m.setCoche(c);
		m.setAgente(a);
		return m;
	}
}
