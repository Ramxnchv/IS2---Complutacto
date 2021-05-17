package Negocio.Empleado;

public interface SAEmpleado {
	public boolean AltaEmpleado(String dni) throws Exception;
	public boolean BajaEmpleado(String dni) throws Exception;
	public TEmpleado mostrarEmpleado(String dni) throws Exception;
	public Collection<TEmpleado> mostrarTodos() throws Exception;
}
