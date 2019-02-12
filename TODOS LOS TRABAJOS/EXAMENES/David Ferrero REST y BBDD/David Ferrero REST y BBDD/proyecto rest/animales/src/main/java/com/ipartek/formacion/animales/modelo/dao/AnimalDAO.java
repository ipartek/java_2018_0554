package com.ipartek.formacion.animales.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.animales.modelo.config.ConnectionManager;
import com.ipartek.formacion.animales.modelo.pojo.Animal;

@Repository
public class AnimalDAO {

	private static final String SQL_GET_ALL = "SELECT id, nombre, peso, precio, fecha_nacimiento, listo_venta, id_tipo, id_dieta FROM  animales.animal ORDER BY id DESC LIMIT 100;";
	private static final String SQL_GET_BY_ID = "SELECT id,nombre,peso,precio,fecha_nacimiento,listo_venta, id_tipo, id_dieta FROM animales.animal WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO animales.animal ( nombre, peso, precio, listo_venta, id_dieta, id_tipo) VALUES (?,?,?,?,?,?);";
	private static final String SQL_DELETE = "DELETE FROM animales.animal WHERE id=?;";
	private static final String SQL_UPDATE = "UPDATE animales.animal SET  nombre= ?, peso=?, precio=?,listo_venta=?, id_dieta=?, id_tipo=? WHERE id=?;";

// PARA METODO LISTAR (GETALL)
	public ArrayList<Animal> getAll() {
		ArrayList<Animal> lista = new ArrayList<Animal>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);

				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(mapeo(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

//  PARA METODO DETALLE PRECIO (GETBYID)

	public Animal getById(int id) {

		Animal a = null;
		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			// parametros de entrada en la consulta
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					a = mapeo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	// METODO PARA INSERTAR
	public boolean insert(Animal animal) throws SQLException {
		boolean isCreate = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, animal.getNombre());
			pst.setFloat(2, animal.getPeso());
			pst.setFloat(3, animal.getPrecio());
			pst.setBoolean(4, animal.isListoVenta());
			pst.setInt(5, animal.getDieta().getId());
			pst.setInt(6, animal.getTipo().getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						animal.setId(generatedKeys.getInt(1));
					}
				}
				isCreate = true;
			}
		}
		return isCreate;
	}

	// METODO MODIFICAR UPDATE
	// @Override
	public boolean update(Animal animal) throws SQLException {
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, animal.getNombre());
			pst.setFloat(2, animal.getPeso());
			pst.setFloat(3, animal.getPrecio());
			pst.setBoolean(4, animal.isListoVenta());
			pst.setInt(5, animal.getDieta().getId());
			pst.setInt(6, animal.getTipo().getId());
			pst.setInt(7, animal.getId());

			if (1 == pst.executeUpdate()) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	// MAPEO PARA GET,
	private Animal mapeo(ResultSet rs) throws SQLException {

		Animal a = new Animal();
		a.setId(rs.getInt("id"));
		a.setNombre(rs.getString("nombre"));
		a.setPrecio(rs.getFloat("precio"));
		a.setPeso(rs.getFloat("peso"));
		a.setFecha(rs.getDate("fecha_nacimiento"));
		a.setListoVenta(rs.getBoolean("listo_venta"));

		return a;
	}

}
