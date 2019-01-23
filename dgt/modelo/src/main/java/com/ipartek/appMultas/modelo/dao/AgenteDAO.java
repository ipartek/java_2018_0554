package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Objetivo;

public class AgenteDAO {
	
	private final static String SQL_GETBYID = "{call agente_getById(?)}";
	private final static String SQL_LOGIN = "{call agente_login(?,?)}";
	private final static String SQL_OBJETIVOS_ANIO = "SELECT id_agente,anio,multasAsignadas,totalMultasAnual FROM v_objetivos_anio WHERE id_agente=? AND anio=?;";
	private final static String SQL_OBJETIVOS_MES = "SELECT id_agente,mes,anio,multasAsignadas,totalMultasMes FROM v_objetivos_mes WHERE id_agente=? AND mes=? AND anio=?;";
	private final static String SQL_OBJETIVOS_MESES_ANIO="SELECT id_agente,mes,anio,multasAsignadas,totalMultasMes FROM v_objetivos_mes WHERE id_agente=? AND anio=? ORDER BY mes ASC;";
	
	private final static Logger LOG = Logger.getLogger(AgenteDAO.class);
	private static AgenteDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance
	private AgenteDAO() {
		super();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static AgenteDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgenteDAO();
		}
		return INSTANCE;
	}
	/**
	 * Comprueba que la placa y la contraseña recibidos por parámetros coinciden en la BD.
	 * @param placa Nº de placa del agente.
	 * @param password Contraseña del agente.
	 * @return El objeto agente registrado en la BD. Retorna un agente nulo si los datos introducidos no son correctos.
	 */
	public Agente login(String placa, String password) {
		Agente a = null;

		String sql = SQL_LOGIN;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setString(1, placa);
			cs.setString(2, password);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					a = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return a;
	}

	/**
	 * Este metodo solamente devuelve el agente sin las multas
	 * 
	 * @param id Identificador del agente en la BD.
	 * @return Retorna el agente si existe en la BD.
	 */
	public Agente getByID(Long id) {
		Agente a = new Agente();

		String sql = SQL_GETBYID;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					a = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return a;
	}
	/**
	 * Consulta el objetivo anual actual de un agente concreto. 
	 * @param id_agente Identificador del agente (logueado)
	 * @param anio Año actual
	 * @return	Objeto de tipo objetivo con datos sobre el objetivo anual de dicho agente.  
	 */
	public Objetivo getObjetivosAnual(Long id_agente, Long anio) {
		Objetivo o = new Objetivo();
		String sql = SQL_OBJETIVOS_ANIO;
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			pst.setLong(2, anio);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					//Crear objeto Objetivo
					o.setAnio(rs.getDouble("anio"));
					o.setImporteTotal(rs.getDouble("totalMultasAnual"));		
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return o;
	}

	/**
	 * Consulta el objetivo mensual actual de un agente concreto. 
	 * @param id_agente Identificador del agente (logueado)
	 * @param anio Año actual
	 * @param mes Mes actual
	 * @return	Objeto de tipo objetivo con datos sobre el objetivo mensual del año actual de dicho agente.  
	 */
	public Objetivo getObjetivoMensual(Long id_agente, Long anio, Long mes) {
		Objetivo o = new Objetivo();
		String sql = SQL_OBJETIVOS_MES;
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			pst.setLong(2, mes);
			pst.setLong(3, anio);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					//Crear objeto Objetivo
					o.setAnio(rs.getDouble("anio"));
					o.setImporteTotal(rs.getDouble("totalMultasMes"));
				}
			}

		} catch (Exception e) {
			LOG.debug(e);
		}
		
		return o;
	}
	/**
	 * Obtiene de un año en concreto todos los meses con sus respectivos objetivos
	 * @param id_agente Identificador del agente (logueado)
	 * @param anio Año enviado por parámetro
	 * @return ArrayList de objetivos mensuales
	 */
	public ArrayList<Objetivo> getObjetivoMeses(Long id_agente, Long anio){
		ArrayList<Objetivo> objetivos = new ArrayList<Objetivo>();
		String sql = SQL_OBJETIVOS_MESES_ANIO;
		try(
			Connection conn= ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, id_agente);
			pst.setLong(2, anio);
			try(
				ResultSet rs = pst.executeQuery();
				){
				while(rs.next()) {
					Objetivo o = new Objetivo();
					//Crear objeto Objetivo
					o.setAnio(rs.getDouble("anio"));
					o.setImporteTotal(rs.getDouble("totalMultasMes"));
					switch (rs.getInt("mes")) {
					case 1:
						o.setMes("Enero");
						break;
					case 2:
						o.setMes("Febrero");
						break;
					case 3:
						o.setMes("Marzo");
						break;
					case 4:
						o.setMes("Abril");
						break;
					case 5:
						o.setMes("Mayo");
						break;
					case 6:
						o.setMes("Junio");
						break;
					case 7:
						o.setMes("Julio");
						break;
					case 8:
						o.setMes("Agosto");
						break;
					case 9:
						o.setMes("Septiembre");
						break;
					case 10:
						o.setMes("Octubre");
						break;
					case 11:
						o.setMes("Noviembre");
						break;
					case 12:
						o.setMes("Diciembre");
						break;
					default:
						o.setMes("Error en el mes");
					}
					//añadir objetivo al array
					objetivos.add(o);
				}
			}	
		}catch (Exception e) {
			LOG.debug(e);
		}
		return objetivos;
	}
	/**
	 * Obtiene el objetivo anual, mensual y los objetivos de un año en concreto y se los asigna al agente correspondiente 
	 * @param a Agente en sesión, es decir, logueado
	 * @return Retorna ese mismo agente recibido con los objetivos seteados.
	 */
	public Agente obtenerImportes(Agente a) {
		a.setAnual(getObjetivosAnual(a.getId(), (long) obtenerAnio()));
		a.setMensual(getObjetivoMensual(a.getId(), (long) obtenerAnio(),(long) obtenerMes()));
		// OBTENER TODOS LOS MESES DE UN AÑO ARRAYLIST OBJETIVOS
		// TODO Printar el array en el jsp
		//Se le pasaria el año que seleccionaria el agente por el select option, acutalmente le decimos que saque todos los meses del año actual
		a.setObjetivoMeses(getObjetivoMeses(a.getId(), (long) 2018));
		return a;
	}
	/**
	 * Obtiene el año actual.
	 * @return El año actual.
	 */
	private int obtenerAnio() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		LOG.debug("Año actual para la búsqueda de estadísticas: " + year);
		return year;
	}
	/**
	 * Obtiene el mes actual.
	 * @return El mes actual.
	 */
	private int obtenerMes() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		LOG.debug("Mes actual para la búsqueda de estadísticas: " + month + 1);
		return month + 1;
	}

	/**
	 * rowMapper del Agente sin añadirle el listado de multas que ha puesto
	 * @param rs ResultSet de la consulta realizada en la BD.
	 * @return El agente.
	 * @throws SQLException
	 */
	private Agente rowMapper(ResultSet rs) throws SQLException {
		Agente a = new Agente();
		a.setId(rs.getLong("id"));
		a.setNombre(rs.getString("nombre"));
		a.setPlaca(rs.getString("placa"));
		a.setId_departamento(rs.getLong("id_departamento"));
		return a;
	}

}
