package logica;

import persistencia.ControladorPersistencia;


public class AlumnosDAO {
	
    //constructor 
    public AlumnosDAO(){	
    	
    }
    
    
	
   public boolean insertarAlumnoBD(Alumno a){
    	boolean ok1=false, ok2=false, resul;
    	
    			
    	   	//preparo los datos necesarios para crear la sentencia a insertar en la tabla persona
  		   	String tabla1="persona";
	        String campos1="cedula, nombre, apellido";
	        String valores1=a.getCedula()+",'"+a.getNombre()+"','"+a.getApellido()+"'";
	        	       
	        //preparo los datos necesarios para crear la sentencia a insertar en la talba alumno	        
	  		String tabla2="alumno";
	        String campos2="cedula, grupo";
	        String valores2=a.getCedula()+",'"+a.getGrupo()+"'";
	        try{
		        //inserto en la tabla persona
		        ok1=ControladorPersistencia.getInstancia().insert(tabla1, campos1,valores1);
		        //inserto en la tabla alumno
		        ok2=ControladorPersistencia.getInstancia().insert(tabla2, campos2,valores2);
		        
	        }catch(Exception e){
	    	   System.out.println("error no se pudo insertar");
	        }
	        resul=ok1 && ok2;
	        return resul; 
    }
    
    
    
 public boolean eliminarAlumnoBD(int cedula ) {
    	
    	boolean ok1=false, ok2 = false, resul=false;
    	
    	String tabla1="alumno";
    	String tabla2="persona";
    	String condicion="cedula="+cedula;
    	try{
	    	ok1=ControladorPersistencia.getInstancia().delete(tabla1, condicion);
	    	ok2=ControladorPersistencia.getInstancia().delete(tabla2, condicion);
    	}catch(Exception e){
    		System.out.println("error no se pudo eliminar");
    	}
    	resul=ok1 && ok2;
    	return resul;
    				
    }
    
    
    public boolean modificarAlumnoBD(Alumno a){
    	boolean ok1=false, ok2=false, ok3=false, resul=false;
    	
    	String tabla1="persona";
    	String tabla2="alumno";
    	String condicion="cedula="+"'"+a.getCedula()+"'";
    	
    	String campo1="apellido";
    	String campo2="nombre";
    	String campo3="grupo";
    	
    	try{
	    	ok1=ControladorPersistencia.getInstancia().update(tabla1, campo1, "'"+a.getApellido()+"'", condicion);
	    	ok2=ControladorPersistencia.getInstancia().update(tabla1, campo2, "'"+a.getNombre()+"'", condicion);
	    	ok3=ControladorPersistencia.getInstancia().update(tabla2, campo3, "'"+a.getGrupo()+"'", condicion);
	    }catch(Exception e){
    		System.out.println("error no se pudo actualizar");
    	}
    	resul=ok1 && ok2 && ok3;
    	return resul;
    	
    }
    
    //dada una cedula recupera un alumno de la BD
    public Alumno recuperarAlumnoBD(int cedula){
    	Alumno a=new Alumno();
    	String[] datosAlumno = null;
    	
    	try{
    		datosAlumno= ControladorPersistencia.getInstancia().getColAluBD().selectCond(cedula);
    	}catch(Exception ex){
    		System.out.println("error ...");
    	}		
    	a.setCedula(Integer.parseInt(datosAlumno[0]));
    	a.setNombre(datosAlumno[1]);
    	a.setApellido(datosAlumno[2]);
    	a.setGrupo(datosAlumno[3]);
    	return a;
    }
    
    //recupera todos los registros de la bd en una lista
    public ListaAlumnos recuperarAlumnos(){
    	ListaAlumnos lis=new ListaAlumnos();
    	String[][] datosAlumnos = null;
    	    	
    	try{
    		datosAlumnos= ControladorPersistencia.getInstancia().getColAluBD().select();
    		
    	}catch(Exception ex){
    		System.out.println("error ...");
    	}	
    	int i=0;
    	while( i<datosAlumnos.length){
    		Alumno a=new Alumno();   		  	
	    	a.setCedula(Integer.parseInt(datosAlumnos[i][0]));
	    	a.setNombre(datosAlumnos[i][1]);
	    	a.setApellido(datosAlumnos[i][2]);
	    	a.setGrupo(datosAlumnos[i][3]);
	    	lis.agregar(a);
	    	i++;
	    }
    	return lis;
    }
    
   
}

