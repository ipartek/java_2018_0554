package com.ipartek.formacion.poo;

public class Pruebas {

	public static void main(String[] args) {
		//Usuario usuario; // = null;
		
		//usuario = new Usuario();
		
		Usuario usuario = new Usuario();
		
//		usuario.setEmail("javierleteñldskfj.asdf");
//		usuario.setPassword("contra");
		
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getPassword());
		
		usuario.cambiarPassword("contra");
		
		System.out.println(usuario.datosCompletos());
		System.out.println(usuario.datosCompletos("coma"));
		System.out.println(usuario.datosCompletos("corchetes"));
	}

}
