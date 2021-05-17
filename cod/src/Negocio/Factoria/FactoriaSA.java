package Negocio.Factoria;

import Negocio.Clientes.SACliente;
import Negocio.Tarifa.SATarifa;
import Negocio.Contrato.SAContrato;
import Negocio.Empleado.SAEmpleado;

public abstract class FactoriaSA {
  public static FactoriaSA instancia;
	public static FactoriaSA getInstance() {
		if(instancia == null) {
			instancia = new FactoriaSAImp();
		}
		return instancia;
	}
	public abstract SACliente generaSACliente();
	public abstract SAEmpleado generaSAEmpleado();
	public abstract SATarifa generaSATarifa ();
	public abstract SAContrato generaSAContrato();

}
