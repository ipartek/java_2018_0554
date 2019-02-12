package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.modelo.config.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Animal;
import com.ipartek.formacion.modelo.pojo.Dieta;
import com.ipartek.formacion.modelo.pojo.Especie;
import com.ipartek.formacion.modelo.pojo.Stock;

@Repository
public class StockDAO {
	private static final String SQL_GET_ALL = "SELECT s.id, e.id 'id_especie', e.nombre 'especie', a.id 'id_animal', a.nombre 'animal', d.id 'id_dieta', d.nombre 'dieta', peso, precio FROM stock s, animal a, especie e, dieta d WHERE s.id_animal = a.id AND a.id_especie = e.id AND a.id_dieta = d.id AND preparado = 1 ORDER BY s.id LIMIT 100;";
	private static final String SQL_GET_BY_ID = "SELECT s.id, e.id 'id_especie', e.nombre 'especie', a.id 'id_animal', a.nombre 'animal', d.id 'id_dieta', d.nombre 'dieta', peso, precio FROM stock s, animal a, especie e, dieta d WHERE s.id_animal = a.id AND a.id_especie = e.id AND a.id_dieta = d.id AND s.id = ?;";
	
	public ArrayList<Stock> getAll() {
		ArrayList<Stock> lista = new ArrayList<Stock>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				lista.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Stock getById(long id) {
		Stock stock = new Stock();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				stock = rowMapper(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stock;
	}
	
	private Stock rowMapper(ResultSet rs) throws SQLException {
		Especie e = new Especie();
		e.setId(rs.getInt("id_especie"));
		e.setNombre(rs.getString("especie"));
		
		Dieta d = new Dieta();
		d.setId(rs.getInt("id_dieta"));
		d.setNombre(rs.getString("dieta"));
		
		Animal a = new Animal();
		a.setId(rs.getInt("id_animal"));
		a.setNombre(rs.getString("animal"));
		a.setPrecio(rs.getFloat("precio"));
		a.setEspecie(e);
		a.setDieta(d);
		
		Stock stock = new Stock();
		stock.setId(rs.getLong("id"));
		stock.setAnimal(a);
		stock.setPeso(rs.getFloat("peso"));
		return stock;
	}
}