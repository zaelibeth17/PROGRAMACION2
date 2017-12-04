package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorPersistencia {
	
	//atributos
    private static ControladorPersistencia instancia;	//atributo Singleton
   
    private Conectar conexion;
    private  AlumnosBD colAluBD; 
    
    
    //constructor privado
    private ControladorPersistencia(){	
    	conexion=new Conectar();
    	colAluBD=new AlumnosBD();
    	
    }
    
    //Singleton metodo getInstancia
    public static ControladorPersistencia getInstancia(){
    	if (instancia==null)
    		instancia=new ControladorPersistencia();
    	return instancia;
	}

	public AlumnosBD getColAluBD() {
		return colAluBD;
	}
	

	public Conectar getConexion() {
		return conexion;
	}

/********************************los siguientes metodos son genericos ***********************/
   
	public   boolean insert(String tabla, String campos, String valores)  {
		
		boolean ok=false;
		Conectar conex=getConexion();
		//Se arma la consulta
	    String sql=" INSERT INTO " + tabla + " ( " + campos + " ) VALUES ( " + valores + " );";
	        
		 
		  try {
			  PreparedStatement pstm = conex.getConnection().prepareStatement(sql);
			   int cont=pstm.executeUpdate();
			   if( cont == 1 ){
			    	 System.out.println("1 fila correctamente ingresada");
			    	 ok=true;
			   }else
				   throw new RuntimeException("No se pudo ingresar la fila");
			          
			   //pstm.close();
			   //conex.desconectar();
		    
		  } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            
		  }
		return ok;
	}
	        
	public   boolean delete(String tabla, String condicion)  {
		boolean ok=false;
		
		Conectar conex=getConexion();
	    		
	   String sql=" DELETE FROM "+tabla+ " where "+ condicion;
	   //se ejecuta la consulta
	   try {
		   PreparedStatement pstm = conex.getConnection().prepareStatement(sql);
	        int cont =pstm.executeUpdate();
	        if( cont == 1 ){
	        	System.out.println("1 fila correctamente eliminada");
	        	ok=true;
	        }else
		          throw new RuntimeException("No se pudo eliminar la fila");
		    //pstm.close();
	       //conex.desconectar();
	  
	   }catch (SQLException e) {
	            System.out.println("errorrrr"+e.getMessage());
	            
	  }
	   return ok; 			
	}

	public   boolean update(String tabla,String campo, String valor, String condicion)  {
	   	boolean ok=false;
	   	
	   	Conectar conex=getConexion();
		
		//Se arma la query
		String sql="UPDATE "+ tabla+ " SET "+campo+"="+valor+" WHERE "+condicion;
		   		        
		//se ejecuta la query
		try {
			 PreparedStatement pstm = conex.getConnection().prepareStatement(sql);
		     int cont= pstm.executeUpdate();
		     if( cont == 1 ){
		    	 //System.out.println("1 fila correctamente actualizada");
		    	 ok=true;
		     }else
		          throw new RuntimeException("No se pudo actualizar la fila");
		     
		   
		  	            
		}catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
		}
	    return ok;				

	}
	
    
	public   int contarRegistros(String table){
	       int resul=0;
	       Conectar con=getConexion();
	        //Se arma la consulta
	        String sql=" SELECT COUNT(*) FROM " + table;
	        
	        //se ejecuta la consulta
	        try {
	            PreparedStatement pstm = con.getConnection().prepareStatement(sql);
	            ResultSet res = pstm.executeQuery();
	            res.next();
	            resul=res.getInt(1); 
	        }catch(SQLException e){
	        	 System.out.println(e);
	        }	        
	        return resul;
	 }
}
