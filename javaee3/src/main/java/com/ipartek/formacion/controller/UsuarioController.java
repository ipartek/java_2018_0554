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
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Usuario;


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
	
	Alerta alerta;
	
	
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
		alerta=new Alerta();
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
			alerta.setMensaje(e.toString());
			alerta.setTipo(alerta.KO);
		} finally {
			//mensaje usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
	
	}
	private void listar(HttpServletRequest request) {
		try {
			request.setAttribute("usuarios", dao.getAll());
		} catch (SQLException e) {
			alerta.setMensaje(e.toString());
			alerta.setTipo(alerta.KO);
		}
		
	}
	private void eliminar(HttpServletRequest request) throws SQLException {
		int ident=Integer.parseInt(id);		
		if(ident>0) {
			if(dao.delete(ident)) {
				alerta.setMensaje("Eliminado con éxito");
				alerta.setTipo(alerta.OK);
				listar(request);
			}else {
				alerta.setMensaje("No se pudo eliminar el usuario");
				alerta.setTipo(alerta.KO);
				vista=VIEW_FORM;
				
			}
		}else {
			alerta.setMensaje("No se encontro usuario");
			alerta.setTipo(alerta.KO);
			vista=VIEW_FORM;
		}
	}

	private void guardar(HttpServletRequest request) {
		Usuario u = new Usuario();
		int ident=Integer.parseInt(id);
		u.setId((long) ident);
		u.setEmail(email);
		u.setPassword(password);
		
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		
		if(violations.size()>0) {
			alerta.setMensaje("Los datos proporcionados no son correctos");
			alerta.setTipo(alerta.KO);
			request.setAttribute("usuario", u);
			vista=VIEW_FORM;
		}else {
			try {
				if(ident>0) {
					dao.update(u) ;
					
					
				}else {
					dao.insert(u) ;
				}
				alerta.setMensaje("Guardado con éxito");
				alerta.setTipo(alerta.OK);
				listar(request);
					
				
			} catch (SQLException e) {
				
				LOG.debug(e);
				
				alerta.setMensaje("El usuario ya existe");
				alerta.setTipo(alerta.KO);
				request.setAttribute("usuario", u);
				vista=VIEW_FORM;
			}
		}
		
	}

	private void irFormulario (HttpServletRequest request) {
		vista= VIEW_FORM;
		Usuario u;
		
		int ident=Integer.parseInt(id);
		try {
			if(ident>0) {
				u= dao.getById(ident);
			}else {
				u= new Usuario();
			}
			request.setAttribute("usuario", u);
		} catch (SQLException e) {
			alerta.setMensaje(e.toString());
			alerta.setTipo(alerta.KO);
		}
		
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
