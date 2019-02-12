package com.ipartek.formacion.animales.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.animales.modelo.config.ConnectionManager;
import com.ipartek.formacion.animales.modelo.pojo.Cliente;

@Repository
public class ClienteDAO  {


	
	

	private static final String SQL_GET_CLIENTE_BY_ID = "SELECT cl.id , cl.nombre   FROM animales.compra as c, animales.cliente as cl WHERE c.id_cliente= cl.id and c.id=?;";

	public Cliente getByIdCliente(int idCliente) {

		Cliente cliente = null;

		try (Connection conn = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_CLIENTE_BY_ID);) {

			pst.setInt(1, idCliente);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				cliente = rowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}

	
	

	private Cliente rowMapper(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id"));
		cliente.setNombre(rs.getString("nombre"));

		return cliente;
	}
	
	
}