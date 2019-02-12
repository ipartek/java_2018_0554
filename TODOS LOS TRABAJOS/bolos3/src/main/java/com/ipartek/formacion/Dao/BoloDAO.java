package com.ipartek.formacion.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Bolo;


public class BoloDAO {

	// dao
	private static BoloDAO INSTANCE = null;
	
	// Variable para mensjaes por consola
	private final static Logger LOG = Logger.getLogger(BoloDAO.class);

	// consultas 
	private static final String SQL_GET_BY_ID = "SELECT id, fecha, lugar, banda1, banda2, banda3, info FROM apr_producciones.bolo WHERE id =?;";
	private static final String SQL_GET_BY_ALL = "SELECT * FROM bolo ORDER BY id DESC LIMIT 100";
	private static final String SQL_GET_BY_FECHA = "SELECT * FROM apr_producciones.bolo WHERE YEAR (fecha) =?;";
	private static final String SQL_INSERTAR= "INSERT INTO `apr_producciones`.`bolo` (`lugar`, `banda1`, `banda2`, `banda3`, `id_crew`, `info`) VALUES (?, ?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE= "UPDATE `apr_producciones`.`bolo` SET  `lugar` = ?, `banda1` = ?, `banda2` =?, `banda3` = ?, `info` = ? WHERE id = ?;"; 
	private static final String SQL_ELIMINAR= "DELETE FROM `apr_producciones`.`bolo` WHERE (`id` = ?);";
		
	

	// array list
	private static ArrayList bolos = null;

	// metodo constructor superclase
	private BoloDAO() {
		super();
	}

