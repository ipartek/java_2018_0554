package com.ipartek.formacion.controller;

import java.io.IOException;
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

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;
	private  final static Logger LOG=Logger.getLogger(UsuarioController.class);

	private static final String VIEW_INDEX = "usuarios/index.jsp";
	private static final String VIEW_FORM = "usuarios/form.jsp";
	private String vista;

	private static final String OP_LISTAR = "1";
	private static final String OP_IR_FORMULARIO = "2";
	private static final String OP_GUARDAR = "3"; // id==-1 insert id>0 update
	private static final String OP_ELIMINAR = "4";
	
	private String alerta="";
	
	//parametros
	
	private String id;
	private String op;
	private String email;
	private String password;

	private static UsuarioDAO dao = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
		dao = UsuarioDAO.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vista=VIEW_INDEX;
		try {
		
			// recoger poaramentros
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
			// realizar operacion
			// enviar atributos
			
		}catch (Exception e){
			LOG.error(e);
			alerta="Error inesperado";
		} finally {
			//mensaje usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
	
	}
	private void listar(HttpServletRequest request) {
		alerta="Lista de usuarios";
		request.setAttribute("usuarios", dao.getAll());
		
	}
	private void eliminar(HttpServletRequest request) {
		int ident=Integer.parseInt(id);
		if(ident>0) {
			//borrar

			//getbyid
		}else {
			//error y vuelta
		}
	}

	private void guardar(HttpServletRequest request) {
		Usuario u = new Usuario();
		int ident=Integer.parseInt(id);
		u.setEmail(email);
		u.setPassword(password);
		vista=VIEW_INDEX;
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		
		if(violations.size()>0) {
			alerta="Los datos proporcionados no son correctos";
			vista=VIEW_FORM;
		}else {
			try {
				if(ident>0) {
					if(dao.update(u)) {
						vista=VIEW_INDEX;
					}else {
						alerta="El correo ya existe";
						vista=VIEW_FORM;
					}
				}else {
					if(dao.insert(u)) {
						vista=VIEW_INDEX;
					}else {
						alerta="El correo ya existe";
						vista=VIEW_FORM;
					}
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}

	private void irFormulario (HttpServletRequest request) {
		vista= VIEW_FORM;
		Usuario u;
		
		int ident=Integer.parseInt(id);
		if(ident>0) {
			u= dao.getById(ident);
		}else {
			u= new Usuario();
		}
		request.setAttribute("usuario", u);
		
	}

	private void getParametros(HttpServletRequest request) {
		op=request.getParameter("op");
		
		if(op==null) {
			op=OP_LISTAR;
		}
		id=request.getParameter("id");
		email=request.getParameter("email");
		password=request.getParameter("password");
		
		LOG.debug(String.format("parametros: op=%s id=%s  email=%s  password=%s", op, id,email,password));
	}

}
