package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.modelo.config.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Venta;

@Repository
public class VentaDAO {
	
	private static final String SQL_CREATE = "INSERT INTO venta (id_usuario, id_stock) VALUES (?, ?)";
	private static final String SQL_STOCK_DISPONIBLE = "SELECT stock.id FROM stock LEFT JOIN venta ON stock.id = venta.id_stock WHERE venta.id IS NULL AND preparado = 1 AND id_animal = ? ORDER BY stock.id ASC LIMIT 1;";
	
	
	/**
	 * Buscamos si existe stock disponible para un Animal
	 * @param idAnimal int identificador Animal
	 * @return -1 si no existe stock, idAnimal si existe, retorna el mas antiguo si existen varios
	 */
	public int stockDisponible( int idAnimal ) {
		int idStock = -1;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_STOCK_DISPONIBLE);) {
			
			pst.setInt(1, idAnimal);
			
			try( ResultSet rs = pst.executeQuery() ){
				if(rs.next()) {
					idStock = rs.getInt("id");
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return idStock;
	}
	
	public boolean insert(Venta venta , int idStock) throws SQLException {
		boolean isCreado = false;		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);) {

			pst.setLong(1, venta.getIdUsuario());
			pst.setLong(2, idStock );

			if (pst.executeUpdate() == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						venta.setId(generatedKeys.getInt(1));
						isCreado = true;
						conn.commit();
					}
				}
			}
			else {
				conn.rollback();
			}
		}
	
		return isCreado;
	}
}
