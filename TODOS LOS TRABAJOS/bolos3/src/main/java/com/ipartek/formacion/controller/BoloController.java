package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.Dao.BoloDAO;
import com.ipartek.formacion.pojo.Alerta;
import com.ipartek.formacion.pojo.Bolo;

@WebServlet("/bolo")
public class BoloController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// LOG
	private final static Logger LOG = Logger.getLogger(BoloController.class);  // mensajes por consola 
	

	private ValidatorFactory factory;   // para validar
	private Validator validator;// para validar



	// variables para recoger los parametros en rowmapper y para parseo
	public String id = "";	
	public Long idp = null;  // parseo
	
	public String fecha = "";	
	public String lugar = "";
	public String banda1 = "";
	public String banda2 = "";
	public String banda3 = "";
	
	public String idCrew = "";	
	public Long idpCrew = null;  // parseo
	
	public String info = "";
	
	
	// variables para redireccionar y fijar la operacion del switch
	public String redirect="a";
	public String op = "";
	
	// dao y objetos
	private BoloDAO boloDAO = null;
	Bolo bolo = null;
	Alerta alerta = null;

	// init para validator, dao , objetos y colecciones
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		boloDAO = BoloDAO.getInstance();
		bolo = new Bolo();
		alerta = new Alerta();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			getParametros(request); // recojo parametros
			// realizar operacion
			switch (op) {
			case "listar":
				listar(request);
				break;
			case "buscar":
				buscar(request);
				break;
			case "fecha":
				fecha(request);
				break;
			case "crear":
				crear(request);
				break;
			case "eliminar":
				eliminar(request);
				break;
		
			
			
			
			}

		} catch (Exception e) {
			LOG.debug("error catch logica");
			request.setAttribute("mensaje", "Algo a salido mal ");
		} finally {
			
			if (redirect.equals("a")) {				
				request.getRequestDispatcher("listar.jsp").forward(request, response);			
			
			}else  if (redirect.equals("b")) {
			request.getRequestDispatcher("buscar.jsp").forward(request, response);
			
			}else  if (redirect.equals("c")) {
				request.getRequestDispatcher("nuevo.jsp").forward(request, response);
				}
		}

	}// fin doproces

	private void getParametros(HttpServletRequest request) {								// metodo para recoger los parametros y guardarlos en variables
		// palabra parametros en un string
		id = request.getParameter("id");
		fecha =request.getParameter("fecha");
		lugar =request.getParameter("lugar");		
		banda1 =request.getParameter("banda1");
		banda2 =request.getParameter("banda2");
		banda3 =request.getParameter("banda3");		
		idCrew =request.getParameter("idCrew");
		info =request.getParameter("info");		
		op = request.getParameter("op");
	}

	private void listar(HttpServletRequest request) {  										// pide un array al dao y lo envia por request
		request.setAttribute("alerta", alerta); 
		request.setAttribute("bolos", boloDAO.getAll());  									// envio el array del DAO que añade elementos de la bbdd
		request.setAttribute("mensaje", "Aqui tienes el listado de bolos realiados");  		// mensajes BORRAR Y CAMBIAR por alerta
		alerta = new Alerta( Alerta.TIPO_SUCCESS, "LISTADO VERDE ");  						// alertas Tipo clase Alerta. en un parametro el tipo (color bootsrap) en el otro el texto de la alerta	
		redirect="a";  																		// redireccion a listar.jsp

	}
	
	// buscar por id
	private void buscar(HttpServletRequest request) { 										//  envia un ojeto bolo  /// busca en la base de datos el bolo con esa id . si lo encuentra el dao incluye los datos en un array que envia mediante un parametro boloBuscar
		Long idp = Long.parseLong(id); 														// como el parametro que recibo es un String parseo la id para poder incluirla al objeto bolo LONG
		bolo=boloDAO.getById(idp);
		request.setAttribute("boloBuscar", bolo);											// envio el objeto con los datos de la base de datos por el parametro
		request.setAttribute("mensaje", "Resultados de tu busqueda");
		alerta = new Alerta( Alerta.TIPO_WARNING, "resultados de tu busqueda AMARILLO ");
		request.setAttribute("alerta", alerta); 
		redirect="b";
	}

	// buscar por fecha
	private void fecha(HttpServletRequest request) {									    //  envia un Objeto bolo igual que buscar por id pero por fecha
		Long fechaparseo = Long.parseLong(fecha); 
		request.setAttribute("bolos", boloDAO.getByFecha(fechaparseo));
		request.setAttribute("mensaje", ("bolos realizados en : " + fecha));
		 alerta = new Alerta( Alerta.TIPO_PRIMARY, "bolos tipò AZUL");
		 request.setAttribute("alerta", alerta); 
	 
		redirect="a";
	}
	
	
	// crear bolo
	private void crear(HttpServletRequest request) {									 	// envia un objeto a la bbdd que se construye con los parametros que recibe de nuevo.jsp. RECIBE ID =1`para crear en lugar de modificar
																							
			Bolo b = new Bolo();
			Long idp = Long.parseLong(id);   												// parseo como el siguiente
			Long idpCrew = Long.parseLong(idCrew); 											// parseo del parametro de tipo String id  a idpCrew long
			
			b.setId(idp);																	// parametros para formar el objeto que se envia a la bbdd
			b.setLugar(lugar);
			b.setBanda1(banda1);
			b.setBanda2(banda2);
			b.setBanda3(banda3);
			b.setIdCrew(idpCrew);
			b.setInfo(info);
			
			
			//validar usuario		
			Set<ConstraintViolation<Bolo>> violations = validator.validate(b);				//	TODO comprobar validaciones
			
			
			if ( violations.size() > 0 ) {              									// validacion NO correcta muestra ensaje de error en los campos
			 
			  alerta = new Alerta( Alerta.TIPO_WARNING, "Los campos introduciodos no son correctos, por favor intentalo de nuevo");		 
			  redirect="c";
			  request.setAttribute("bolo", b);		  										// devuelve objeto bolo para no perder los datos ? 	PREGUNTAAAA
			  
			  
			}else {									 										 //  validacion correcta
			
				try {
					if ( idp > 0 ) { 														 // SI LA ID DEL FORMULARIO ES MAYOR QUE 1 ENTONCES ACTUALIZO/MODIFICO el bolo de la bbdd
						boloDAO.update(b);	
						request.setAttribute("mensaje", " modificado con exito");
						alerta = new Alerta( Alerta.TIPO_SUCCESS, "alerta vertde ACTUALIZADO con exito");
						request.setAttribute("alerta", alerta); 
				
					}else {																	// SI LA ID DEL FORMULARIO ES -1 SE CREA UN NUEVO BOLO. LA BBDD devuelve la ID con la que crea el nuevo objeto 
						boloDAO.crear(b);
						request.setAttribute("mensaje", " guardado con exito");
						alerta = new Alerta( Alerta.TIPO_DANGER, "alerta ROJA CREADO  con exito");
						request.setAttribute("alerta", alerta); 
					
					}
					
					listar(request);
					
				}catch ( SQLException e) {
					alerta = new Alerta( Alerta.TIPO_WARNING, "fallo ");
					request.setAttribute("alerta", alerta); 
					redirect="a";
					  request.setAttribute("bolo", b);	
					//request.setAttribute("usuarios", daoUsuario.getAll() );
				}	
			}	
			
		}
	
	// buscar por fecha
	private void eliminar (HttpServletRequest request) throws SQLException {									   
		Long idp = Long.parseLong(id); 														// como el parametro que recibo es un String parseo la id para poder incluirla al objeto bolo LONG
		
		if (boloDAO.eliminar(idp)) {
			alerta = new Alerta( Alerta.TIPO_PRIMARY, "bolo eliminado con exito");
		}else {
			alerta = new Alerta( Alerta.TIPO_WARNING, "no se ha podido eliminar");
		}
		
	
		listar(request);

	}
	

}// fin
