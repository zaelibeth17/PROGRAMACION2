package presentacion;

import logica.*;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class MostrarAlumnos extends JDialog {
	
	private JPanel pnlCentral;
	private DefaultTableModel miModelo;
	private JTable tablaAlumnos;	
	private JScrollPane scrPanel;	//barra de desplazamiento horizontal y vertical
			
	public MostrarAlumnos(){
		
		setTitle("Listado de Alumnos");
		setLocationRelativeTo(null);
		setResizable(true);
		//this.setLayout(new BorderLayout());
		iniciarComponentes();
		iniciarTabla();
		
        ListaAlumnos listado=ControladorLogica.getInstancia().devolverAlumnos();
         
         //para cada posicion de la fila
       	String fila[]=new String[miModelo.getColumnCount()];
       	
       	try{
	      	for(int i=0;i<listado.largo();i++){
	      		
	      		fila[0]=String.valueOf(listado.devolver(i).getCedula());
	      		fila[1]=listado.devolver(i).getNombre();
	      		fila[2]=listado.devolver(i).getApellido();
	      		fila[3]=listado.devolver(i).getGrupo();
	      		miModelo.addRow(fila);
	      	}
	      	 // Asociar el modelo con la lista.
	      	tablaAlumnos.setModel(miModelo);
       	}catch (Exception e) {
       		System.out.println("error"+e);
       	}
      }
		
		

	public void iniciarComponentes(){
		
		pnlCentral =new JPanel();
		pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlCentral.setLayout(new BorderLayout());
		
		/*Instanciamos un scroll y lo agregamos al panel*/
		scrPanel = new JScrollPane();
		pnlCentral.add(scrPanel, BorderLayout.CENTER);
		
		/*Instanciamos una tabla y le asociamos el scroll*/
		tablaAlumnos = new JTable();
		scrPanel.setViewportView(tablaAlumnos);
       
		//agregamos el panel a la zona correspondiendte
		this.add(pnlCentral, BorderLayout.CENTER);
		pack();		
			
	}
	
public void iniciarTabla(){
	
		/*definimos titulos de la tabla en un array de String*/
		String titulos[]={"Cedula","Nombre", "Apellido","Grupo"};
		/*Instanciamos un modelo de tabla con los titulos definidos*/
		miModelo=new DefaultTableModel(null,titulos);
		/*colocamos el modelo a la tabla*/
		tablaAlumnos.setModel(miModelo);
	}
}