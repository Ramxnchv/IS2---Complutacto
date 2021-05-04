package Integracion.Cliente;

import java.util.Collection;

public interface DAOCliente {
	public TCliente leerPorNombre(String Nombre);
	public TCliente leerPorID(int id);
	public Collection <TCliente> leerTodos();
	public int altaCliente(TCliente cliente) throws Exception;
	public int actualizarCliente(TCliente cliente);
}
