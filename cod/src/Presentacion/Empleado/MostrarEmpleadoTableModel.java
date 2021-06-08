package Presentacion.Empleado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import Negocio.Empleado.TEmpleado;

public class MostrarEmpleadoTableModel extends AbstractTableModel {
	private List<TEmpleado> lista;
	private static String[] headers = {"DNI","NOMBRE","APELLIDOS","TELEFONO","DNI_SUPERVISOR","ACTIVO"};
	
	public MostrarEmpleadoTableModel(Collection<TEmpleado> lista) {
		List<TEmpleado> x = new ArrayList(lista);
		this.lista = x;
	}
	public MostrarEmpleadoTableModel(TEmpleado empleado) {
		this.lista.add(empleado);
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
		else if (headers[columnIndex].equalsIgnoreCase("telefono")) {
			y = lista.get(rowIndex).getTelefono();
		}
		else if (headers[columnIndex].equalsIgnoreCase("activo")) {
			y = lista.get(rowIndex).getActivo();
		}
		else if (headers[columnIndex].equalsIgnoreCase("dni_supervisor")) {
			y = lista.get(rowIndex).getDNISupervisor();
		}
		return y;
	}
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
