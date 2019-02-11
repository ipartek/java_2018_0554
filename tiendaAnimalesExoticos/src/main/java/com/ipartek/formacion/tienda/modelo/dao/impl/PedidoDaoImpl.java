package com.ipartek.formacion.tienda.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelo.config.ConnectionManager;
import com.ipartek.formacion.tienda.modelo.dao.PedidoDao;
import com.ipartek.formacion.tienda.modelo.pojo.Pedido;

@Repository
public class PedidoDaoImpl implements PedidoDao {

	private static final String SQL_INSERT = "INSERT INTO pedido (id_cliente,id_stock) VALUES (?,?);";

	@Override
	public boolean insert(Pedido pedido) throws SQLException {

		boolean isCreate = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			pst.setInt(1, pedido.getComprador().getId());
			pst.setInt(2, pedido.getCompra().getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						pedido.setId(generatedKeys.getInt(1));
						isCreate = true;
					}
				}
			}

		}

		return isCreate;
	}

}
