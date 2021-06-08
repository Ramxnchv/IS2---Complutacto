package Presentacion.Cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Negocio.Cliente.TCliente;
import Negocio.Empleado.TEmpleado;

public class MostrarClienteTableModel extends AbstractTableModel {
	private List<TCliente> lista;
	private static String[] headers = {"DNI","NOMBRE","APELLIDOS","DIRECCION","DNI_EMPLEADO"};
	
	public MostrarClienteTableModel(Collection<TCliente> lista) {
		List<TCliente> x = new ArrayList(lista);
		this.lista = x;
	}
	public MostrarClienteTableModel(TCliente cliente) {
		this.lista.add(cliente);
	}
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}
	public String getColumnName(int column) {
		// TODO complete
		    return headers[column];
		}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	// TODO complete
		Object y = null;
		if (headers[columnIndex].equalsIgnoreCase("dni")) {
			y = lista.get(rowIndex).getDNI();
		}
		else if (headers[columnIndex].equalsIgnoreCase("nombre")) {
			y = lista.get(rowIndex).getNombre();
		}
		else if (headers[columnIndex].equalsIgnoreCase("apellidos")) {
			y = lista.get(rowIndex).getApellidos();
		}
		else if (headers[columnIndex].equalsIgnoreCase("direccion")) {
			y = lista.get(rowIndex).getDireccion();
		}
		else if (headers[columnIndex].equalsIgnoreCase("dni_empleado")) {
			y = lista.get(rowIndex).getDNI_empleado();
		}
		return y;
	}
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
