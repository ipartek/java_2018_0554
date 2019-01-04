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

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.dao.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(VideosController.class);

	private static final String VIEW_INDEX = "principal.jsp";
	private static final String VIEW_FORM = "form-video.jsp";
	private String vista;

	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
	public static final String OP_ELIMINAR = "4";


	// parametros
	private String op;
	private String id;
	private String nombre;
	private String codigo;
	private String idUsuario;

	private static VideoDAO daoVideo = null;
	private static UsuarioDAO daoUsuario = null;

	private ValidatorFactory factory;
	private Validator validator;
	
	private Alerta alerta;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoVideo = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
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

		vista = VIEW_INDEX;
		alerta = null;
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

		} catch (Exception e) {
			LOG.error(e);
			alerta = new Alerta("danger","Error inesperado, sentimos las molestias");

			

		} finally {
			// mensaje para el usuario
			// ir a una vista
			if(alerta!=null) {
				request.setAttribute("alerta", alerta);
			}
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		idUsuario = request.getParameter("idUsuario");

		LOG.debug(String.format("parametros: op=%s id=%s nombre=%s codigo=%s", op, id, nombre, codigo));

	}
	private void listar(HttpServletRequest request) {

		// alerta = "Lista de Usuarios";
		request.setAttribute("videos", daoVideo.getAll());

	}

	private void eliminar(HttpServletRequest request) throws SQLException {

		int identificador = Integer.parseInt(id);

		if (daoVideo.delete(identificador)) {
			alerta = new Alerta("warning","Registro eliminado");


		} else {
			alerta = new Alerta("danger","Registro no eliminado");

		}
		
		listar(request);

	}

	private void guardar(HttpServletRequest request) throws SQLException {
		
		Video v = new Video();
		int identificador = Integer.parseInt(id);
		int idUsu = Integer.parseInt(idUsuario);
		
		v.setId((long) identificador);
		v.setNombre(nombre);
		v.setCodigo(codigo);
		
		Usuario u = new Usuario();
		u.setId((long)idUsu);
		
		v.setUsuario(u);

		// validar
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		if (violations.isEmpty()) {
			// Si validacion correcta
			// Comprobar si existe
			try {
				if (identificador > 0) {
//	    			UPDATE DE USUARIO

					daoVideo.update(v);

				} else {
//	    			INSERT DE NUEVO Video

					daoVideo.insert(v);
				}
				listar(request);
			} catch (SQLException e) {
				alerta = new Alerta("warning","El video introducido ya existe");

				vista = VIEW_FORM;
				request.setAttribute("video", v);
				request.setAttribute("usuarios", daoUsuario.getAll());
			}
		}
		// si validacion no correcta
		else {
			alerta = new Alerta("danger","El formato del nombre o url no cumplen el formato requerido");
			// volver al formulario, cuidado que no se pierdan los valores en el form
			vista = VIEW_FORM;
			request.setAttribute("video", v);
			request.setAttribute("usuarios", daoUsuario.getAll());

		}

	}

	private void irFormulario(HttpServletRequest request) {

		vista = VIEW_FORM;
		Video v = new Video();
		
		int identificador = Integer.parseInt(id);
		if (identificador > 0) {
			v = daoVideo.getById(identificador);

//			
//			u.setId((long)identificador);
//			u.setEmail(email);
//			u.setPassword(password);

		} else {
			alerta = new Alerta("info","Crear nuevo video");

		}

		request.setAttribute("video", v);
		request.setAttribute("usuarios", daoUsuario.getAll());
	}



}
