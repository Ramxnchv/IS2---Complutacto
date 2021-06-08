package Negocio.Cliente;

import java.util.Collection;

public interface SACliente {
	
	public void AltaCliente(TCliente cliente) throws Exception;
	
	public void BajaCliente(String dni) throws Exception;


	public void ModificarCliente(TCliente cliente) throws Exception;


	public TCliente MostrarCliente(TCliente cliente) throws Exception;


	public Collection<TCliente> MostrarTodos() throws Exception;
}
