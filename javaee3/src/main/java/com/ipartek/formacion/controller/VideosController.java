package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class VideosController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
private final static Logger LOG = Logger.getLogger(VideosController.class);
	
	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	private String vista;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
	public static final String OP_ELIMINAR = "4";
	
	private String alerta = "";
	
	//parametros	
		private String op;
		private String id;
		private String nombre;
		private String codigo;
		
		private static VideoDAO dao = null;

       
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	dao = VideoDAO.getInstance();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		vista = VIEW_INDEX;
		alerta = "";
		try {
			// recoger parametros
			getParametros(request);
			// realizar operacion
			switch (op) {
				case OP_IR_FORMULARIO:
					irFormulario(request);
					break;
				case OP_GUARDAR:
					guardar(request);
					break;	
				case OP_ELIMINAR:
					eliminar(request);
					break;	
				default:
					listar(request);
					break;
			}
			
			
		}catch (Exception e) {
			LOG.error(e);		
			alerta = "Error inexperado, sentimos las molestias";
			
		}finally {
			// mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}
	
	
	private void listar(HttpServletRequest request) {

		// alerta = "Lista de Usuarios";
		request.setAttribute("videos", dao.getAll());		
		
	}


	private void eliminar(HttpServletRequest request) throws SQLException {
	
		int identificador = Integer.parseInt(id);		
		
		if ( dao.delete(identificador) ) {
			alerta = "Registro eliminado con exito";
		}else {
			alerta = "Registro NO eliminado, sentimos las molestias";
		}
				
		listar(request);		
	}


	private void guardar(HttpServletRequest request) throws SQLException {

		Video v = new Video();
		int identificador = Integer.parseInt(id);
		// u.setId((long)identificador);
		v.setNombre(nombre);
		v.setCodigo(codigo);
		
		//TODO validar POJO
		
		//si validacion no correcta
		   
		  // alerta al usuario
		
		  // volver al formulario, cuidado que no se pierdan los valores en el form
		
		
		// Si validacion correcta
			if ( identificador > 0 ) {
				alerta = "UPDATE Video ";
				// TODO dao.update	
				
			}else {
				alerta = "Crear un nuevo Video";
				dao.insert(v);
			}
		
			listar(request);
		
		
	}


	private void irFormulario(HttpServletRequest request) {
		
		vista = VIEW_FORM; 
		Video v = new Video();
		
		int identificador = Integer.parseInt(id);
		if ( identificador > 0 ) {			
			v = dao.getById(identificador);
		}else {
			alerta = "Crear un nuevo Usuario";
		}
		
		request.setAttribute("video", v);		
	}

	
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		
		LOG.debug( String.format("parametros: op=%s id=%s nombre=%s codigo=%s", op, id, nombre, codigo ));
		
	}
}

	

