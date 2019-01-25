package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Coche;

public class CocheDAO {

	private final static String SQL_GETBYMATRICULA = "{call coche_getByMatricula(?)}";
	private final static String SQL_GETBYID = "{call coche_getById(?)}";
	private final static String SQL_GETALL = "{call coche_getAll()}";
	private final static String SQL_INSERT = "{call coche_insert(?,?,?,?)}";
	private final static String SQL_DELETE = "{call coche_delete(?)}";
	private final static String SQL_UPDATE_COCHE = "{call coche_update(?,?,?,?)}";
	private final static String SQL_DARDEBAJA_COCHE="{call coche_dar_de_baja(?)}";


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
	 * Metodo que te permite registrar un nuevo coche
	 * @param c el objeto coche que se quiere insertar
	 * @return true si se ha insertado correctamente y false en caso de que no se haya insertado correctamente
	 * @throws SQLException
	 */
	public boolean insert(Coche c) throws SQLException {
		boolean resul = false;
		
		String sql = SQL_INSERT;
		try(
			Connection conn = ConnectionManager.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			){
			//parametros de entrada
			cs.setString(1, c.getMatricula());
			cs.setString(2, c.getModelo());
			cs.setLong(3, c.getKm());
			
			// parametros de salida
			cs.registerOutParameter(4, Types.INTEGER);
			
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				// conseguir id generado
				c.setId(cs.getLong(4));
				resul = true;
			}	
		}
		return resul;
	}
	
	/**
	 * Metodo que elimina un cochede la bd.
	 * @param idCoche es el id del coche que se quiere eliminar
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(Long idCoche) throws SQLException {
		boolean resul= false;
		String sql = SQL_DELETE;
		try(
			Connection conn = ConnectionManager.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			){
			cs.setLong(1, idCoche);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}
	
	/**
	 * Metodo que actualiza todo el coche
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCoche(Coche c) throws SQLException {
		boolean resul = false;
		String sql = SQL_UPDATE_COCHE;
		try(Connection conn = ConnectionManager.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			){
			cs.setString(1, c.getMatricula());
			cs.setString(2, c.getModelo());
			cs.setLong(3, c.getKm());
			cs.setLong(4, c.getId());
			
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}	
		}
		
		return resul;
	}
	
	/**
	 * Metodo que anula un coche, actualizando su campo fecha_baja en la bd
	 * @param idCoche el id del coche que se quiere anular
	 * @return 
	 * @throws SQLException
	 */
	public boolean darDeBajaCoche(Long idCoche) throws SQLException {
		boolean resul= false;
		String sql = SQL_DARDEBAJA_COCHE;
		
		try(
			Connection conn = ConnectionManager.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			){
			cs.setLong(1, idCoche);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
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
