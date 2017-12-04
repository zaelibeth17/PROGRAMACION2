package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnosBD {

	 //devuelve una matriz con todos los registros de la tabla persona y alumno
	 public  String[][] select(){
		 	int i=0, j=0, cant=0;
		 	String [][]datos=null;
		 	Conectar con=ControladorPersistencia.getInstancia().getConexion();
		 	String sql1="SELECT * FROM persona";
		    
		    try {
		    	cant=ControladorPersistencia.getInstancia().contarRegistros("persona");
		    	datos = new String [cant][4];
	            PreparedStatement pstm = con.getConnection().prepareStatement(sql1);
	        	ResultSet rs = pstm.executeQuery();
	            while(rs.next()){
	            	    datos[i][0]=rs.getString("cedula");
		                datos[i][1]=rs.getString("nombre");
		                datos[i][2]=rs.getString("apellido");
		                i++;  //recorre filas
		               
	           }
	            
	        } catch (SQLException ex) {
	           System.out.println("error en BD1");
	       
	        }
	        String sql2="SELECT * FROM alumno";
	        
	        try {
	            PreparedStatement pstm = con.getConnection().prepareStatement(sql2);
	        	ResultSet rs2 = pstm.executeQuery();
	            while(rs2.next()){
	            	    datos[j][3]=rs2.getString("grupo");	
	            	    j++;  //recorre filas
	           }
	            
	        } catch (SQLException ex) {
	        	System.out.println("error en BD2");
	        }
	        return datos;
	    
	    }
	 
	 //recupera un registro dada una cedula, lo uso para modificar alumnos  
	 public   String[] selectCond(int cedula){ 
		 	Conectar con=ControladorPersistencia.getInstancia().getConexion();
		    PreparedStatement pstm=null;
	        String sql1="SELECT * FROM persona WHERE cedula="+cedula;
	        String []datos = new String [4];
	        
	        try {
	            pstm = con.getConnection().prepareStatement(sql1);
	            ResultSet rs = pstm.executeQuery();
	            while(rs.next()){
	            	    datos[0]=rs.getString("cedula");
		                datos[1]=rs.getString("nombre");
		                datos[2]=rs.getString("apellido");		                
	           }
	           
	        } catch (SQLException ex) {
	        		System.out.println("error en BD1");
	        }
	        String sql2="SELECT * FROM alumno WHERE cedula="+cedula;
	        
	        try {
	            pstm = con.getConnection().prepareStatement(sql2);
	        	ResultSet rs2 = pstm.executeQuery();
	            while(rs2.next()){
	            	    datos[3]=rs2.getString("grupo");		               
	           }
	         } catch (SQLException ex) {
	           System.out.println("error en BD2");
	        }
	          
	        return datos;
	    
	    }
	
}
