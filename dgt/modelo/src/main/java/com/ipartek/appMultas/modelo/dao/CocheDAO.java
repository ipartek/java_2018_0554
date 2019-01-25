package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Coche;

public class CocheDAO {

	private final static String SQL_GETBYMATRICULA = "{call coche_getByMatricula(?)}";
	private final static String SQL_GETBYID = "{call coche_getById(?)}";
	private final static String SQL_GETALL = "{call coche_getAll()}";

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance
	private CocheDAO() {
		super();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static CocheDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CocheDAO();
		}
		return INSTANCE;
	}
	/**
	 * Obtiene un coche a partir de la matrícula que recibe por parámetro. 
	 * @param matricula Matrícula del coche
	 * @return Coche con dicha matricula. Null si el coche no existe.
	 */
	public Coche getByMatricula(String matricula) {
		Coche c = null;

		String sql = SQL_GETBYMATRICULA;

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
	 * Obtiene todos los coches de la BD
	 * @return Un arrayList de coches
	 */
	public ArrayList<Coche> getAll(){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Coche c = null;
		String sql =SQL_GETALL;
		
		try(
			Connection conn = ConnectionManager.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			ResultSet rs = cs.executeQuery();	
			){
			while (rs.next()) {
				
				c = rowMapper(rs);
				coches.add(c);
			}
			
		}catch (Exception e) {
			LOG.debug(e);
		}
		
		return coches;
	}
	
	
	/**
	 * Obtiene un coche a partir del ID que recibe por parámetro. 
	 * @param id ID del coche en la BD.
	 * @return Coche con dicho ID. Null si el coche no existe.
	 */
	public Coche getBYId(Long id) {
		Coche c = new Coche();

		String sql = SQL_GETBYID;

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
	/**
	 * Constructor del coche mediante una consulta a la BD. 
	 * @param rs REsultSet de la consulta realizada a la BD. 
	 * @return Coche existente en la BD.
	 * @throws SQLException
	 */
	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getLong("km"));
		return c;
	}

}
