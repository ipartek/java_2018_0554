package com.ipartek.formacion.tienda.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelo.config.ConnectionManager;
import com.ipartek.formacion.tienda.modelo.dao.AnimalDao;
import com.ipartek.formacion.tienda.modelo.pojo.Animal;
import com.ipartek.formacion.tienda.modelo.pojo.Dieta;
import com.ipartek.formacion.tienda.modelo.pojo.TipoAnimal;

@Repository
public class AnimalDaoImpl implements AnimalDao{

	
	private static final String SQL_GETALL="SELECT a.id AS 'id_animal',	a.nombre AS 'Nombre_Especie',a.peso,a.precio,d.id AS 'id_dieta', d.nombre, t.id AS 'id_tipo',t.nombre AS 'tipo_alimentacion'"
			+ "FROM animal AS a INNER JOIN tipo_animal AS t ON a.id_tipo_animal = t.id INNER JOIN dieta AS d ON a.id_dieta = d.id;";
	
	@Override
	public List<Animal> listar() {
		
		ArrayList<Animal> animales = new ArrayList<Animal>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				animales.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return animales;
		
		
	}

	@Override
	public Animal detalle(int idAnimal) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Metodo que setea todos los atributos de un animal, dieta y tipo incluido
	 * @param rs
	 * @return Animal construido correctamente
	 * @throws SQLException
	 */
	private Animal rowMapper(ResultSet rs) throws SQLException {
		Animal a = new Animal();
			a.setId(rs.getInt("id_animal"));
			a.setNombre(rs.getString("Nombre_especie"));
			a.setPeso(rs.getDouble("peso"));
			a.setPrecio(rs.getDouble("precio"));
			
			Dieta d = new Dieta();
				d.setId(rs.getInt("id_dieta"));
				d.setNombre(rs.getString("nombre"));
			a.setDieta(d);
			
			TipoAnimal t = new TipoAnimal();
				t.setId(rs.getInt("id_tipo"));
				t.setNombre(rs.getString("tipo_alimentacion"));
			a.setTipoAnimal(t);
			
		return a;
	}

}
