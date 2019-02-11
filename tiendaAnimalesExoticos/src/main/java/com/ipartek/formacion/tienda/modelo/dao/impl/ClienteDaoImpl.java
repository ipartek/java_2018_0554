package com.ipartek.formacion.tienda.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelo.config.ConnectionManager;
import com.ipartek.formacion.tienda.modelo.dao.ClienteDao;
import com.ipartek.formacion.tienda.modelo.pojo.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	
	private static final String SQL_GET_BY_ID="SELECT id, nombre, apellidos,dni, tlfn FROM cliente WHERE id =?;";
	@Override
	public Cliente detalle(int idCliente) {
		Cliente c =null;
		
		
		
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);
			){
			pst.setInt(1, idCliente);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					c = rowMapper(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	private Cliente rowMapper(ResultSet rs) throws SQLException {
		Cliente c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNombre(rs.getString("nombre"));
			c.setApellidos(rs.getString("apellidos"));
			c.setDni(rs.getString("dni"));
			c.setTelefono(rs.getString("tlfn"));
			return c;
			
	}

}
