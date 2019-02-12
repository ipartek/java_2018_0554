package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.modelo.config.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Venta;

@Repository
public class VentaDAO {
	private static final String SQL_CREATE = "INSERT INTO venta (id_usuario, id_stock) VALUES (?, ?)";
	public boolean insert(Venta venta) throws SQLException {
		boolean isCreado = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);) {

			pst.setLong(1, venta.getUsuario().getId());
			pst.setLong(2, venta.getStock().getId());

			if (pst.executeUpdate() == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						venta.setId(generatedKeys.getInt(1));
						isCreado = true;
						conn.commit();
					}
				}
			}
			else {
				conn.rollback();
			}
		}
		return isCreado;
	}
}
