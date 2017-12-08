package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.*;
 
public class BuscarAlumno extends JDialog implements ActionListener {
	
	private JPanel pnlSuperior, pnlCentral;
	private JLabel lblCedula, lblNombre, lblApellido, lblGrupo;
	private JTextField txtCedula, txtNombre, txtApellido, txtGrupo;
	private JButton btnBuscar;
			
	
	public BuscarAlumno(){
		
		setTitle("Buscar Alumno");
		setLocationRelativeTo(null);
		setResizable(true);
		this.setLayout(new BorderLayout());
		iniciarComponentes();
		pack();
	}

	private void iniciarComponentes() {
		
		pnlSuperior =new JPanel();   /*instanciamos el contenedor de los datos personales*/
		
		//crea un borde vacio que genera un espacio de 10 px en cada lado del panel
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				
		/*Definimos  los componentes del panel superior*/
		lblCedula=new JLabel("Ingrese cédula:"); 
		txtCedula= new JTextField(10);
		btnBuscar= new JButton();
		btnBuscar.setText("Buscar");
		btnBuscar.addActionListener(this);
		
				
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(btnBuscar);
		
		/*instanciamos el contenedor para los componentes de la parte central*/
		pnlCentral=new JPanel();
		//pone un borde con titulo
		
		pnlCentral.setLayout(new GridLayout(3,2,10,10)); /*definimos el Layout de 3 filas, 2 columnas y espacios*/
		pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//Definimos  los componentes para el panel central
		lblNombre= new JLabel("Nombre:"); 
		txtNombre= new JTextField();
		txtNombre.setEnabled(false);
		
		lblApellido= new JLabel("Apellido:");
		txtApellido= new JTextField();
		txtApellido.setEnabled(false);
		
		lblGrupo= new JLabel("Grupo:");
		txtGrupo = new JTextField();
		txtGrupo.setEnabled(false);
		
		
		/*Agregamos los componentes al Contenedor Central*/
		pnlCentral.add(lblNombre);
		pnlCentral.add(txtNombre);
		pnlCentral.add(lblApellido);
		pnlCentral.add(txtApellido);
		pnlCentral.add(lblGrupo);
		pnlCentral.add(txtGrupo);
		
					
		//agregamos cada panel a la zona correspondiendte
		this.add(pnlSuperior, BorderLayout.NORTH);
		this.add(pnlCentral, BorderLayout.CENTER);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
	Alumno aux=new Alumno();
	int auxCedula = 0;
	
		if (evento.getSource()==btnBuscar){
			
				//captura la cedula ingresada
				try{
					auxCedula=Integer.parseInt(txtCedula.getText());
				}catch (Exception e1){
					JOptionPane.showMessageDialog(null, "La cédula debe ser numérica  \n");
				}
				aux=ControladorLogica.getInstancia().devolverAlumnos().obtenerXCedula(auxCedula); 
				if (aux!=null){
						txtNombre.setText(aux.getNombre());
						txtApellido.setText(aux.getApellido());
						txtGrupo.setText(aux.getGrupo());
				}
				else
					JOptionPane.showMessageDialog(null, "Alumno no encontrado \n");
				
			}
	}
	
	private Alumno buscarAlumno(int ced){
				
		Alumno aux;
		//ListaAlumnos listado=ControladorLogica.getInstancia().devolverAlumnos();
		aux=ControladorLogica.getInstancia().devolverAlumnos().obtenerXCedula(ced);
		return (aux);
	}	
		
}
	
