package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelos.daos.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuarioController.class);
	
	private static final String VIEW_INDEX="usuario/index.jsp";
	private static final String VIEW_FORM="usuario/form.jsp";
	private String vista;
	private static final String OP_LISTAR="1";
	private static final String OP_IR_FORMULARIO="2";
	private static final String OP_GUARDAR="3"; //id == -1 insert, id> 1 update
	private static final String OP_ELIMINAR="4";
	
	private String alerta="";
	
	//parametros a recibir
	private String op;
	private String id;
	private String email;
	private String password;
	
    private static UsuarioDAO dao = null;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
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
		alerta="";
		try{
			
			//recoger parametros
			getParametros(request);
			//realizar operacion(lista, eliminar,crear,...)
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
			
			//enviar atributos 	
		}catch (Exception e) {
			LOG.error(e);
			alerta="Error inexperadom sentimos las molestias";
			
		}finally {
			//mensaje para el usuario
			request.setAttribute("alerta", alerta);
			//ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}

		
		
		
	}
	
	/**
	 * Metodo que manda el listado de todos los usuarios
	 * @param request
	 */
	private void listar(HttpServletRequest request) {
		//alerta="Lista de Usuarios";
		request.setAttribute("usuarios", dao.getAll());
	}

	private void eliminar(HttpServletRequest request) {
		
		
	}

	private void guardar(HttpServletRequest request) throws SQLException {
		Usuario u = new Usuario();
		int identificador = Integer.parseInt(id);
			//Al crear no hace falta poque la base de datos lo inserta automicamente
		u.setEmail(email);
		u.setPassword(password);
		
		//TODO validar POJO
		
		//Si valicion no correcta
			//alerta al usuario
		
			//volver al formulario, cuidado que no se pierdan los valores
		
		//Si validacion correcta
			if(identificador>0) {
				alerta="Update de un Usuario";
				//TODO dao.update
		
			}else {
				alerta="Crear un nuevo Usuario";
				dao.insert(u);
			}
		
			listar(request);
	}

	private void irFormulario(HttpServletRequest request) {
		vista = VIEW_FORM;
		Usuario u = new Usuario();
		
		int identificador = Integer.parseInt(id);
		if(identificador>0) {
			alerta="Detalle de un Usuario";
			//TODO llmar dao getById
			u.setId((long)identificador);
			u.setEmail("TODO llmar dao getById");
		}else {
			alerta="Crear un nuevo Usuario";
		}
		
		request.setAttribute("usuario", u);
		
	}

	/**
	 * Metodo que recoge todos los parametros enviados en la peticion
	 * @param request
	 */
	private void getParametros(HttpServletRequest request) {
		op =request.getParameter("op");
		if(op== null) {
			op=OP_LISTAR;
		}
		id= request.getParameter("id");
		email= request.getParameter("email");
		password= request.getParameter("password");
		
		LOG.debug(String.format("parametros: op=%s id =%s email=%s password=%s",op,id,email,password));
	}

}
