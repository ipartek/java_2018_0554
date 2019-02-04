package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

@Repository
public class VehiculoDAO {
	// LOG
		private final static Logger LOG = Logger.getLogger(VehiculoDAO.class);

		private static final String SQL_GET_ALL_BY_ID=
"SELECT v.id AS 'id_vehiculo', v.numero_bastidor AS 'bastidor', v.matricula AS 'matricula', c.nombre AS 'combustible',  m.nombre AS 'modelo' FROM vehiculo AS v, combustible AS c, modelo AS m WHERE v.id_combustible = c.id AND v.id_modelo = m.id AND v.id_propietario = ?;";
					
	/**
	 * Obtener todos los vehiculos de una Persona(propetario)
	 * @param id_propietrio identifacador de la Persona
	 * @return  ArrayList<Vehiculo> con los vehiculos de esa Persona
	 */
		public ArrayList<Vehiculo> getAllByIdPropietario(int id_propietrio) {
			ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_ID);
					) {
				pst.setInt(1,id_propietrio);
				try(ResultSet rs = pst.executeQuery();){
					while (rs.next()) {
						Vehiculo vehiculo = new Vehiculo();
						vehiculo.setId(rs.getInt("id_vehiculo"));
						vehiculo.setBastidor(rs.getString("bastidor"));
						vehiculo.setMatricula(rs.getString("matricula"));	
						vehiculo.setCombustible(rs.getString("combustible"));	
						vehiculo.setModelo(rs.getString("modelo"));	
						vehiculos.add(vehiculo);
					}// end while
				}catch(SQLException e){
					LOG.debug(e);
				}
				

			} catch (Exception e) {
				LOG.debug(e);
			}

			return vehiculos;
		}
}
