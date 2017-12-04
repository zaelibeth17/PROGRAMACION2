package logica;

import java.util.Scanner;

import persistencia.ControladorPersistencia;

public class Principal {

	public static void main(String[] args) {
		/********prueba insertar en la BD**********/
		
		boolean ok1=false, ok2=false, resul;
		
    	Alumno a=new Alumno(400,"Elizabeth","juju","J");  //si prueba varias veces recordar cambiar valores
		ok1=ControladorLogica.getInstancia().getAlumnos().insertarAlumnoBD(a);
	    
        
		/******************prueba select***************/
		ListaAlumnos l=null;
		l=ControladorLogica.getInstancia().getAlumnos().recuperarAlumnos();
		System.out.println( l.getLista());
		
		/******************prueba delete***************/
		int ced;
		
		Scanner teclado=new Scanner(System.in);
		try{
			System.out.println("Ingrese cedula a eliminar: ");
			ced=teclado.nextInt();
			ok2=ControladorLogica.getInstancia().getAlumnos().eliminarAlumnoBD(ced);
			if (ok2==true)
				System.out.println("registro correctamente eliminado");
		}catch(NumberFormatException e){
			System.out.println("La cedula debe ser númerica ");
		}
		
		
	}//main	

}
