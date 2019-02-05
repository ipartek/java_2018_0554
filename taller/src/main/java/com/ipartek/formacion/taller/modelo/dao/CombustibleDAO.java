package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;

@Repository
public class CombustibleDAO {

	private static final String SQL_GET_ALL="SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID="SELECT id, nombre FROM combustible WHERE id=?;";
	
	
	
	public ArrayList<Combustible> getAll(){
		ArrayList<Combustible> combustibles = new ArrayList<Combustible>();
		try(
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
			ResultSet rs = pst.executeQuery();
			){
			while(rs.next()) {
				combustibles.add(rowMapper(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return combustibles;
	}

	public Combustible getById(int idCombustible) {
		Combustible c =null;
		try(
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);
			){
				pst.setInt(1, idCombustible);
				try(ResultSet rs = pst.executeQuery();){
				while (rs.next()) {
					c= rowMapper(rs);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	

	private Combustible rowMapper(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
			c.setId(rs.getInt("id"));
			c.setNombreC(rs.getString("nombre"));
		return c;
	}
}
