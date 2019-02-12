package com.ipartek.formacion.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojos.Objetivo;

public class ObjetivoDAO {

	// LOG PARA MENSAJES
		private final static Logger LOG = Logger.getLogger(AgenteDAO.class);
	
		private static ObjetivoDAO INSTANCE = null;
	
	
		//metodo constructor superclase
		private ObjetivoDAO() {
			super();
		}
		
		// instance/singleton
		public synchronized static ObjetivoDAO getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new ObjetivoDAO();
			}
			return INSTANCE;
		}
			

	private static final String SQL_MES_ACTUAL=
	"SELECT id_agente, fecha, numero_multas, importe FROM v_objetivos WHERE id_agente= ? AND mes = MONTH(now()) AND anyo=YEAR(now());";
	
	private static final String SQL_ANIO_ACTUAL=
	"SELECT id_agente, fecha ,  SUM(numero_multas) AS 'numero_multas', SUM(importe) AS 'importe' FROM v_objetivos WHERE id_agente= ?  AND anyo=YEAR(now());" ;
	
	private static final String SQL_HISTORICO_ACTUAL=
	"SELECT id_agente, fecha , numero_multas, importe FROM v_objetivos WHERE id_agente= ?    AND anyo=YEAR(now());" ;
	
	private static final String SQL_HISTORICO_SELECT=
			"SELECT id_agente, fecha , numero_multas, importe FROM v_objetivos WHERE id_agente= ?   AND anyo= ? order by fecha asc;";
			
	
	private static final String SQL_SELECT_ANIO=
	"SELECT DISTINCT anyo from v_objetivos WHERE id_agente= ? order by anyo desc;";
	
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4 AND mes = MONTH(now()) AND anyo=YEAR(now());
//	SELECT SUM(importe) AS 'importe', SUM(numero_multas) AS 'numero_multas' FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
//  SELECT DISTINCT anyo from v_objetivos WHERE id_agente=4;
	
	
	
	
	// row mapper para recoger parametros
		private Objetivo rowMapper(ResultSet rs) throws SQLException { 
			Objetivo registro = new Objetivo();
			registro.setId_agente(rs.getLong("id_agente"));
			registro.setFecha(rs.getDate("fecha"));
			registro.setNum_multas(rs.getInt("numero_multas"));
			registro.setImporte(rs.getFloat("importe"));	

			return registro;
		}
	
	
	public ArrayList<Integer> selectAnyo(Long id_agente) {
		String sql = SQL_SELECT_ANIO;
		Integer i = null;
		ArrayList<Integer> anios = new ArrayList<Integer>();
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					i =rs.getInt("anyo");
					anios.add(i);
					
				}
			}

		} catch (Exception e) {
			LOG.fatal("selecAnyo:---> " + e);
		}
		LOG.debug("selecAnyo OK");
		return anios;
	}
	
	public Integer ultimoAnio(ArrayList<Integer> anios) {
		Integer anio=0;
		Integer size=anios.size();
		for(int i=0; i<size;i++) {
			if(anio<anios.get(i)) {
			anio=anios.get(i);
			}
		}
		
		return anio;
	}
	
	
	public Objetivo objetivoActual(Long id_agente, Integer i) {
		String sql = SQL_MES_ACTUAL;
		
		if(i==1) {
		sql = SQL_MES_ACTUAL;
		}else if(i==2) {
			sql = SQL_ANIO_ACTUAL;
		}
		
		
		Objetivo o = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					o = new Objetivo();
					o = rowMapper(rs);	
					
				}
			}

		} catch (Exception e) {
			LOG.fatal("objetivoActual:---> " + e);
		}
		LOG.debug("objetivoActual OK");
		return o;
	}
	
	
			
	public ArrayList<Objetivo> historico(Long id_agente, Integer a) {
		String sql;
		if(a!=0) {
			sql = SQL_HISTORICO_SELECT;
		}else {
		sql = SQL_HISTORICO_ACTUAL;
		}
		ArrayList<Objetivo> objetivos = new ArrayList<Objetivo>();
		Objetivo o = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {
			if(a!=0) {
				pst.setLong(1, id_agente);
				pst.setInt(2, a);
			}else {
				pst.setLong(1, id_agente);
			}
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					o = new Objetivo();
					o = rowMapper(rs);
					objetivos.add(o);
					
				}
			}

		} catch (Exception e) {
			LOG.fatal("historico:---> " + e);
		}
		LOG.debug("historico OK");
		return objetivos;
	}
	
	
}
