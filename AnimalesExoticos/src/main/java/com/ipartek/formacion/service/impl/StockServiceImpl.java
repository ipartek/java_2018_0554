package com.ipartek.formacion.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.service.StockService;
import com.ipartek.formacion.modelo.dao.StockDAO;
import com.ipartek.formacion.modelo.pojo.Stock;


@Service("stockService")
public class StockServiceImpl implements StockService {
	@Autowired
	StockDAO daoStock;
	
	public ArrayList<Stock> listar() {
		return (ArrayList<Stock>) daoStock.getAll();
	}
}
