package com.ipartek.formacion.poo;

public class Pruebas {

	public static void main(String[] args) {
		//Usuario usuario; // = null;
		
		//usuario = new Usuario();
		
		System.out.println(Usuario.getContadorDeInstancias());
		
		Usuario usuario1 = new Usuario("javierlete@email.net", "contraseña");
		
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
	}

}
