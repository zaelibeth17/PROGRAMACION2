package logica;

public class ControladorLogica {
	//atributos
    private  ListaAlumnos colAlumnos;
    private static ControladorLogica instancia;	//atributo Singleton
    
    //constructor privado
    private ControladorLogica(){	
    	colAlumnos=new ListaAlumnos();
    }
    
    //Singleton metodo getInstancia
    public static ControladorLogica getInstancia(){
    	if (instancia==null)
    		instancia=new ControladorLogica();
    	return instancia;
	}

	
    // Agrego el Alumno a la coleccion.
    public  void agregarAlumno(Alumno a) {
       
        colAlumnos.agregar(a);
    }
    
    //retorna la lista de alumnos  
    public  ListaAlumnos devolverAlumnos() {
        return (colAlumnos);
    } 
    
     
}

