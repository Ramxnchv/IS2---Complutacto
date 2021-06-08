package Presentacion.Main;

import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Negocio.Empleado.TEmpleado;

public class MostrarEmpleadosGUI extends JFrame {
	
	public void MostrarTodosEmpleados(Collection<TEmpleado> empleados) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		MostrarEmpleadoTableModel x = new MostrarEmpleadoTableModel(empleados);
		JTable table = new JTable(x);
		JScrollPane y = new JScrollPane(table);
		panel.add(y);
		this.setBounds(500,200,200,500);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void MostrarEmpleado(TEmpleado empleado) {
		JPanel panel = new JPanel();
		
		this.setContentPane(panel);
		this.setBounds(500,200,200,500);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
}
