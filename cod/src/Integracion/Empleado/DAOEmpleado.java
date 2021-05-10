package Integracion.Empleado;

import java.sql.SQLException;
import java.util.Collection;

import Negocio.Empleado.TEmpleado;

public interface DAOEmpleado {
  public TEmpleado leerEmpleadoDNI(String dni) throws SQLException;
  public Collection<TEmpleado> leerEmpleadoNombre(String nombre) throws SQLException;
  public Collection<TEmpleado> leerEmpleadoApellidos(String apellidos) throws SQLException;
  public Collection<TEmpleado> leerEmpleados() throws SQLException;
} 
