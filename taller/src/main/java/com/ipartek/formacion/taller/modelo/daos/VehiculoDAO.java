package com.ipartek.formacion.taller.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Rol;

public class VehiculoDAO {

	//GET persona /{id}/vehiculo
private static final String SQL_GET_BY_ID = "Select m.id, p.id, m.nombre, p.nombre, v.matricula from persona as p, modelo as m, reparaciones as r, vehiculo as v where m.id=v.id_modelo and v.id_propietario=p.id;";

	
		
	ArrayList<Object> getAllByPersonaId( int idPersona ){
		return null;
	}
}
