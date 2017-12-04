package persistencia;
import java.sql.*;

public class Conectar {
	
	 /**Parametros de conexion*/
	String bd = "instituto";
	String login = "root";
	String password = "admin";
	String url = "jdbc:mysql://localhost/"+bd;
	
	private  Connection con;
	
	  public Conectar() {
	      try{
	         //obtenemos el driver de para mysql
	         Class.forName("com.mysql.jdbc.Driver");
	         //obtenemos la conexión
	         con = DriverManager.getConnection(url,login,password);
	 
	         if (con!=null){
	            System.out.println("Conexión a base de datos "+bd+" OK\n");
	         }
	      }
	      catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }
	   }
	
	
	
	public void desconectar() throws SQLException {
		System.out.println("Desconectado de base de datos "+bd+" OK\n");
		con.close();
	}
	
	public Connection getConnection(){
		return con;
	}
	
}
	
