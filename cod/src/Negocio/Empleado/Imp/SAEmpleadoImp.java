package Negocio.Empleado.Imp;

import Negocio.Empleado.SAEmpleado;

public class SAEmpleadoImp implements SAEmpleado {
  protected FactoriaIntegracion factoria;
	protected DAOEmpleado daoEmpleado;
	public SAEmpleadoImp() {
		factoria = FactoriaIntegracionImp.getInstance();
		daoEmpleado = factoria.generarDAOEmpleado();
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

}
