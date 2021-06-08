package Presentacion.Empleado;

import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Negocio.Empleado.TEmpleado;

public class MostrarTodosEmpleadosGUI extends JFrame {
	
	public MostrarTodosEmpleadosGUI(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		this.setBounds(500,200,200,500);
		this.setResizable(false);
	}
	
	public void MostrarTodosEmpleados(Collection<TEmpleado> empleados) {
		MostrarEmpleadoTableModel x = new MostrarEmpleadoTableModel(empleados);
		JTable table = new JTable(x);
		JScrollPane y = new JScrollPane(table);
		this.add(y);
		this.setVisible(true);
	}
}
