package presentacion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame  implements ActionListener{
    
	//lo único que contendrá este JFrame será la barra de menú
	
	//**************************************************		
	private JMenuBar mnbPrincipal = new JMenuBar(); //Barra de menus
	//**************************************************
	
	//menu Alumnos
	private  JMenu jMenuAlumnos;
    
	// opciones del menu Alumnos
    private JMenuItem itemAltaAlumno;
    private JMenuItem itemBuscarAlumno;
    private JMenuItem itemVerAlumnos;

    
   
    //constructor
    public Principal() {        
    	setTitle("Menu Principal Alumnos");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	this.setBounds(200, 50,600,500);
        iniciarComponentes();
      
                     
    }
    
    private void iniciarComponentes() {
    	    	
    	//barra de menú principal
    	mnbPrincipal = new JMenuBar();
    	
    	//Menú Alumnos
        jMenuAlumnos = new  JMenu("Alumnos");
               
        //opciones de menú Alumnos
        itemAltaAlumno = new  JMenuItem("Agregar Alumno");
        itemAltaAlumno.addActionListener(this);
        
        itemBuscarAlumno = new  JMenuItem("Buscar Alumno");
        itemBuscarAlumno.addActionListener(this);
        
        itemVerAlumnos= new  JMenuItem("Ver Alumnos");
        itemVerAlumnos.addActionListener(this);
        
        //agregamos los itemMenú  al menú
        jMenuAlumnos.add(itemAltaAlumno);
        jMenuAlumnos.add(itemBuscarAlumno);
        jMenuAlumnos.add(itemVerAlumnos);
        
        //agregamos el menú Alumnos a la barra de menú
        mnbPrincipal.add(jMenuAlumnos);
        
        //colocamos el menú principal en el JFrame
        setJMenuBar(mnbPrincipal);
       
        
    }

   
       
    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource()==itemAltaAlumno){
    		//getInstancia es estatico... por lo tanto se invoca por medio de la Clase
			AgregarAlumno altaAlu = AgregarAlumno.getInstancia(); 
			altaAlu.setVisible(true);
    	}
    	if (e.getSource()==itemBuscarAlumno){
			
    		BuscarAlumno busAlu = new BuscarAlumno(); 
			busAlu.setVisible(true);
    	}
    	if (e.getSource()==itemVerAlumnos){
    		
			MostrarAlumnos tablaAlu = new MostrarAlumnos(); 
			tablaAlu.setVisible(true);
    		
    		
    	}
	  	
    }
    
    public static void main(String args[]) {
    	
    	Principal m=new Principal();
    	m.setVisible(true);
    }

}
