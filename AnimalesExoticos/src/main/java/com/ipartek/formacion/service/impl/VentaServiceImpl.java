package com.ipartek.formacion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.service.VentaService;
import com.ipartek.formacion.modelo.dao.StockDAO;
import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.dao.VentaDAO;
import com.ipartek.formacion.modelo.pojo.Venta;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {
//	private static final Logger LOG = Logger.getLogger(VentaServiceImpl.class);
	@Autowired
	VentaDAO daoVenta;
	
	@Autowired
	UsuarioDAO daoUsuario;
	
	@Autowired
	StockDAO daoStock;

	public boolean crear(Venta venta) {

		boolean r = false;

		try {
			if (daoVenta.insert(venta)) {
				venta.setStock(daoStock.getById(venta.getStock().getId()));
				venta.setUsuario(daoUsuario.getById(venta.getUsuario().getId()));
				r = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}
