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
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		Usuario uLogueado = (Usuario) session.getAttribute("usuario_logueado");
		
		if(uLogueado != null) {
		// continua la peticion del usuario al servlet/jsp
		chain.doFilter(request, response);
		}else {
			//redirigir al login, porque el usuario se ha saltado el login o ha caducado la sesion
			res.sendRedirect(req.getContextPath() + "/login");
		}
		
		//SACAR MENSAJE CUANDO ALGUIEN NO PASE EL FILTRO
		//EJERCICIO, CUANDO ALGUIEN SE SALTE EL FILTRO DE SEGURIDAD SACAR IP, ORDENADOR, E IDIOMA QUE UTILIZA
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
