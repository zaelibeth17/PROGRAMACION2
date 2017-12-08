package presentacion;

import java.awt.GridLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.*;
 
public class AgregarAlumno extends JDialog implements ActionListener {
	
	//Aplicando patrón Singleton
	//El único objeto (instancia) de AgregarAlumno durante toda la ejecución
	private static AgregarAlumno instancia;
	
	private JPanel pnlSuperior;
	private JLabel lblCedula, lblNombre, lblApellido, lblGrupo;
	private JTextField txtCedula, txtNombre, txtApellido;
	private JButton btnGuardar, btnLimpiar;
	private JComboBox cmbGrupo;
	
		
	//constructor privado!!!
	private AgregarAlumno(){
		
		setTitle("Agregar Alumno");
		setLocationRelativeTo(null);
		setResizable(true);
		iniciarComponentes();
		pack();
	}
	
	//salvo la primera vez (null), siempre devuelve la misma instancia
	public static AgregarAlumno getInstancia(){
		
		if (instancia==null)
			instancia = new AgregarAlumno();
		return instancia;
	}
	
	private void iniciarComponentes() {
		
		
		pnlSuperior =new JPanel();   
		pnlSuperior.setLayout(new GridLayout(5,2,5,5)); 
		/*genera espacio vacío alrededor para que no que todo contra los bordes*/
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		/*Definimos  los componentes del panel superior*/
		lblCedula=new JLabel("Cedula:"); 
		txtCedula= new JTextField();
		lblNombre= new JLabel("Nombre:"); 
		txtNombre= new JTextField();
		lblApellido= new JLabel("Apellido:");
		txtApellido= new JTextField();
		lblGrupo= new JLabel("Grupo:");
		cmbGrupo = new JComboBox();
		cmbGrupo.addItem("A");
		cmbGrupo.addItem("B");
		cmbGrupo.addItem("C");
		cmbGrupo.setSelectedIndex(0);
		btnGuardar= new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
				
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(lblNombre);
		pnlSuperior.add(txtNombre);
		pnlSuperior.add(lblApellido);
		pnlSuperior.add(txtApellido);
		pnlSuperior.add(lblGrupo);
		pnlSuperior.add(cmbGrupo);
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnGuardar);
		//agregamos el panel al JFrame		
		this.add(pnlSuperior);
					
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		boolean ok=false;
		
		if (evento.getSource()==btnGuardar){
			Alumno alumno1 =new Alumno();
			
			try{
				 int auxCed=Integer.parseInt(txtCedula.getText());
		         String auxNom=txtNombre.getText();
		         String auxApe=txtApellido.getText();
		         String auxGrupo= cmbGrupo.getSelectedItem().toString();
		         //verifico que ningún  dato quede vacio
		         if (!(auxNom.isEmpty()||auxApe.isEmpty())){
			         alumno1.setCedula(auxCed);
			         alumno1.setNombre(auxNom);
			         alumno1.setApellido(auxApe);
			         alumno1.setGrupo(auxGrupo);
			         ok=true;
		         }
		         else
		        	 JOptionPane.showMessageDialog(null, "Error!!, no puede dejar campos vacíos \n","Error",JOptionPane.ERROR_MESSAGE);
		         if (ok==true){
		        	 //verifico que la cedula no fue ingresa
		        	 boolean esta=ControladorLogica.getInstancia().devolverAlumnos().estaAlumno(auxCed);
		        	 if (!esta){
		        		 ControladorLogica.getInstancia().agregarAlumno(alumno1);
		        	 JOptionPane.showMessageDialog(null, "Datos guardados correctamente en BD  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
		        	 }else 
		        		 JOptionPane.showMessageDialog(null, "Error!!, ya existe esa cédula  \n","Error",JOptionPane.ERROR_MESSAGE);
	
		         }
		    }catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error!!, la cedula debe ser numerica  \n","Error",JOptionPane.ERROR_MESSAGE);
	}
			
					
					
			
				
		}
		if (evento.getSource()==btnLimpiar){
			txtCedula.setText("");
			txtNombre.setText("");
			txtApellido.setText("");	
			cmbGrupo.setSelectedIndex(0);
			
		}
		
	}
	
	
	   
}
	
