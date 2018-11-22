package com.ipartek.formacion.poo;

public class UsuarioExtendidoPruebas {
	public static void main(String[] args) {
		UsuarioExtendido ue = new UsuarioExtendido("Nuevo Nuevito");
		
		System.out.println(ue.datosCompletos());
		
		ue.setNombre("Nuevo Nuevez");
		ue.setEmail("nuevo@nuevez.es");
		ue.setPassword("yepa");
		
		System.out.println(ue.datosCompletos("corchetes"));
		System.out.println(ue.datosCompletos());
		
		Usuario u = ue;
		
		//u.setNombre("laksjdflkadsj"); // No se puede llamar a setNombre
		
		UsuarioExtendido ue2 = (UsuarioExtendido) u;
		
		System.out.println(ue2.getNombre());
		
		Oficina o = new Oficina("Usando Herencia");
		
		o.nuevoUsuario(new Usuario("pepe@adsfs", "contraseñaz"));
		o.nuevoUsuario(ue);
		
		for(Usuario usuario: o.getUsuarios()) {
			System.out.println(usuario.datosCompletos());

			if(usuario instanceof UsuarioExtendido) {
				//System.out.println(((UsuarioExtendido)usuario).getNombre());
				
				UsuarioExtendido usuarioExtendido = (UsuarioExtendido)usuario;
				String nombre = usuarioExtendido.getNombre();
				System.out.println(nombre);
			}
		}
		
		Object objeto = ue;
		
		System.out.println(objeto.getClass().getName());
		System.out.println(objeto.toString());
		
		Usuario u1 = new Usuario("a@", "c");
		Usuario u2 = new Usuario("a@", "c");
		
		System.out.println(u1.equals(u2));
		
		System.out.println(u1);
		
		Usuario usuarioABorrar = new Usuario("pepe@adsfs", "contraseñaz");
		
		o.eliminarUsuario(usuarioABorrar);
		
		for(Usuario usuario: o.getUsuarios()) {
			System.out.println("El usuario es " + usuario);
		}
	}
}
