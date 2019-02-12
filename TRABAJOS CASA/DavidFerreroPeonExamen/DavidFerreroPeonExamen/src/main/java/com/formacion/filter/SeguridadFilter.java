package com.formacion.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojo.LoginPojo;

// filtro para no poder saltarse el login utilizando una url 
// ejemplo: la app comienza en login.jsp(despues de la redireccion en index) para acceder a paginasView hay que introducir email y password correctos
// pero tb podriamos acceder poniendo la url 
//PARA ESTO SE USA EL FILTRO. PARA EVITAR EL ACCESO DE CUALQUIER MANERA QUE NO SEA INTRODUCIENDO LOS DATOS CORRECTOS

// Cambios.  Ruta login por paginaCB http://localhost:8080/javaee3Examen2017/loginpaginaCB  (sin filtro se podria acceder con esta url sin poner datos)
// Login POjo
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/privado/*" })
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
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		LoginPojo uLogeado = (LoginPojo)session.getAttribute("usuarios");
		
		if ( uLogeado != null ) {
			// contnia la peticion del usuario al servlet/jsp
			chain.doFilter(request, response);
		}else {
			// redigir al login, porque el usuario se ha saltado el login o caducada session
			res.sendRedirect( req.getContextPath() + "/login.jsp");
		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
