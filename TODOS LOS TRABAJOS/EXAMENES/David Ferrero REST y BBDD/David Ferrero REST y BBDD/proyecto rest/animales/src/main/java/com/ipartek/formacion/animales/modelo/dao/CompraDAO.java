package com.ipartek.formacion.animales.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.animales.modelo.config.ConnectionManager;
import com.ipartek.formacion.animales.modelo.pojo.Compra;

@Repository
public class CompraDAO {

	private static final String SQL_INSERT = "INSERT INTO animales.compra (id_stock, id_empleado, id_cliente) VALUES (?, ?, ?);";
											 
	
	private static final String SQL_DELETE = "DELETE FROM animales.compra WHERE id=?;";

	// ELIMINAR

	public boolean delete(int id) throws SQLException {
		boolean isDelete = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);
			if (pst.executeUpdate() == 1) {
				isDelete = true;
			}
		}
		return isDelete;
	}

	public boolean insert(Compra compra) throws SQLException {
		boolean isCreate = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setInt(1, compra.getStock().getId());
			pst.setInt(2, compra.getEmpleado().getId());
			pst.setInt(3, compra.getCliente().getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						compra.setId(generatedKeys.getInt(1));
					}
				}
				isCreate = true;
			}
		}
		return isCreate;
	}

}
