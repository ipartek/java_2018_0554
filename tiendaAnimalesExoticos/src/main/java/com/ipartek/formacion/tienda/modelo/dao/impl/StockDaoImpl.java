package com.ipartek.formacion.tienda.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelo.config.ConnectionManager;
import com.ipartek.formacion.tienda.modelo.dao.StockDao;
import com.ipartek.formacion.tienda.modelo.pojo.Animal;
import com.ipartek.formacion.tienda.modelo.pojo.Dieta;
import com.ipartek.formacion.tienda.modelo.pojo.Stock;
import com.ipartek.formacion.tienda.modelo.pojo.TipoAnimal;

@Repository
public class StockDaoImpl implements StockDao {

	//

	private static final String SQL_GET_BY_ID = "SELECT s.id AS 'id_stock',s.preparacion, s.vendido,a.id AS 'id_animal',a.nombre AS 'Nombre Especie',a.peso,a.precio,d.id AS 'id_dieta',d.nombre,t.id AS 'id_tipo',t.nombre AS 'tipo_alimentacion'"
			+ "FROM stock AS s INNER JOIN animal AS a ON s.id_animal = a.id "
			+ "INNER JOIN tipo_animal AS t ON a.id_tipo_animal = t.id "
			+ "INNER JOIN dieta AS d ON a.id_dieta = d.id WHERE s.id  =?;";

	@Override
	public Stock detalle(int idStock) {
		Stock s = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, idStock);
			try (ResultSet rs = pst.executeQuery()) {
				s = rowMapper(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	private Stock rowMapper(ResultSet rs) throws SQLException {
		Stock s = null;
		s.setId(rs.getInt("id_stock"));
		s.setPreparado(rs.getBoolean("preparacion"));
		s.setVendido(rs.getString("vendido"));

		Animal a = new Animal();
		a.setId(rs.getInt("id_animal"));
		a.setNombre(rs.getString("Nombre_especie"));
		a.setPeso(rs.getDouble("peso"));
		a.setPrecio(rs.getDouble("precio"));

		Dieta d = new Dieta();
		d.setId(rs.getInt("id_dieta"));
		d.setNombre(rs.getString("nombre"));
		a.setDieta(d);

		TipoAnimal t = new TipoAnimal();
		t.setId(rs.getInt("id_tipo"));
		t.setNombre(rs.getString("tipo_alimentacion"));
		a.setTipoAnimal(t);

		s.setAnimalComprado(a);

		return s;
	}

}
