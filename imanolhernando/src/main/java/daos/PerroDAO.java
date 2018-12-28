package daos;

import java.util.ArrayList;

import pojos.Perro;
import pojos.Usuario;

public class PerroDAO {
private static PerroDAO INSTANCE = null;

	//CONSTRUCTOR PRIVADO SOLO ACCESO POR getInstance
	//PATRON SINGLETON
	private PerroDAO() {
		super();
	}
	
	
	public synchronized static PerroDAO getInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new PerroDAO();
        }
        return INSTANCE;
    }
	
	
/*LISTADO DE PERROS*/	

	public static ArrayList<Perro> getAll(){
		ArrayList<Perro> perros= new ArrayList<Perro>();	
		
		perros.add(new Perro("Perro1",1,"raza1",true,1111112018L, 43.257,-2.92344));
		perros.add(new Perro("Perro2",2,"raza2",true,2222222018L, 43.257,-2.92344));
		perros.add(new Perro("Perro3",3,"raza3",true,3333332018L, 43.257,-2.92344));
		perros.add(new Perro("Perro4",4,"raza4",true,4444442018L, 43.257,-2.92344));
		return perros;
	}
	
	
	public static Perro getByChip(Long chip){
		ArrayList<Perro> perros= new ArrayList<Perro>();
		Perro u= new Perro();
		u=null;
		perros= getAll();
		for(int i=0; i<perros.size();i++) {
			Long txip=perros.get(i).getChip();
			if(txip.equals(chip)) {
				u = (Perro)perros.get(i);
				
			}
		}
		return u;
	}
	
	
}
