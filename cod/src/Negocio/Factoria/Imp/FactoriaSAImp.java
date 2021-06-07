package Negocio.Factoria.Imp;

import Negocio.Factoria.FactoriaSA;

import Negocio.Tarifa.SATarifa;
import Negocio.Cliente.SACliente;
import Negocio.Cliente.Imp.SAClienteImp;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.Imp.SAEmpleadoImp;

public class FactoriaSAImp extends FactoriaSA{
  	@Override
	public SACliente generaSACliente() {
		return new SAClienteImp();
	}

	@Override
	public SAEmpleado generaSAEmpleado() {
		return new SAEmpleadoImp();
	}

}
