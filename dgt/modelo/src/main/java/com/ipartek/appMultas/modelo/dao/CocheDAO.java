package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Coche;

public class CocheDAO {

	private final static String SQL_GETALL = "{call pa_getCoches()}";
	private final static String SQL_GET_BY_MATRICULA = "{call pa_getByMatricula(?)}";
	private final static String SQL_GET_BY_ID = "{call pa_getCocheById(?)}";
	
	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;

	// constructor privado
	private CocheDAO() {
		super();
	}

	//patron SINGLETON
	public synchronized static CocheDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CocheDAO();
		}
		return INSTANCE;
	}
	
	/**
	 * Lista de vehiculos
	 * @return ArrayList 
	 */
	public ArrayList<Coche> getAll(){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Coche c = null;
		String sql = SQL_GETALL;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					c = rowMapper(rs);
					coches.add(c);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return coches;
	}
	
	/**
	 * muestra los coches por su matricula
	 * @param matricula 
	 * @return Coche
	 */
	public Coche getByMatricula(String matricula) {
		Coche c = null;

		String sql = SQL_GET_BY_MATRICULA;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setString(1, matricula);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return c;
	}
	/**
	 * Muestra los coches por su ID 
	 * @param id del coche
	 * @return coche que coincide con la id del parametro
	 */
	public Coche getBYId(Long id) {
		Coche c = new Coche();

		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return c;
	}
	
	
	
	
	
	
	

	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getLong("km"));
		return c;
	}

}
