package Integracion.Factoria;

import Integracion.Cliente.DAOCliente;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Factoria.Imp.FactoriaIntegracionImp;

public abstract class FactoriaIntegracion {
private static FactoriaIntegracion instancia;
	
	public static FactoriaIntegracion getInstance(){
		if(instancia == null){
			instancia = new FactoriaIntegracionImp();
		}
		
		return instancia;
	}

	public abstract DAOCliente generaDAOClientes();
	public abstract DAOEmpleado generaDAOEmpleados();

}
