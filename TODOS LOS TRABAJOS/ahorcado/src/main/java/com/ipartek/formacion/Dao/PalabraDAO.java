package com.ipartek.formacion.Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.Dao.ConnectionManager;

import com.ipartek.formacion.pojo.Palabra;





public class PalabraDAO {

	// dao
	private static PalabraDAO INSTANCE = null;
	
	// log 
	//private final static Logger LOG = Logger.getLogger(PalabraDAO.class);

	// consultas sql con parametros almacenados
	
	
	
	
	
	// metodo constructor superclase
	private PalabraDAO() {
		super();
	}

	// instance singleton
	public synchronized static PalabraDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PalabraDAO();
		}
		return INSTANCE;
	}



	
	
	
	public Palabra getPalabra(String letra1, String letra2) {

		Palabra palabra = null;  //declaro la palabra
		
		String sql = "SELECT id, letra1, letra2 FROM palabra where letra1= ? and letra2=?;"; //consulta
 
		try (Connection conn = ConnectionManager.getConnection(); //Establezco conexion
			PreparedStatement pst = conn.prepareStatement(sql);) { // creo objeto statement
			
			// parametros de entrada en la consulta
			pst.setString(1,letra1);
			pst.setString(2,letra2);
		
			try (ResultSet rs = pst.executeQuery()) { // ejecuto contulta 
				
				while (rs.next()) { 
					palabra = new Palabra(); //creo la palabra para incluir los resultados de la consulta 
					palabra.setId(rs.getLong("id"));
					palabra.setLetra1(rs.getString("letra1"));
					palabra.setLetra2(rs.getString("letra2"));
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return palabra;
	}
		
	public boolean update(Palabra p) throws SQLException {

		boolean resul = false;
		String sql = "UPDATE `palabra` SET id=1, letra1 = ? , letra2 = ? WHERE id = ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			
			pst.setString(1, p.getLetra1());
			pst.setString(2, p.getLetra2());
			pst.setLong(3, p.getId());
		
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
		
		
		
		
		
}// fin multa dao