	// instance singleton
	public synchronized static BoloDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BoloDAO();

		}
		return INSTANCE;
	}

	// METODO ROWMAPPER PARA GUARDAR EN VARIABLES LOS ATRIBUTOS QUE RECIBE DE LA CONSULTA
	private Bolo rowMapper(ResultSet rs) throws SQLException {
		Bolo bolo = new Bolo(); // creo la palabra para incluir los resultados de la consulta
		bolo.setId(rs.getLong("id"));
		bolo.setFecha(rs.getDate("fecha"));
		bolo.setLugar(rs.getString("lugar"));
		bolo.setBanda1(rs.getString("banda1"));
		bolo.setBanda2(rs.getString("banda2"));
		bolo.setBanda3(rs.getString("banda3"));
		//bolo.setIdCrew(rs.getLong("idCrew"));   // TODO Me da error
		bolo.setInfo(rs.getString("info"));
	

		return bolo;
	}

	// METODO GETBYID PARA BUSCAR POR ID
	public Bolo getById(Long id) { 											// recibe una id y pide a la bbdd los datos del bolo que tenga esa id. 

		Bolo bolo = null; 

		String sql = SQL_GET_BY_ID; 

		try (Connection conn = ConnectionManager.getConnection(); 			// Establezco conexion
				PreparedStatement pst = conn.prepareStatement(sql);) { 		// creo objeto statement  con la consulta
			
			// parametros de entrada en la consulta
			pst.setLong(1, id);												// incluyo la id que recibe en la consulta

			try (ResultSet rs = pst.executeQuery()) { 						// ejecuto contulta mediante EXECUTECUERY PORQUE es una SELECT

				while (rs.next()) {											// RECORRE LA TABLA DE LA BBDD 
					bolo = rowMapper(rs);									// construye un objeto bolo con los ATRIBUTOS que recibe de la consulta

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bolo; 														// devuelve un objeto con los datos del bolo que ha encontrado en bbdd
	}


	// METODO GET ALL PARA LISTADO
	public ArrayList<Bolo> getAll() {										//NO RECIBE PARAMETRO

		ArrayList<Bolo> bolos = new ArrayList<Bolo>();  					// arrayList para  los datos que recibirá de la consulta

		try (Connection conn = ConnectionManager.getConnection();			
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ALL);

				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				bolos.add(rowMapper(rs));									// construyo un arrayList con todos los bolos mediante el metodo rowmapper 
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return bolos;
	}

	// METODO GETBYFECHA PARA OBTENER LOS BOLOS CON ESA FECHA
	public ArrayList<Bolo> getByFecha(Long fecha) {							// IGUAL QUE ANTERIOR PERO SOLO INCLUYE EN EL ARRAYLIST LOS BOLOS CUYA FECHA COINCIDE CON EL PARAMETRO

		ArrayList<Bolo> bolos = new ArrayList<Bolo>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_FECHA);){

			// parametros de entrada en la consulta
			pst.setLong(1, fecha);

					try (ResultSet rs = pst.executeQuery()) { // ejecuto contulta
			
						while (rs.next()) {

							bolos.add(rowMapper(rs));
						}
					}

		} catch (Exception e) {
			LOG.error(e);
		}
		return bolos;
	
	}
	
	

	// METODO CREAR PARA CREAR UN NUEVO BOLO EN LA BASE DE DATOS
	public boolean crear(Bolo b) throws SQLException {  															// RECIBE UN OBJETO CON LOS DATOS DE UN BOLO Y LOS INCLUYE EN LA BASE DE DATOS

		boolean resul = false;																						// boolean para PODER ENVIAR SI HA PODIDO INCLUIR EL OBJETO O NO
	
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS );) {  	// RETURN GENERATE KEYS PARA DEVOLVER ID??????? 
					
			// envio parametros de entrada a la consulta     														// NO ENVIO ID PORQUE YA LA TIENE Y DEBE SER NEGATIVA 
					
					pst.setString(1, b.getLugar() );
					pst.setString(2, b.getBanda1() );
					pst.setString(3, b.getBanda2() );
					pst.setString(4, b.getBanda3() );
					pst.setLong(5, b.getIdCrew() );
					pst.setString(6, b.getInfo() );
					//pst.setLong(3, b.getNombre().getId() ); para dos tabalas distintas
					
					
					int affectedRows = pst.executeUpdate(); 														// si incluye el objeto quiere decir que cambia una linea de la base de datos
					if (affectedRows == 1) {																		// si lo hace
						
						ResultSet rs = pst.getGeneratedKeys(); 														//  recoge id de la id con la que se ha creado en el objeto
						if (rs.next()) {
																													// RECOJO PARAMETROS DE ENTRADA
							long o_id  = rs.getLong(1);  //  para  devolver id						    
							b.setId(o_id);				     														// incluyo la id con la que se ha creado el bolo en una varible 
						}					
						resul = true;//																				// modifico la id del bolo -1 por la id con la que se ha creado el bolo
					}

				}
				return resul;    																					// DEVUELVE RESULTADO TRUE O FALSE EN FUNCIO DE SI HA PODIDO CREAR EL BOLO O NO

			}
	
	
	//METODO UPDTATE PARA ACTUALIZAR/MODIFICAR UN BOLO QUE YA  EXISTE EN LA BASE DE DATOS
	
	public boolean update(Bolo b) throws SQLException {							// RECIBE UN OBJETO CON LOS DATOS DEL BOLO QUE QUEREMOS ACUTALIZAR. 

		boolean resul = false;													// boolean para decidir si la ha actualizado o no 
		
		try (Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {
			
			// parametros  que incluyo en la consulta  // DE ENTRADA
			pst.setString(1, b.getLugar() );
			pst.setString(2, b.getBanda1() );
			pst.setString(3, b.getBanda2() );
			pst.setString(4, b.getBanda3() );
			//pst.setLong(5, b.getIdCrew() );
			pst.setString(5, b.getInfo() );
			pst.setLong(6, b.getId() );											//LA ID ES LA QUE INDICA EL BOLO QUE HAY QUE MODIFICAR
			
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul; 															// DEVUELVE RESULTADO TRUE O FALSE EN FUNCIO DE SI HA PODIDO CREAR EL BOLO O NO


	}
	
	public boolean eliminar (long id) throws SQLException { 											// recibe una id y pide a la bbdd los datos del bolo que tenga esa id. 

	boolean resul = false;													// boolean para decidir si la ha actualizado o no 
		
		try (Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(SQL_ELIMINAR);) {
			
		
			pst.setLong(1, id );											//LA ID ES LA QUE INDICA EL BOLO QUE HAY QUE MODIFICAR
			
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul; 
	}

	
	
}// fin multa dao