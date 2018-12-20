package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.modelo.pojos.Gato;

public class GatoDAO {
	
	public Gato getById(Long id) {
		
		/*private Long id;
	private String raza; 
	private String color;
	private String nombre;
	private Double peso;
	private String imagen;*/
		
		Gato registro = null;
		String sql = "SELECT id, raza, color, nombre, peso, imagen FROM gatos WHERE id= ?;";		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			){

			pst.setLong(1, id);

			try( ResultSet rs = pst.executeQuery() ){

				while(rs.next()) { 		
					registro = new Gato();
					registro.setId( rs.getLong("id"));
					registro.setRaza(rs.getString("raza"));
					registro.setColor(rs.getString("color"));
					registro.setNombre( rs.getString("nombre"));
					registro.setPeso(rs.getDouble("peso"));
					registro.setImagen(rs.getString("imagen"));
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}	


		return registro;
	}

}
