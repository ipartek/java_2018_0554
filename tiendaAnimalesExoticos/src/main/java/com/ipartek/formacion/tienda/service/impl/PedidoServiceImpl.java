package com.ipartek.formacion.tienda.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.tienda.modelo.dao.ClienteDao;
import com.ipartek.formacion.tienda.modelo.dao.PedidoDao;
import com.ipartek.formacion.tienda.modelo.dao.StockDao;
import com.ipartek.formacion.tienda.modelo.pojo.Pedido;
import com.ipartek.formacion.tienda.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoDao pedidoDao;
	
	@Autowired
	StockDao stockDao;
	
	@Autowired
	ClienteDao clienteDao;
	
	@Override
	public boolean insert(Pedido pedido) {
		boolean resul = false;
		try {
			resul = pedidoDao.insert(pedido);
//			if (resul) {
//				pedido.setCompra(stockDao.detalle(pedido.getCompra().getId()));
//				//TODO hacer un trigger que salte cuando se introduce un nuevo pedido para que al comprar un animal el atributo vendido se asigne SI
//				pedido.setComprador(clienteDao.detalle(pedido.getComprador().getId()));
//
//			}
		} catch (SQLException e) {
			//Se captura la excepcion
			e.printStackTrace();
		}
		return resul;

	}

}
