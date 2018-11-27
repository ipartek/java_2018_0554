package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class UsuarioDaoArrayList implements CrudAble<Usuario> { 
	private static final String NO_SE_ADMITE_USUARIOS_NULO = "No se admite usuarios nulo";
	private static final String YA_EXISTE_ESE_ID_DE_USUARIO = "Ya existe ese ID de usuario";
	private static final String YA_EXISTE_ESE_EMAIL = "Ya existe ese email";
	private static final String NO_EXISTE_ESE_ID = "No existe ese ID";
	
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}

	@Override
	public Usuario getById(Long id) {
		for(Usuario usuario: usuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		
		return null;
	}

	@Override
	public void insert(Usuario usuario) {
		if(usuario == null) {
			throw new AccesoDatosException(NO_SE_ADMITE_USUARIOS_NULO);
		}
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId() == usuario.getId()) {
				throw new AccesoDatosException(YA_EXISTE_ESE_ID_DE_USUARIO);
			}
			
			if(usuarios.get(i).getEmail().equals(usuario.getEmail())) {
				throw new AccesoDatosException(YA_EXISTE_ESE_EMAIL);
			}
		}
		
		usuarios.add(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		int posicionId = -1;
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId() == usuario.getId()) {
				posicionId = i;
			}
			
			if(usuarios.get(i).getEmail().equals(usuario.getEmail())) {
				throw new AccesoDatosException(YA_EXISTE_ESE_EMAIL);
			}
		}
		if(posicionId == -1) {
			throw new AccesoDatosException(NO_EXISTE_ESE_ID);
		}
		
		usuarios.set(posicionId, usuario);
	}

	@Override
	public void delete(Long id) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId() == id) {
				usuarios.remove(i);
			}
		}
		
		throw new AccesoDatosException(NO_EXISTE_ESE_ID);
	}
}
