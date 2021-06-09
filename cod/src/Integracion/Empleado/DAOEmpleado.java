package Integracion.Empleado;

import java.sql.SQLException;
import java.util.Collection;

import Negocio.Cliente.TCliente;
import Negocio.Empleado.TEmpleado;

public interface DAOEmpleado {
  public TEmpleado leerEmpleadoDNI(String dni) throws SQLException;
  public TEmpleado leerEmpleadoNombre(String nombre) throws SQLException;
  public Collection<TEmpleado> leerEmpleadoApellidos(String apellidos) throws SQLException;
  public Collection<TEmpleado> leerEmpleados() throws SQLException;
  public void altaEmpleado(TEmpleado empleado) throws Exception;
  public void actualizarEmpleado(TEmpleado empleado);
  public void bajaEmpleado(TEmpleado empleado);
  public TEmpleado buscarPorID(String dni);
} 
