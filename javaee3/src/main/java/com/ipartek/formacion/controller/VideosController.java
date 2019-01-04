package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.ipartek.formacion.modelo.pojo.Mensaje;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;
import com.ipartek.formacion.modelos.daos.UsuarioDAO;
import com.ipartek.formacion.modelos.daos.VideosDAO;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class VideosController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(VideosController.class);
    
    
	private static final String VIEW_INDEX="video/index.jsp";
	private static final String VIEW_FORM="video/form.jsp";
	private String vista;
	private static final String OP_LISTAR="1";
	private static final String OP_IR_FORMULARIO="2";
	private static final String OP_GUARDAR="3"; //id == -1 insert, id> 1 update
	private static final String OP_ELIMINAR="4";
	
	private ValidatorFactory factory;
	private Validator validator;
	
	private Mensaje mensaje;
	//parametros a recibir
	private String op;
	private String id;
	private String nombre;
	private String codigo;
	private String id_usuario;
	
	
	private VideosDAO dao = null;
	private UsuarioDAO daoUsuario = null;
	
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = VideosDAO.getInstance();
		daoUsuario= UsuarioDAO.getInstance();
		
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vista = VIEW_INDEX;
		mensaje= new Mensaje();
		
		try {
			//recoger parametros
			getParameters(request);
			
			//Mirar la op para saber que operacion hacer mediante un switch
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
			mensaje = new Mensaje(Mensaje.TIPO_DANGER, "Error Inexperado, sentimos las molestias");
		}finally {
			//redirigir a vista
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}
	
	private void eliminar(HttpServletRequest request) throws SQLException  {
		try {
			Long identificador = Long.parseLong(id);
			if(dao.eliminar(identificador)) {
				//Si se a eliminado correctamente entra aqui
				mensaje =new Mensaje(Mensaje.TIPO_SUCCESS,"Registro eliminado correctamente");

			}else {
				//si no aqui
				mensaje =new Mensaje(Mensaje.TIPO_WARNING,"El registro no se ha eliminado correctamente");

			}
		}finally {
			listar(request);
		}
		
	}

	private void guardar(HttpServletRequest request)  {
		Video v  = new Video();
		int identificador = Integer.parseInt(id);	
		
		v.setNombre(nombre);
		v.setCodigo(codigo);
		
		//TODO validar POJO
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		
		if(violations.size() > 0) {//Validacon no correcta
			mensaje = new Mensaje( Mensaje.TIPO_WARNING, "Los campos introducidos no son correctos, por favor intentalo de nuevo");		 
			  vista = VIEW_FORM; 
			  // volver al formulario, cuidado que no se pierdan los valores en el form
			  request.setAttribute("video", v);
			  request.setAttribute("usuarios", daoUsuario.getAll());
			
		}else { // validacion correcta
			try {
				Usuario usuarioSeleccionado = daoUsuario.getById(Long.parseLong(id_usuario));
				v.setUsuario(usuarioSeleccionado);
				if(identificador>0) {
					mensaje =new Mensaje(Mensaje.TIPO_PRIMARY,"Update de un video");
					v.setId( (long)identificador);
					dao.update(v);
				}else {
					//TODO CORREGIR porque pone el id -1
					dao.insert(v);
					mensaje =new Mensaje(Mensaje.TIPO_SUCCESS,"Se ha creado el nuevo video correctamente");
				}
				
				vista= VIEW_INDEX;
			}catch (MySQLIntegrityConstraintViolationException e) {
				//Esto es para que el codigo del video no este duplicado y lanza una excepcion
				mensaje = new Mensaje(Mensaje.TIPO_WARNING,"Ese código ya esta registrado");
				request.setAttribute("video", v);
				request.setAttribute("usuarios", daoUsuario.getAll());
				vista = VIEW_FORM;
			}catch (Exception e) {
				mensaje =new Mensaje(Mensaje.TIPO_DANGER,"Error Inexperado");
				//alerta="Ha ocurrido un error inesperado";
				LOG.trace("Ha ocurrido un error inesperado: " + e);
				request.setAttribute("video", v);
				request.setAttribute("usuarios", daoUsuario.getAll());
				vista= VIEW_FORM;
			}
		}
		listar(request);
		
	}

	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		Video v = new Video();
		
		long idetificador =  Long.parseLong(id);
		if(idetificador > 0) {
			//Recoger y enviar los datos del video seleccionado
			v = dao.getById(idetificador);
		}else {
			LOG.trace("Crear un nuevo Video");
		}
		request.setAttribute("video", v);
		
		//TODO Enviar atributos usuarios
		ArrayList<Usuario> usuarios  =daoUsuario.getAll();
		request.setAttribute("usuarios", usuarios);
	}

	private void listar(HttpServletRequest request) {
		request.setAttribute("videos", dao.getAll());
		
	}

	/**
	 * Metodo que sirve para recoger todos los parametros que llegan por la request
	 * @param request
	 */
	private void getParameters(HttpServletRequest request) {
		op = request.getParameter("op");
		if(op==null) {
			op = OP_LISTAR;
		}
		id= request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo= request.getParameter("codigo");
		id_usuario=request.getParameter("id_usuario");
		
		LOG.debug(String.format("parametros: op=%s id =%s nombre=%s codigo=%s",op,id,nombre,codigo));

		
	}
	
	
	
}
