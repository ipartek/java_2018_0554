package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;

public interface MultaService {

	boolean insertar(Multa multa, int idCoche);
	
	ArrayList<Multa> listar(int idAgente);
	
	Coche conseguirId(String matricula);
	
}
