package Negocio.Empleado;

import java.util.Collection;

import Negocio.Cliente.TCliente;

public interface SAEmpleado {
	public void AltaEmpleado(TEmpleado empleado) throws Exception;
	public void BajaEmpleado(String dni) throws Exception;
	public void ModificarEmpleado(TEmpleado empleado) throws Exception;
	public TEmpleado mostrarEmpleado(TEmpleado empleado) throws Exception;
	public Collection<TEmpleado> mostrarTodos() throws Exception;
	public String[] LogInEmpleado(String dni, String password) throws Exception;
}
