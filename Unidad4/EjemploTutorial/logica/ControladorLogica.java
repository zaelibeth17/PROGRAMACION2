package logica;

import persistencia.ControladorPersistencia;


public class ControladorLogica {
	//atributos
    private static ControladorLogica instancia;	//atributo Singleton
    private  AlumnosDAO alumnos;
        
    
    //constructor privado
    private ControladorLogica(){	
    	alumnos= new AlumnosDAO();
    }
    
    //Singleton metodo getInstancia
    public static ControladorLogica getInstancia(){
    	if (instancia==null)
    		instancia=new ControladorLogica();
    	return instancia;
	}

    
	
   
    public AlumnosDAO getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(AlumnosDAO alumnos) {
		this.alumnos = alumnos;
	}

	
	public void desconectarBD(){
    	
    	try{
    		ControladorPersistencia.getInstancia().getConexion().desconectar();
    	}catch(Exception e){
    		System.out.println("Error al intentar desconectar"+e.getMessage());
    	}
    }
}

