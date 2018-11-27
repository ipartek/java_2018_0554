package com.ipartek.formacion.ejemplocapas.presentacion;

import com.ipartek.formacion.biblioteca.Consola;
import com.ipartek.formacion.ejemplocapas.accesodatos.CrudAble;
import com.ipartek.formacion.ejemplocapas.accesodatos.UsuarioDaoArrayList;
import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class PresentacionConsola {
	public static void main(String[] args) {
		CrudAble<Usuario> usuarios = new UsuarioDaoArrayList();
		
		usuarios.insert(pedirUsuario());
		usuarios.update(new Usuario(1L, "javi@lete.com", "Lalaralalaaaa"));
		usuarios.delete(2L);
		
		for(Usuario usuario: usuarios.getAll()) {
			System.out.println(usuario);
		}
		
		System.out.println(usuarios.getById(1L));
		
		
		
		//Usuario usuario = pedirUsuario();
		
		//System.out.println(usuario);
	}

	private static Usuario pedirUsuario() {
		Long id = Consola.leerLong("ID");
		String email = Consola.leerLinea("Email");
		String password = Consola.leerLinea("Contraseña");

		Usuario usuario = new Usuario(id, email, password);
		return usuario;
	}
}
