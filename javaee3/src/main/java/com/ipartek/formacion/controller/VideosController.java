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
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Mensaje;
import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.Video;

@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(VideosController.class);
	private ValidatorFactory factory;
	private Validator validator;
	
	// Objeto de mensaje de alerta
	private Mensaje mensaje;
	
	// Las vistas
	private String vista;
	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	
	// Opciones
	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert, id > 1 update
	public static final String OP_ELIMINAR = "4";
	
	// Atributos del vídeo
	private String id;
	private String nombre;
	private String codigo;
	private String id_usuario;
	// String que contiene la operacion
	private String op;
	
	// String de alerta donde se almacenan las alertas del validator del pojo
	private String alerta;
	
	VideoDAO daoVideo;
	UsuarioDAO daoUsuario;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		daoVideo = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vista = VIEW_INDEX;
		alerta = "";

		try {
			getParametros(request);
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
			mensaje = new Mensaje(mensaje.MENSAJE_DANGER, e.getMessage());
		} finally {
			// Mensaje para el usuario
			request.setAttribute("mensaje", mensaje);
			// Ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}
	
	private void guardar(HttpServletRequest request) {
		Video v = new Video();
		int identificador = Integer.parseInt(id);
		v.setNombre(nombre);
		v.setCodigo(codigo);
		v.setId((long) identificador);
		v.setUsuario(new Usuario(Long.parseLong(id_usuario)));
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		if (violations.isEmpty()) {
			try {
				if (identificador > 0) {
					daoVideo.update(v);
					mensaje = new Mensaje(mensaje.MENSAJE_SUCCESS, "Usuario actualizado");
				} else {
					daoVideo.insert(v);
					mensaje = new Mensaje(mensaje.MENSAJE_SUCCESS, "Usuario introducido");
				}
			} catch (SQLException e) {
				mensaje = new Mensaje(mensaje.MENSAJE_WARNING, "Lo sentimos pero el vídeo ya existe");
				request.setAttribute("video", v);
				request.setAttribute("usuarios", daoUsuario.getAll());
				vista = VIEW_FORM;
			}
		} else {
			alerta = "<ul class='list-unstyled'>";
			for (ConstraintViolation<Video> violation : violations) {

				alerta += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

			}
			alerta += "</ul>";
			vista = VIEW_FORM;
			mensaje = new Mensaje(mensaje.MENSAJE_DANGER, alerta);
			request.setAttribute("usuarios", daoUsuario.getAll());
			request.setAttribute("video", v);
		}
		listar(request);		
	}

	private void eliminar(HttpServletRequest request) throws SQLException {
		vista = VIEW_INDEX;
		int identificador = Integer.parseInt(id);
		if (daoVideo.delete((long) identificador)) {
			mensaje = new Mensaje(mensaje.MENSAJE_SUCCESS, "Vídeo eliminado");
		} else {
			Video v = new Video();
			v.setNombre(nombre);
			v.setCodigo(codigo);
			mensaje = new Mensaje(mensaje.MENSAJE_DANGER, "No se pudo eliminar el vídeo");
			request.setAttribute("video", v);
			vista = VIEW_FORM;
		}
		listar(request);
	}

	private void listar(HttpServletRequest request) {
		if ("0".equals(id)) {
			Usuario u = new Usuario();
			HttpSession session = request.getSession();
			u = (Usuario) session.getAttribute("usuarioLogueado");
			request.setAttribute("videos", daoVideo.getByUser(u));
			mensaje = new Mensaje(mensaje.MENSAJE_INFO, "Lista de tus vídeos");
		}
		else {
			request.setAttribute("videos", daoVideo.getAll());
			mensaje = new Mensaje(mensaje.MENSAJE_INFO, "Lista de videos");
		}
	}
	
	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		Video v = new Video();
		int identificador = Integer.parseInt(id);
		if (identificador > 0) {
			mensaje = new Mensaje(mensaje.MENSAJE_INFO, "Detalle de un vídeo");
			v = daoVideo.getById((long) identificador);
		} 
		else {
			mensaje = new Mensaje(mensaje.MENSAJE_INFO, "Registrar un nuevo vídeo");
		}
		request.setAttribute("video", v);
		request.setAttribute("usuarios", daoUsuario.getAll());
	}

	protected void getParametros(HttpServletRequest request) {
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");
		id_usuario = request.getParameter("id_usuario");

		LOG.debug(String.format("parametros: op=%s id=%s email=%s password=%s", op, id, nombre, codigo));
	}

}
