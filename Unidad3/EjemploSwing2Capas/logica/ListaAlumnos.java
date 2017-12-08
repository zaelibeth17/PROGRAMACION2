package logica;

import java.util.ArrayList; 

public class ListaAlumnos { 

   private   ArrayList<Alumno> lista;

  //crea la lista de Alumno
   public ListaAlumnos(){ 
	   lista = new ArrayList(); 
   } 

    //Agrega un Alumno a la lista 
   public void agregar(Alumno a){ 
	   lista.add(a); 
   } 

     
   //dada una cedula elimina al Alumno de la lista
   public void borrar(int ced){ 
	   lista.remove(this.obtenerXCedula(ced)); 
   } 
   
   //retorna el alumno que esté en la posición i de la lista
   public Alumno devolver(int i){
	   return (lista.get(i));
	   
   }
   
   //devuelte true si ya existe un alumno con la cedula ced
   public boolean estaAlumno(int ced){
	   
	   boolean  esta=lista.contains(obtenerXCedula(ced));
	   return(esta);
   }
   
    //Busca un Alumno por la cedula, si no la encuentra retorna null 
   public Alumno obtenerXCedula(int cedula){ 
	   for (int i=0 ; i<lista.size() ; i++){
		   if (lista.get(i).getCedula() == cedula){
			  return lista.get(i); 
		   }
	   } 
	   return null; 
   } 
   
  
   @Override
   public String toString(){
		return ("Lista de Alumnos: "+lista);
	}
	
   //retorna el largo de la lista
   public int largo(){
	   int cant=0;
	   
	   if (this!=null)
		   cant=lista.size();
	   return cant;
		   
   }

   //retorna la lista	
   public  ArrayList<Alumno> getLista() {
	   return lista;
   }

} 
