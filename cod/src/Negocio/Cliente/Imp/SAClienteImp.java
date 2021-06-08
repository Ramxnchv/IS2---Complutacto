package Negocio.Cliente.Imp;

import java.util.Collection;

import Integracion.Cliente.DAOCliente;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Factoria.Imp.FactoriaIntegracionImp;
import Negocio.Cliente.SACliente;
import Negocio.Cliente.TCliente;
import Negocio.Empleado.TEmpleado;

public class SAClienteImp implements SACliente {

	@Override
	public void AltaCliente(TCliente cliente) throws Exception {
		// TODO Auto-generated method stub
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		DAOEmpleado daoE = factoria.generaDAOEmpleados();
		
		//Buscamos el empleado que atiende al cliente
		TEmpleado empTemp = daoE.leerEmpleadoDNI(cliente.getDNI_empleado());
		
		//Buscamos si existe ya ese cliente
		TCliente clienteTemp = daoC.buscarPorID(cliente.getDNI());
		
		if(empTemp == null) {
			throw new Exception("El DNI " + cliente.getDNI_empleado() + " no corresponde a ningún empleado");
		}
		
		//Si no existe lo creamos
		if(clienteTemp == null) {
			daoC.altaCliente(cliente);
		}
		else {
			//Si existe lo actualizamos
			 if(clienteTemp.getDNI().equals(cliente.getDNI()) && !clienteTemp.isActivo()) {
				daoC.actualizarCliente(cliente);
			 }
			else {
				throw new Exception("Error al dar de alta el cliente con DNI " + cliente.getDNI());
			}
			
		}
	}

	@Override
	public void BajaCliente(String dni) throws Exception {
		// TODO Auto-generated method stub
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		
		TCliente temp = daoC.leerPorID(dni);
		if(temp != null && temp.isActivo()){
			temp.setActivo(false);
			daoC.bajaCliente(temp);
		}
		else {
			throw new Exception("No se ha podido dar de baja el cliente con DNI " + dni);
		}
		
	}

	@Override
	public void ModificarCliente(TCliente cliente) throws Exception {
		// TODO Auto-generated method stub
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		DAOEmpleado daoE = factoria.generaDAOEmpleados();
		
		//Buscamos el empleado que atiende al cliente
		TEmpleado empTemp = daoE.leerEmpleadoDNI(cliente.getDNI_empleado());
		
		if(empTemp == null) {
			throw new Exception("El DNI " + cliente.getDNI_empleado() + " no corresponde a ningún empleado");
		}
		
		TCliente temp = daoC.leerPorID(cliente.getDNI());
		if(temp != null && cliente.getDNI().equalsIgnoreCase(temp.getDNI())){
			daoC.actualizarCliente(cliente);
		}
		else {
			throw new Exception("Error al intentar modificar el cliente con DNI " + cliente.getDNI());
		}
	}

	@Override
	public TCliente MostrarCliente(TCliente cliente) throws Exception {
		TCliente  c =null;
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		if(cliente.getDNI()==null) {
			c = daoC.leerPorNombre(cliente.getNombre());
			if(c == null || c.isActivo()==false) {
				throw new Exception("El cliente con nombre: " +cliente.getNombre()+" no se encuentra o no esta activo en la base de datos");
			}
		}
		else {
			c = daoC.leerPorID(cliente.getDNI());
			if(c == null || c.isActivo()==false) {
				throw new Exception("El cliente con DNI " +cliente.getDNI()+" no se encuentra o no esta activo en la base de datos");
			}
		}
		
		return c;
	}

	@Override
	public Collection<TCliente> MostrarTodos() throws Exception {
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		Collection<TCliente> clientes = daoC.leerTodos();
		return clientes;
	}

}
