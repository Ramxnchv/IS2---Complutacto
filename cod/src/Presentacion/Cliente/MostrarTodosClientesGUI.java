package Presentacion.Cliente;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Negocio.Cliente.TCliente;
import Negocio.Empleado.TEmpleado;
import Presentacion.Empleado.MostrarEmpleadoTableModel;

public class MostrarTodosClientesGUI extends JFrame{

	public MostrarTodosClientesGUI(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		this.setBounds(500,200,800,500);
		this.setResizable(false);
	}
	
	public void MostrarTodosClientes(ArrayList<TCliente> clientes) {
		setTitle("LISTA DE CLIENTES");
		MostrarClienteTableModel x = new MostrarClienteTableModel(clientes);
		JTable table = new JTable(x);
		JScrollPane y = new JScrollPane(table);
		this.add(y);
		this.setVisible(true);
	}
}
