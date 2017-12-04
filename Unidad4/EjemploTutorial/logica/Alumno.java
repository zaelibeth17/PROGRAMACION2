package logica;

import java.util.Scanner;

public class Alumno extends Persona {

    private String grupo;
    
    public Alumno(){
    	
    }
    
    public Alumno(int cedula, String nombre, String apellido, String grupo) {
        super(cedula, nombre, apellido);
        this.grupo = grupo;
    }

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return  super.toString()+ ", grupo = " + grupo + "]";
	}
    
	@Override
	public void pedirDatos(){
	
		super.pedirDatos();
		//Scanner teclado=new Scanner(System.in);
		System.out.println("Ingrese grupo: ");
		this.setNombre("a");//teclado.next());
	}
}
