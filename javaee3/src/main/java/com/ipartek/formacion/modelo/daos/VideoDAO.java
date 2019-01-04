package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.Video;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;
	
	private static final String SQL_GETBYID = "SELECT v.id as 'id_video', u.id as 'id_usuario', email, password, nombre, codigo FROM video as v, usuario as u WHERE v.id_usuario = u.id AND v.id = ?;";
	private static final String SQL_GETALL  = "SELECT v.id as 'id_video', u.id as 'id_usuario', email, password, nombre, codigo FROM video as v, usuario as u WHERE v.id_usuario = u.id ORDER BY v.id DESC LIMIT 1000;";
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

	public Video getById(long id) {

Video v = null;
		

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

	private Video rowMapper(ResultSet rs) throws SQLException {
		
		Video v = new Video();
		v.setId( rs.getLong("id"));
		v.setCodigo( rs.getString("codigo"));
		v.setNombre(rs.getString("nombre"));
		
		Usuario u = new Usuario();
		u.setId(rs.getLong("id_usuario"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		
		v.setUsuario(u);
		
		return v;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> videos = new ArrayList<Video>();
		
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

	public ArrayList<Video> getAllByNombre(String nombre) {

		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, codigo FROM video WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 500;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);

		) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				Video v = null;
				while (rs.next()) {
					try {
						v = new Video();
						v.setId(rs.getLong("id"));
						v.setNombre(rs.getString("nombre"));
						v.setCodigo(rs.getString("codigo"));
						listado.add(v);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} // while
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}
	
	//INSERTAR
	
public boolean insert( Video v) throws SQLException {
		
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

// ELIMINAR

public boolean eliminar( long id) throws SQLException {
	
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

//UPDATE

public boolean update(Video v) throws SQLException {
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


}