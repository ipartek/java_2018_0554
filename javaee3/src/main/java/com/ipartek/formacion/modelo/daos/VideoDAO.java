package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojos.Videos;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;
	
	private static final String SQL_GETBYID = "SELECT id, nombre, codigo FROM video WHERE id = ?;";
	private static final String SQL_GETALL = "SELECT id, nombre, codigo FROM video ORDER BY id DESC LIMIT 1000;";
	private static final String SQL_INSERT = "INSERT INTO video  (nombre, codigo) VALUES( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE video SET nombre = ? , codigo = ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";

	// constructor privado, solo acceso por getInstance()
	private VideoDAO() {
		super();
	}

	public synchronized static VideoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	

	public Videos getById(long id) {

		Videos v = null;
		

		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(SQL_GETBYID);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { 
					v = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	

	public ArrayList<Videos> getAll() {

		ArrayList<Videos> videos = new ArrayList<Videos>();
	
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {					
					videos.add(rowMapper(rs));
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	public boolean insert(Videos v) throws SQLException {

		boolean resul = false;
	
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT);) {

			pst.setString(1, v.getNombre() );
			pst.setString(2, v.getCodigo() );
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	public boolean update(Videos v) throws SQLException {

		boolean resul = false;		
		try (Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {
			
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getId());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}
	
	
	public boolean delete( long id ) throws SQLException {

		boolean resul = false;		
		try (Connection conn = ConnectionManager.getConnection(); 
			 PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	
	private Videos rowMapper(ResultSet rs) throws SQLException {
		Videos v = new Videos();
		v.setId( rs.getLong("id"));
		v.setCodigo( rs.getString("codigo"));
		v.setNombre(rs.getString("nombre"));
		return v;
	}
	
	
}