package com.ipartek.formacion.tienda.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelo.config.ConnectionManager;
import com.ipartek.formacion.tienda.modelo.pojo.Venta;
import com.mysql.jdbc.Connection;

@Repository
public class VentaDAO {

	private static final String SQL_INSERT = "INSERT INTO venta (id_cliente, id_stock) VALUES (?, ?);";
	private static final String SQL_OBTENER_STOCK = "SELECT id from stock WHERE id_animal=? AND isListo=1;";

	/**
	 * Método para obtener el ID del Stock del animal indicado por el ID en el
	 * objeto <b>Venta</b>
	 * 
	 * @param venta Objeto <b>Venta</b> que contiene el ID del Cliente y el ID del
	 *              tipo de animal a comprar y a comprobar si existe en Stock
	 * @return <b>True</b> si existe Stock del animal indicado, <b>False</b> en caso
	 *         contrario
	 */
	public boolean obtenerStock(Venta venta) {
		boolean existe = false;

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_OBTENER_STOCK);) {
			pst.setInt(1, venta.getAnimal().getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				venta.getAnimal().setId(rs.getInt("id"));
				existe = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	/**
	 * Método para generar una <b>Venta</b> e insertarla en la BD
	 * 
	 * @param venta Objeto <b>Venta</b> a crear en la BD
	 * @return <b>True</b> si la inserción es correcta, <b>False</b> si no es
	 *         posible insertarlo
	 * @throws SQLException Si hay algún error con los datos
	 */
	public boolean insert(Venta venta) throws SQLException {

		boolean creado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			pst.setInt(1, venta.getPersona().getId());
			pst.setInt(2, venta.getAnimal().getId());
			if (pst.executeUpdate() == 1) {
				try (ResultSet idGenerado = pst.getGeneratedKeys();) {
					idGenerado.next();
					venta.setId((int) idGenerado.getLong(1));
					creado = true;
				}
			}
		}
		return creado;
	}

}
