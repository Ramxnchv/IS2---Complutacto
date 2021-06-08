package Presentacion.Main;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.table.AbstractTableModel;
import Negocio.Empleado.TEmpleado;

public class MostrarEmpleadoTableModel extends AbstractTableModel {
	private Collection<TEmpleado> lista;
	private String[] headers = {"DNI","NOMBRE","APELLIDOS","TELEFONO","ACTIVO"};
	
	public MostrarEmpleadoTableModel(Collection<TEmpleado> lista) {
		this.lista = lista;
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

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	// TODO complete
		TEmpleado[] x = (TEmpleado[]) lista.toArray();
		Object y = null;
		if (headers[columnIndex].equalsIgnoreCase("dni")) {
			y = x[rowIndex].getDNI();
		}
		else if (headers[columnIndex].equalsIgnoreCase("nombre")) {
			y = x[rowIndex].getNombre();
		}
		else if (headers[columnIndex].equalsIgnoreCase("apellidos")) {
			y = x[rowIndex].getApellidos();
		}
		else if (headers[columnIndex].equalsIgnoreCase("telefono")) {
			y = x[rowIndex].getTelefono();
		}
		else if (headers[columnIndex].equalsIgnoreCase("activo")) {
			y = x[rowIndex].getActivo();
		}
		return y;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
