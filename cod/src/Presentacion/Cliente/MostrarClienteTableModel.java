package Presentacion.Cliente;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.AbstractTableModel;

import Negocio.Cliente.TCliente;

public class MostrarClienteTableModel extends AbstractTableModel{
	private ArrayList<TCliente> lista; 
	private String[] headers = {"DNI","NOMBRE","APELLIDOS","DIRECCION","DNI_EMPLEADO"}; 
	
	public MostrarClienteTableModel(ArrayList<TCliente> lista) { 
		this.lista = lista; 
	} 
	public MostrarClienteTableModel(TCliente cliente) { 
		this.lista = new ArrayList<>();
		this.lista.add(cliente); 
	} 
	
	public int getRowCount() { 
		return lista.size(); 
	} 
 
	public int getColumnCount() { 
		return headers.length; 
	} 

	public String getColumnName(int column) {
        return headers[column];
    }
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object y = null; 
		if (headers[columnIndex].equalsIgnoreCase("dni")) { 
			y = this.lista.get(rowIndex).getDNI();
		} 
		else if (headers[columnIndex].equalsIgnoreCase("nombre")) { 
			y = this.lista.get(rowIndex).getNombre(); 
		} 
		else if (headers[columnIndex].equalsIgnoreCase("apellidos")) { 
			y = this.lista.get(rowIndex).getApellidos(); 
		} 
		else if (headers[columnIndex].equalsIgnoreCase("direccion")) { 
			y = this.lista.get(rowIndex).getDireccion(); 
		} 
		else if (headers[columnIndex].equalsIgnoreCase("dni_empleado")) { 
			y = this.lista.get(rowIndex).getDNI_empleado(); 
		}
		return y; 
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) { 
		return false; 
	}

}
