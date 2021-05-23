package Integracion.Factoria.Imp;

import Integracion.Cliente.DAOCliente;
import Integracion.Cliente.Imp.DAOClienteImp;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Empleado.Imp.DAOEmpleadoImp;
import Integracion.Factoria.FactoriaIntegracion;

public class FactoriaIntegracionImp extends FactoriaIntegracion {

	@Override
	public DAOCliente generaDAOClientes() {
		// TODO Auto-generated method stub
		return new DAOClienteImp();
	}

	@Override
	public DAOEmpleado generaDAOEmpleados() {
		// TODO Auto-generated method stub
		return new DAOEmpleadoImp();
	}

}
