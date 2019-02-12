package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.modelo.config.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Usuario;

@Repository
public class UsuarioDAO {
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, apellidos, dni, telefono, email FROM usuario WHERE id = ?;";
	
	public Usuario getById(long id) {
		Usuario usuario = new Usuario();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				usuario = rowMapper(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	private Usuario rowMapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setApellidos(rs.getString("apellidos"));
		u.setDni(rs.getString("dni"));
		u.setTelefono(rs.getString("telefono"));
		u.setEmail(rs.getString("email"));
		return u;
	}
}
