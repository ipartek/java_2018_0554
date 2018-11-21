package com.ipartek.formacion.poo;

public class OficinaPruebas {

	public static void main(String[] args) {
		Oficina oficina = new Oficina("Bilbao");
		
		Usuario usuario1 = new Usuario("javierlete@email.net", "contra");
		
		oficina.nuevoUsuario(usuario1);
		oficina.nuevoUsuario(new Usuario("pepe@email.net", "perez"));
		oficina.nuevoUsuario(new Usuario("juan@email.net", "original"));
		
		for(Usuario usuario: oficina.getUsuarios()) {
			//System.out.println(usuario.datosCompletos("corchetes"));
			System.out.println(usuario.getEmail());
		}
	}

}
