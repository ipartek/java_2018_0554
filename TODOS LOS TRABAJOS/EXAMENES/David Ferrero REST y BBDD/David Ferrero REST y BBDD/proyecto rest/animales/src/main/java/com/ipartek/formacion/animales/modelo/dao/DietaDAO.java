package com.ipartek.formacion.animales.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.animales.modelo.config.ConnectionManager;
import com.ipartek.formacion.animales.modelo.pojo.Dieta;
import com.mysql.jdbc.Connection;

@Repository
public class DietaDAO {

	private static final String SQL_GET_DIETA_ANIMAL_BY_ID = "SELECT t.id , t.nombre   FROM animales.animal as c, animales.dieta as t WHERE c.id_dieta= t.id and c.id=?;";
	private static final String SQL_GET_DIETA_COMPRA_BY_ID = "SELECT t.id , t.nombre   FROM animales.animal as c, animales.dieta as t WHERE c.id_dieta= t.id and c.id=?;";

	public Dieta getByIdDietaAnimal(int idDieta) {

		Dieta dieta = null;

		try (Connection conn = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_DIETA_ANIMAL_BY_ID);) {

			pst.setInt(1, idDieta);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				dieta = rowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dieta;
	}

	public Dieta getByIdDietaCompra(int idDieta) {

		Dieta dieta = null;

		try (Connection conn = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_DIETA_COMPRA_BY_ID);) {

			pst.setInt(1, idDieta);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				dieta = rowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dieta;
	}

	private Dieta rowMapper(ResultSet rs) throws SQLException {
		Dieta dieta = new Dieta();
		dieta.setId(rs.getInt("id"));
		dieta.setNombre(rs.getString("nombre"));

		return dieta;
	}

}