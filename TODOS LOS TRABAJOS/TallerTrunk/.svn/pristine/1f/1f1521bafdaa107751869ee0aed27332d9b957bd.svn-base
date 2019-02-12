package com.ipartek.formacion.taller.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.mysql.jdbc.Connection;

@Repository
public class PersonaDAO implements IDAO<Persona> {
	private static final String SQL_GET_ALL = "SELECT id ,nombre,apellidos,dni,telefono FROM persona  ORDER BY id DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT id ,nombre,apellidos,dni,telefono FROM persona WHERE id=?;";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO persona (nombre,apellidos,dni,telefono) VALUES (?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre=?,apellidos=?,dni=?,telefono=? WHERE id=?;";
	private static final String SQL_GET_BY_VEHICULO_ID = "SELECT p.id,p.nombre,p.apellidos,p.dni,p.telefono FROM persona AS p INNER JOIN vehiculo AS v ON p.id=v.id_propietario WHERE v.id=?;";

	@Override
	public ArrayList<Persona> getAll() {
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				personas.add(RowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return personas;
	}

	@Override
	public Persona getById(int idPersona) {
		Persona persona = null;

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {

			pst.setInt(1, idPersona);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				persona = RowMapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return persona;
	}

	@Override
	public boolean delete(int idPersona) throws SQLException {
		boolean eliminado = false;

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, idPersona);

			if (pst.executeUpdate() == 1) {
				eliminado = true;
			}

		}
		return eliminado;
	}

	@Override
	public boolean insert(Persona persona) throws SQLException {

		boolean creado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellidos());
			pst.setString(3, persona.getDni());
			pst.setString(4, persona.getTelefono());

			if (pst.executeUpdate() == 1) {
				try (ResultSet idGenerado = pst.getGeneratedKeys();) {
					idGenerado.next();
					persona.setId((int) idGenerado.getLong(1));
					creado = true;
				}

			}

		}
		return creado;
	}
	
	
	public Persona getByVehiculoId(int idVehiculo) {
		Persona p = null;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_VEHICULO_ID);) {
			pst.setInt(1, idVehiculo);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					p = RowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	private Persona RowMapper(ResultSet rs) throws SQLException {
		Persona persona = new Persona();
		persona.setId(rs.getInt("id"));
		persona.setNombre(rs.getString("nombre"));
		persona.setApellidos(rs.getString("apellidos"));
		persona.setDni(rs.getString("dni"));
		persona.setTelefono(rs.getString("telefono"));
		return persona;
	}

	@Override
	public boolean update(Persona persona) throws SQLException {
		boolean modificado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellidos());
			pst.setString(3, persona.getDni());
			pst.setString(4, persona.getTelefono());
			pst.setInt(5, persona.getId());

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}

		}
		return modificado;
	}

}

//@Repository
//public class PersonaDAO {
//	private static final String SQL_GET_ALL="SELECT p.id as 'id_persona', p.nombre as 'nombre_persona', r.id as 'id_rol', r.nombre as 'nombre_rol' FROM persona as p, persona_has_rol as pr, rol as r WHERE p.id = pr.id_persona AND pr.id_rol = r.id ORDER BY p.id DESC LIMIT 1000;";
//
//
//	public HashMap<Integer, Persona> getAll() {
//
//		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer, Persona>();
//		try (Connection con = (Connection) ConnectionManager.getConnection();
//				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
//				ResultSet rs = pst.executeQuery();) {
//			while (rs.next()) {
//				int idPersona = rs.getInt("id_persona");
//				Persona persona = hmPersonas.get(idPersona);
//				// si no encuentro persona añado
//				if (persona == null) {
//					persona = new Persona();
//					persona.setId(idPersona);
//					persona.setNombre(rs.getString("nombre"));
//					// si encuentro persona recuperar y añadir rol
//				}
//				Rol rol = new Rol();
//				rol.setId(rs.getInt("id_rol"));
//				rol.setNombre(rs.getString("nombre_rol"));
//
//				ArrayList<Rol> roles = persona.getRoles();
//				roles.add(rol);
//				persona.setRoles(roles);
//
//				hmPersonas.put(idPersona, persona);
//			}
//
//		} catch (Exception e) {
//			
//		}
//		return hmPersonas;
//	}

//}
