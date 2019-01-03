package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Disco;


public class DiscoDAO {
	
	private static DiscoDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance()
	private DiscoDAO() {
		super();
	}

	public synchronized static DiscoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new DiscoDAO();
		}
		return INSTANCE;
	}

	public Disco getById(long id) {

		Disco registro = null;
		String sql = "SELECT id, titulo, artista, portada, `year` FROM disco WHERE id= ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					registro = new Disco();
					registro.setId(rs.getLong("id"));
					registro.setTitulo(rs.getString("titulo"));
					registro.setArtista(rs.getString("artista"));
					registro.setPortada(rs.getString("portada"));
					registro.setYear(rs.getString("year"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return registro;
	}

	public ArrayList<Disco> getAll() {

		ArrayList<Disco> disco = new ArrayList<Disco>();
		String sql = "SELECT id, titulo, artista, portada, `year` FROM disco ORDER BY id DESC LIMIT 500;";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			Disco d = null;
			while (rs.next()) {
				try {
					d = new Disco();
					d.setId(rs.getLong("id"));
					d.setTitulo(rs.getString("titulo"));
					d.setArtista(rs.getString("artista"));
					disco.add(d);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return disco;
	}

	
	
	//INSERTAR
	
public boolean insert( Disco d) throws SQLException {
		
		boolean resul = false;
		String sql = "INSERT INTO `disco` (`titulo`, `artista`, `portada`, `year`) VALUES (?,?,?,?);";
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);				   
			){
			
			pst.setString(1, d.getTitulo());
			pst.setString(2, d.getArtista());
			pst.setString(3, d.getPortada());
			pst.setString(4, d.getYear());
			int affectedRows = pst.executeUpdate();
			if ( affectedRows == 1 ) {
				resul = true;
			}
			
		}
		return resul;
}

// ELIMINAR

public boolean eliminar( long id) throws SQLException {
	
	boolean resul = false;
	String sql = "DELETE FROM `disco` WHERE `id`=?;";
	try ( Connection conn = ConnectionManager.getConnection();
		  PreparedStatement pst = conn.prepareStatement(sql);				   
		){
		
		pst.setLong(1, id);			
		int affectedRows = pst.executeUpdate();
		if ( affectedRows == 1 ) {
			resul = true;
		}
		
	}
	return resul;
	
}

//UPDATE

public boolean update(Disco d) {
	boolean resul = false;
	String sql = "UPDATE disco SET titulo=?, artista=?, portada=?, year=? WHERE id=?;";
	try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

		pst.setString(1, d.getTitulo());
		pst.setString(2, d.getArtista());
		pst.setString(3, d.getPortada());
		pst.setString(4, d.getYear());
		pst.setLong(5, d.getId());

		int affectedRows = pst.executeUpdate();
		if (affectedRows == 1) {
			resul = true;
		}
	} catch (SQLException e) {
		
	}
	return resul;

}


}
