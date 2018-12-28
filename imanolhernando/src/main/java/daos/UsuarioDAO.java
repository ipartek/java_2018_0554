package daos;

import java.util.ArrayList;

import pojos.Usuario;

public class UsuarioDAO {
private static UsuarioDAO INSTANCE = null;
	
	//CONSTRUCTOR PRIVADO SOLO ACCESO POR getInstance
	//PATRON SINGLETON
	private UsuarioDAO() {
		super();
	}
	
	
	public synchronized static UsuarioDAO getInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new UsuarioDAO();
        }
        return INSTANCE;
    }
	
	
/*LISTADO DE TODOS LOS USUARIOS*/	

	public static ArrayList<Usuario> getAll(){
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		usuarios.add(new Usuario(1L,"scobby","galletas"));
		usuarios.add(new Usuario(2L,"dos@mail.com","Pa$$w0rd"));
		return usuarios;
	}

	public static Usuario login(String email, String password){
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		Usuario u= new Usuario();
		u=null;
		usuarios= getAll();
		for(int i=0; i<usuarios.size();i++) {
			if(email.equals(usuarios.get(i).getEmail()) && password.equals(usuarios.get(i).getPassword())) {
				u = (Usuario)usuarios.get(i);
				break;
			}
		}
		return u;
	}
/**/
	
	
}
