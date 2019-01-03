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
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuarioController.class);

	private static final String VIEW_INDEX = "usuarios.jsp";
	private static final String VIEW_FORM = "form.jsp";
	private String vista;

	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
	public static final String OP_ELIMINAR = "4";

	private String alerta = "";

	// parametros
	private String op;
	private String id;
	private String email;
	private String password;

	private static UsuarioDAO dao = null;

	private ValidatorFactory factory;
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
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

		} catch (Exception e) {
			LOG.error(e);
			alerta = "Error inexperado, sentimos las molestias";

		} finally {
			// mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	private void listar(HttpServletRequest request) {

		// alerta = "Lista de Usuarios";
		request.setAttribute("usuarios", dao.getAll());

	}

	private void eliminar(HttpServletRequest request) throws SQLException {
		int identificador = Integer.parseInt(id);

		if (dao.delete(identificador)) {
			alerta = "Registro eliminado";
		} else {
			alerta = "Registro no eliminado";
		}

		listar(request);

	}

	private void guardar(HttpServletRequest request) throws SQLException {

		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);

		u.setId((long) identificador);
		u.setEmail(email);
		u.setPassword(password);

		// validar
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		if (violations.isEmpty()) {
			// Si validacion correcta
			// Comprobar si existe
			try {
				if (identificador > 0) {
//	    			UPDATE DE USUARIO

					dao.update(u);

				} else {
//	    			INSERT DE NUEVO USUARIO

					dao.insert(u);
				}

				listar(request);
			} catch (SQLException e) {
				alerta = "El email ya existe en la bbdd";
				vista = VIEW_FORM;
				request.setAttribute("usuario", u);
			}
		}
		// si validacion no correcta
		else {

			// alerta al usuario
			alerta = "Los datos no corresponden al formato exigido";

			// volver al formulario, cuidado que no se pierdan los valores en el form
			vista = VIEW_FORM;
			request.setAttribute("usuario", u);

		}

	}

	private void irFormulario(HttpServletRequest request) {

		vista = VIEW_FORM;
		Usuario u = new Usuario();

		int identificador = Integer.parseInt(id);
		if (identificador > 0) {
			u = dao.getById(identificador);

//			
//			u.setId((long)identificador);
//			u.setEmail(email);
//			u.setPassword(password);

		} else {
			alerta = "Crear un nuevo Usuario";
		}

		request.setAttribute("usuario", u);
	}

	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		id = request.getParameter("id");
		email = request.getParameter("email");
		password = request.getParameter("password");

		LOG.debug(String.format("parametros: op=%s id=%s email=%s password=%s", op, id, email, password));

	}

}
