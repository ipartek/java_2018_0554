package com.ipartek.formacion.animales.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.animales.service.StockService;
import com.ipartek.formacion.modelo.pojo.Stock;

@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@RequestMapping(value = "/api/stock/", method = RequestMethod.GET)
	ResponseEntity<ArrayList<Stock>> listar() {
		ResponseEntity<ArrayList<Stock>> respuesta;
		respuesta = new ResponseEntity<ArrayList<Stock>>(HttpStatus.NOT_FOUND);
		try {
			ArrayList<Stock> stock = (ArrayList<Stock>) stockService.listar();
			if (!stock.isEmpty()) {
				respuesta = new ResponseEntity<ArrayList<Stock>>(stock, HttpStatus.OK);
			}
		} catch (Exception e) {
			respuesta = new ResponseEntity<ArrayList<Stock>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}
}
