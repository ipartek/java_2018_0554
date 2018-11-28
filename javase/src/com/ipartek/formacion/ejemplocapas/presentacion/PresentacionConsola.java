package com.ipartek.formacion.ejemplocapas.presentacion;

import java.util.ArrayList;

import com.ipartek.formacion.biblioteca.Consola;
import com.ipartek.formacion.ejemplocapas.accesodatos.CrudAble;
import com.ipartek.formacion.ejemplocapas.accesodatos.UsuarioDaoArrayList;
import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class PresentacionConsola {
	public static void main(String[] args) {
		//System.out.println("C:\\nuevos\\trabajos");
		//SIN CAPA DE ACCESO DATOS
		ArrayList<Usuario> users = new ArrayList<>();
		
		users.add(pedirUsuario());
		
		for(Usuario usuario: users) {
			System.out.println(usuario);
		}
		
		//CON CAPA DE ACCESO DATOS
		CrudAble<Usuario> usuarios = new UsuarioDaoArrayList();

		usuarios.insert(pedirUsuario());
		usuarios.update(new Usuario(1L, "javi@lete.com", "Contraseña1A!"));
		usuarios.delete(2L);

		for (Usuario usuario : usuarios.getAll()) {
			System.out.println(usuario);
		}

		System.out.println(usuarios.getById(1L));
	}

	private static Usuario pedirUsuario() {
		Usuario usuario = new Usuario();

		usuario.setId(Consola.leerLong("ID"));
		
		boolean errorEmail;

		do {
			errorEmail = false;
			
			try {
				usuario.setEmail(Consola.leerLinea("Email"));
			} catch (Exception e) {
				errorEmail = true;
				System.out.println(e.getMessage());
			}
		} while (errorEmail);
		
		boolean errorPassword;
		
		do {
			errorPassword = false;
			
			try {
				usuario.setPassword(Consola.leerLinea("Contraseña"));
			} catch (Exception e) {
				errorPassword = true;
				System.out.println(e.getMessage());
			}
			
		} while(errorPassword);
		

		return usuario;
	}
}
