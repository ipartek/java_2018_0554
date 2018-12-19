package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelos.pojos.Carrito;

public class CarritoDAO {

	public ArrayList<Carrito> getAll() {
		return null;
	}

	/**
	 * 
	 * 
	 * @param id recibe el id del producto a comprar
	 * @return devuelve true si se ha realizado la actualizacion de la cantidad o la insercion de un elemento al carro 
	 * 		   devuelve false si no se ha realizado ninguna accion
	 * @throws SQLException si hay erorres de conexion
	 */

	public boolean agregaralcarro(int id) throws SQLException {
		boolean encontrado = false;
		String sql = "SELECT id,perro,cantidad FROM carrito_perros_Borja WHERE perro='" + id
				+ "' ORDER BY id LIMIT 500";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				int cantidad=rs.getInt("cantidad");
				cantidad +=1;
				String sql2 = "UPDATE carrito_perros_borja SET cantidad='"+cantidad+"' WHERE perro='" + id + "'";
				try (Connection conn2 = ConnectionManager.getConnection();
						PreparedStatement pst2 = conn2.prepareStatement(sql2);) {
					pst2.executeUpdate();
					encontrado = true;
					break;
				} catch (Exception e2) {
					e2.getStackTrace();
				}
			}
			if(!encontrado) {
				String sql3 = "INSERT INTO carrito_perros_borja VALUES perro='"+id+"', cantidad=1";
				try (Connection conn3 = ConnectionManager.getConnection();
						PreparedStatement pst3 = conn3.prepareStatement(sql3);) {
					pst3.executeUpdate();
					encontrado = true;
				} catch (Exception e3) {
					e3.getStackTrace();
				}
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return encontrado;

	}
}
