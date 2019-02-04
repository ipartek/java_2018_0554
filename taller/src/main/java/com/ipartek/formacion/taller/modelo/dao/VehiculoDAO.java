package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.appMultas.modelo.dao.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

@Repository
public class VehiculoDAO {
	
	private static final String SQL_GET_ALL_BY_PERSONA_ID="SELECT v.numero_bastidor as 'numero_bastidor', v.matricula as 'matricula', c.nombre as 'combustible', m.nombre as 'modelo' from vehiculo as v INNER JOIN combustible as c ON v.id_combustible = c.id INNER JOIN modelo as m ON v.id_modelo = m.id WHERE v.id_propietario=? ORDER BY v.id DESC LIMIT 1000;";

	public ArrayList<Vehiculo> getAllByPersonaId(int idPersona){
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_PERSONA_ID);
				) {
			pst.setInt(1, idPersona);
			try(ResultSet rs = pst.executeQuery();){
			while (rs.next()) {
				
				//TODO Obtener todos los vehiculos y almacenarlos en el arraylist

			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehiculos;
	}
	
}
