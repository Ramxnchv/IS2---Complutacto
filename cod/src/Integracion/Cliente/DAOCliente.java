package Integracion.Cliente;

import java.util.Collection;

import Negocio.Cliente.TCliente;

public interface DAOCliente {
	public TCliente leerPorNombre(String Nombre);
	public TCliente leerPorID(String dni);
	public Collection <TCliente> leerTodos();
	public void altaCliente(TCliente cliente) throws Exception;
	public void actualizarCliente(TCliente cliente);
}
