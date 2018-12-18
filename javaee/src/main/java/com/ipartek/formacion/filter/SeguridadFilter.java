package com.ipartek.formacion.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Usuario;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
public class SeguridadFilter implements Filter {



	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//castear y lo mismo con el response
		HttpServletRequest req = (HttpServletRequest)  request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Usuario uLogeado= (Usuario)session.getAttribute("usuario_logeado");
		
		if(uLogeado != null) {
			// Este linea deja pasar, se pone cuando se acaba de comprobar todo
			// o ha pasado perfectamente todas las comprobaciones del filtro
			chain.doFilter(request, response);
		}else {
			// redigir al login, poruqe el usuario se ha saltado el login o caduca la sesion
			//req.getContextPath() --> te devuelve la ruta principal
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
