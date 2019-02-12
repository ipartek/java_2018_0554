package com.ipartek.formacion.animales.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.animales.modelo.config.ConnectionManager;
import com.ipartek.formacion.animales.modelo.pojo.Stock;
import com.mysql.jdbc.Connection;

@Repository
public class StockDAO {

	private static final String SQL_GET_STOCK_BY_ID = "SELECT s.id , s.unidades, s.id_animal   FROM animales.compra as c, animales.stock as s WHERE c.id_stock= s.id and c.id=?;";

	public Stock getByIdStock(int idStock) {

		Stock stock = null;

		try (Connection conn = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_STOCK_BY_ID);) {

			pst.setInt(1, idStock);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				stock = new Stock();
				stock.setId(rs.getInt("id"));
				stock.setUnidades(rs.getInt("unidades"));
				stock.setIdAnimal(rs.getInt("id_animal"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stock;
	}

}
