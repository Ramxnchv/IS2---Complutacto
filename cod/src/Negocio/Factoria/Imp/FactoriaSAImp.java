package Negocio.Factoria.Imp;

import Negocio.Factoria.FactoriaSA;
import Negocio.Clientes.SACliente;
import Negocio.Clientes.Imp.SAClienteImp;
import Negocio.Tarifa.SATarifa;
import Negocio.Tarifa.Imp.SATarifaImp;
import Negocio.Contrato.SAContrato;
import Negocio.Contrato.Imp.SAContratoImp;
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

	@Override
	public SATarifa generaSATarifa() {
		return new SATarifaImp();
	}

	@Override
	public SAContrato generaSAContrato() {
		return new SAContratoImp();
	}


}
