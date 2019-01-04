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

import org.jboss.logging.Logger;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Alerta;
import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/privado/videos")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);

	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	private String vista;

	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id==-1 insert, id>0 update
	public static final String OP_ELIMINAR = "4";

	private Alerta alerta;

	// parametros
	private String op;
	private String id;
	private String nombre;
	private String codigo;

	private String id_usuario;

	private static VideoDAO daoVideo = null;
	private static UsuarioDAO daoUsuario = null;

	private ValidatorFactory factory;
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoVideo = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vista = VIEW_INDEX;
		// reseteamos alerta a vacio
		// alerta = "";
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

			// enviar atributos

		} catch (Exception e) {
			LOG.error(e);

			alerta = new Alerta(Alerta.TIPO_DANGER, "Error inesperado, sentimos las molestias"); // rojo
		} finally {

			// mensaje para el usuario
			request.setAttribute("alerta", alerta);

			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}

	}

	private void listar(HttpServletRequest request) {

		request.setAttribute("videos", daoVideo.getAll());
	}

	private void eliminar(HttpServletRequest request) throws SQLException {
		int identificador = Integer.parseInt(id);

		if (daoVideo.eliminar(identificador)) {
			alerta = new Alerta(Alerta.TIPO_SUCCESS, "Video eliminado con exito"); // verde
		} else {
			alerta = new Alerta(Alerta.TIPO_DANGER, "Video NO eliminado"); // rojo
		}
		listar(request);

	}

	private void guardar(HttpServletRequest request) {
		Video v = new Video();

		int identificador = Integer.parseInt(id);
		// crear usuario con los parametros
		v.setId((long) identificador);
		v.setNombre(nombre);
		v.setCodigo(codigo);

		Usuario u = new Usuario();
		u.setId(Long.parseLong(id_usuario));
		v.setUsuario(u);

		// validar usuario

		Set<ConstraintViolation<Video>> violations = validator.validate(v);

		// if(!violations.isEmpty())
		if (violations.size() > 0) { // si validacion NO correcta

			// alerta al usuario
			alerta = new Alerta(Alerta.TIPO_DANGER,
					"Los campos introducidos no son correctos, por favor intentelo de nuevo"); // rojo
			vista = VIEW_FORM;
			// volver al formulario, cuidado que no se pierdan los valores en el form
			request.setAttribute("videos", v);
			request.setAttribute("usuarios", daoUsuario.getAll());

		} else {// Si validacion correcta

			try {
				if (identificador > 0) {

					daoVideo.update(v);

				} else {
					daoVideo.insert(v);
				}
				alerta = new Alerta(Alerta.TIPO_SUCCESS, "Registro guardado con exito"); // verde
				listar(request);

			} catch (SQLException e) {
				alerta = new Alerta(Alerta.TIPO_WARNING, "Lo sentimos pero el VIDEO ya existe"); // warning
				vista = VIEW_FORM;
				request.setAttribute("video", v);
				request.setAttribute("usuarios", daoUsuario.getAll());
			}
		}

	}

	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		Video v = new Video();

		int identificador = Integer.parseInt(id);
		if (identificador > 0) {
			v = daoVideo.getById(identificador);
		}
		request.setAttribute("video", v);
		request.setAttribute("usuarios", daoUsuario.getAll());

	}

	private void getParametros(HttpServletRequest request) {
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		codigo = request.getParameter("codigo");

		id_usuario = request.getParameter("id_usuario");

		LOG.debug(String.format("parametros: op=%s id=%s nombre=%s codigo=%s ", op, id, nombre, codigo));

	}
}