package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Rol;

@Repository
public class CombustibleDAO {
	// LOG
		private final static Logger LOG = Logger.getLogger(CombustibleDAO.class);
	
		private static final String SQL_GET_ALL="SELECT id, nombre FROM combustible ORDER BY id DESC;";
		private static final String SQL_GET_ALL_BY_ID="SELECT id, nombre FROM combustible WHERE id = ? ;";


		public ArrayList<Combustible> getAll() {

			ArrayList<Combustible> combustibles = new ArrayList<Combustible>();

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
					ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					Combustible combustible = new Combustible();
					combustible.setId(rs.getInt("id"));
					combustible.setNombre(rs.getString("nombre"));
					combustibles.add(combustible);
				} // end while

			} catch (Exception e) {
				LOG.debug(e);
			}

			return combustibles;
		}


}
