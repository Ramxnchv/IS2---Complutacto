package Negocio.Empleado.Imp;

import java.util.Collection;

import Integracion.Empleado.DAOEmpleado;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Factoria.Imp.FactoriaIntegracionImp;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TEmpleado;

public class SAEmpleadoImp implements SAEmpleado {
  protected FactoriaIntegracion factoria;
	protected DAOEmpleado daoEmpleado;
	public SAEmpleadoImp() {
		factoria = FactoriaIntegracionImp.getInstance();
		daoEmpleado = factoria.generaDAOEmpleados();
	}
	
	
	@Override
	public boolean AltaEmpleado(String dni) throws Exception {
		boolean ret = false;
		TEmpleado empleado = daoEmpleado.leerEmpleadoDNI(dni);
		if (empleado != null) {
			empleado.setActivo(true);
			ret = true;
		}
		else {
			throw new Exception("no existe empleado con dni: " + dni);
		}
		return ret;
	}

	@Override
	public boolean BajaEmpleado(String dni) throws Exception {
		boolean ret = false;
		TEmpleado empleado = daoEmpleado.leerEmpleadoDNI(dni);
		if (empleado != null) {
			empleado.setActivo(false);
			ret = true;
		}
		else {
			throw new Exception("no existe empleado con dni: " + dni);
		}
		return ret;
	}

	@Override
	public TEmpleado mostrarEmpleado(String dni) throws Exception {
		TEmpleado empleado = daoEmpleado.leerEmpleadoDNI(dni);
		return empleado;
	}

	@Override
	public Collection<TEmpleado> mostrarTodos() throws Exception {
		return daoEmpleado.leerEmpleados();
	}


	@Override
	public String[] LogInEmpleado(String dni, String password) throws Exception {
		String[] resultado = new String[2];
		TEmpleado empleado = daoEmpleado.leerEmpleadoDNI(dni);
		if(empleado == null) {
			throw new Exception("No existe ningún empleado en el sistema con ese DNI");
		}
		else {
			if(!empleado.getPW().equals(password)) {
				throw new Exception("La contraseña introducida es incorrecta");
			}
			
			resultado[0] = empleado.getDNISupervisor() == null ?  "supervisor" : "empleado";
			resultado[1] = empleado.getNombre() + " " + empleado.getApellidos();
			
		}
		return resultado;
	}

}
