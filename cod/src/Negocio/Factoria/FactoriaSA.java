package Negocio.Factoria;

import Negocio.Cliente.SACliente;
import Negocio.Tarifa.SATarifa;

import Negocio.Empleado.SAEmpleado;
import Negocio.Factoria.Imp.FactoriaSAImp;

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
	

}
