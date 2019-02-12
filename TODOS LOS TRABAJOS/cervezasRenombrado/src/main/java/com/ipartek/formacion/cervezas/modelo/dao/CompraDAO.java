package com.ipartek.formacion.cervezas.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.cervezas.modelo.config.ConnectionManager;
import com.ipartek.formacion.cervezas.modelo.pojo.Cerveza;
import com.ipartek.formacion.cervezas.modelo.pojo.Compra;
import com.ipartek.formacion.cervezas.modelo.pojo.Tipo;

@Repository
public class CompraDAO  {

	private static final String SQL_INSERT = "INSERT INTO cervezas.compra (cantidad, id_tipo, id_cliente) VALUES (?, ?, ?);";
	private static final String SQL_DELETE = "DELETE FROM cervezas.compra WHERE id=?;";	


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
			
			
			pst.setInt(1, compra.getCantidad());
			
			pst.setInt(2, compra.getTipo().getId());
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
	
	

