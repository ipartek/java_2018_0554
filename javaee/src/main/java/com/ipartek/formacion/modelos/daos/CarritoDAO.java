package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelos.pojos.Perro;

public class CarritoDAO {
	
	public ArrayList<Perro> getAll(){
		return null;
	}
	
	public ArrayList<Perro> agregaralcarro(){
		ArrayList<Perro> carrito= new ArrayList<Perro>();
		carrito= getAll();
		return carrito;
	}
}
