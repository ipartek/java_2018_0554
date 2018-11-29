package com.ipartek.formacion.ejemplocapas.presentacion;

import java.util.ArrayList;

import com.ipartek.formacion.biblioteca.Consola;
import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class PresentacionConsola {
	private static ArrayList<Usuario> users = new ArrayList<>();
	
	public static void main(String[] args) {
		//System.out.println("C:\\nuevos\\trabajos");
		//SIN CAPA DE ACCESO DATOS
		String opcion;
		
		do {
			mostrarMenu();
			
			opcion = Consola.leerLinea("Dime qué opción quieres");
			
			procesarOpcion(opcion);
		}while (!"0".equals(opcion));
		
		//CON CAPA DE ACCESO DATOS
//		CrudAble<Usuario> usuarios = new UsuarioDaoArrayList();
//
//		usuarios.insert(pedirUsuario());
//		usuarios.update(new Usuario(1L, "javi@lete.com", "Contraseña1A!"));
//		usuarios.delete(2L);
//
//		for (Usuario usuario : usuarios.getAll()) {
//			System.out.println(usuario);
//		}
//
//		System.out.println(usuarios.getById(1L));
	}

	private static void procesarOpcion(String opcion) {
		switch(opcion) {
		case "0": System.out.println("Salir"); break;
		case "1": listado(); break;
		case "2": alta(); break;
		// TODO: Otras opciones
		default: System.out.println("No existe esa opción");
		}
	}

	private static void mostrarMenu() {
		System.out.println("USUARIOS");
		System.out.println("--------");
		System.out.println("1. Listado");
		System.out.println("2. Alta");
		// TODO: Resto de opciones
		System.out.println("0. Salir");
	}

	private static void listado() {
		for(Usuario usuario: users) {
			System.out.println(usuario);
		}
	}

	private static void alta() {
		System.out.println("Alta");
		users.add(pedirUsuario());
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
