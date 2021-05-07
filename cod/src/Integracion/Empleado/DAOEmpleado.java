package Integracion.Empleado;

public interface DAOEmpleado {
  public TEmpleado leerEmpleadoDNI(String dni);
  public TEmpleado leerEmpleadoNombre(String nombre);
  public TEmpleado leerEmpleadoApellidos(String apellidos);
  public List<TEmpleado> leerEmpleados();
} 
