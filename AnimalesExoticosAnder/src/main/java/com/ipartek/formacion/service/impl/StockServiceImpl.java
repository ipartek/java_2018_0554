package com.ipartek.formacion.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.service.StockService;
import com.ipartek.formacion.modelo.dao.StockDAO;
import com.ipartek.formacion.modelo.dao.VentaDAO;
import com.ipartek.formacion.modelo.pojo.Animal;
import com.ipartek.formacion.modelo.pojo.Venta;


@Service("stockService")
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockDAO daoStock;
	
	@Autowired
	VentaDAO ventaDAO;
	
	
	@Override
	public List<Animal> catalogo() {
		return (ArrayList<Animal>) daoStock.getAll();
	}

	@Override
	public boolean comprar(int idAnimal, int idUsuario) throws SQLException {
		
		boolean isVendiddo = false;
		
		// buscar disponibilidad de stock		
		int idStock = ventaDAO.stockDisponible(idAnimal);
		
		if ( idStock > -1 ) {            // realizar venta si hay stock
		
			Venta v = new Venta();
			v.setIdAnimal(idAnimal);
			v.setIdUsuario(idUsuario);
			
			if ( ventaDAO.insert(v, idStock) ) {
				isVendiddo = true;
			}
			
		}
		
		return isVendiddo;
	}
}
