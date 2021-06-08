package Negocio.Empleado;

import java.util.Collection;

public interface SAEmpleado {
	public boolean AltaEmpleado(String dni) throws Exception;
	public boolean BajaEmpleado(String dni) throws Exception;
	public TEmpleado mostrarEmpleado(String dni) throws Exception;
	public Collection<TEmpleado> mostrarTodos() throws Exception;
	public String[] LogInEmpleado(String dni, String password) throws Exception;
}
