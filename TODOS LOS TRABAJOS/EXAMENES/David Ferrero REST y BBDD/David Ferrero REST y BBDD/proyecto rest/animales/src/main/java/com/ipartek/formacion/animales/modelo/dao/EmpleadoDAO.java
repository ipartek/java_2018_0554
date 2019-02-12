package com.ipartek.formacion.animales.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.animales.modelo.config.ConnectionManager;
import com.ipartek.formacion.animales.modelo.pojo.Empleado;
import com.ipartek.formacion.animales.modelo.pojo.Stock;
import com.mysql.jdbc.Connection;

@Repository
public class EmpleadoDAO {

	private static final String SQL_GET_EMPLEADO_BY_ID = "SELECT e.id , e.nombre, e.apellidos, e.dni, e.telefono, e.email, e.id_departamento  FROM animales.compra as c, animales.Empleado as e WHERE c.id_empleado= e.id and c.id=?;";

	public Empleado getByIdEmpleado(int idEmpleado) {

		Empleado empleado = null;

		try (Connection conn = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_EMPLEADO_BY_ID);) {

			pst.setInt(1, idEmpleado);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				empleado = new Empleado();
				empleado.setId(rs.getInt("id"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getString("apellidos"));
				empleado.setDni(rs.getString("dni"));
				empleado.setTelefono(rs.getString("telefono"));
				empleado.setEmail(rs.getString("email"));
				empleado.setIdDepartamento(rs.getInt("id_departamento"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return empleado;
	}

}