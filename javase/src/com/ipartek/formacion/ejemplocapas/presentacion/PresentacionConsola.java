package com.ipartek.formacion.ejemplocapas.presentacion;

import com.ipartek.formacion.biblioteca.Consola;
import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class PresentacionConsola {
	public static void main(String[] args) {
		Long id = Consola.leerLong("ID");
		String email = Consola.leerLinea("Email");
		String password = Consola.leerLinea("Contraseña");

		Usuario usuario = new Usuario(id, email, password);
		
		System.out.println(usuario);
	}
}
