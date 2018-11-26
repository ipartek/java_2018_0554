package com.ipartek.formacion.poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pruebas {

	public static void main(String[] args) {
//		< Java 7
//		BufferedReader br = null;
//		InputStreamReader isr = null;
//		
//		try {
//			isr = new InputStreamReader(System.in);
//			br = new BufferedReader(isr);
		//>= Java 7
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			//Scanner sc = new Scanner(System.in);
			
			// Usuario usuario; // = null;

			// usuario = new Usuario();

			System.out.println(Usuario.getContadorDeInstancias());

			boolean hayErrores;

			Usuario usuario1 = null;
			
			do {
				hayErrores = false;
				
				System.out.print("Email: ");
				String email = br.readLine(); //sc.nextLine();
				System.out.print("Contraseña: ");
				String contra = br.readLine(); //sc.nextLine();

				try {
					usuario1 = new Usuario(email, contra);
				} catch (UsuarioException e) {
					System.out.println("El usuario es incorrecto: " + e.getMessage());
					hayErrores = true;
				}
			} while (hayErrores);

			System.out.println(Usuario.getContadorDeInstancias());

			System.out.println(new Usuario().getEmail());

			System.out.println(Usuario.getContadorDeInstancias());

			Usuario usuario2 = new Usuario();

			System.out.println(Usuario.getContadorDeInstancias());

			usuario2.setEmail("javierleteñl@dskfj.asdf");
			usuario2.setPassword("contra");

			System.out.println(usuario2);

			System.out.println(usuario1.getEmail());
			System.out.println(usuario1.getPassword());

			usuario1.cambiarPassword("contra");

			System.out.println(usuario1.datosCompletos());
			System.out.println(usuario1.datosCompletos("coma"));
			System.out.println(usuario1.datosCompletos("corchetes"));
			
			//sc.close();
		} catch (IOException e) {
			System.out.println("Error al acceder al canal de entrada de consola");
			e.printStackTrace();
			return;
		} catch (Exception e) {
			System.out.println("Error no esperado");
			e.printStackTrace();
			return;
		}
		
//		< Java 7
//		finally {
//			if(br != null) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					System.out.println("Error al cerrar el canal de entrada de consola");
//					e.printStackTrace();
//				}
//			} else {
//				if(isr != null) {
//					try {
//						isr.close();
//					} catch (IOException e) {
//						System.out.println("Error en el cierre de InputStreamReader");
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		}
	}

}
