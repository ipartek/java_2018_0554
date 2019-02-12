package com.ipartek.formacion.cervezas.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.cervezas.modelo.config.ConnectionManager;
import com.ipartek.formacion.cervezas.modelo.pojo.Tipo;
import com.mysql.jdbc.Connection;

@Repository
public class TipoDAO {

	private static final String SQL_GET_TIPOCERVEZA_BY_ID = "SELECT t.id , t.nombre   FROM cervezas.cerveza as c, cervezas.tipo as t WHERE c.id_tipo= t.id and c.id=?;";
	private static final String SQL_GET_TIPOCOMPRA_BY_ID = "SELECT t.id , t.nombre   FROM cervezas.compra as c, cervezas.tipo as t WHERE c.id_tipo= t.id and c.id=?;";
	
	
	public Tipo getByIdTipoCerveza(int idTipo) {

		Tipo tipo = null;

		try (Connection conn = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_TIPOCERVEZA_BY_ID);) {

			pst.setInt(1, idTipo);
		

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				tipo = rowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipo;
	}
	
	
	
	
	public Tipo getByIdTipoCompra(int idTipo) {

		Tipo tipo = null;

		try (Connection conn = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_TIPOCOMPRA_BY_ID);) {

			pst.setInt(1, idTipo);
		

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				tipo = rowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipo;
	}

	private Tipo rowMapper(ResultSet rs) throws SQLException {
		Tipo tipo = new Tipo();
		tipo.setId(rs.getInt("id"));
		tipo.setNombre(rs.getString("nombre"));

		return tipo;
	}

}
