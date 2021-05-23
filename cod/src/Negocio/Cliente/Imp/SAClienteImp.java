package Negocio.Cliente.Imp;

import java.util.Collection;

import Integracion.Cliente.DAOCliente;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Factoria.Imp.FactoriaIntegracionImp;
import Negocio.Cliente.SACliente;
import Negocio.Cliente.TCliente;

public class SAClienteImp implements SACliente {

	@Override
	public void AltaCliente(TCliente cliente) throws Exception {
		// TODO Auto-generated method stub
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		
		//Buscamos si existe ya ese cliente
		TCliente clienteTemp = daoC.leerPorNombre(cliente.getNombre());
		
		//Si no existe lo creamos
		if(clienteTemp.getNombre() == null) {
			daoC.altaCliente(cliente);
		}
		
		//Si existe lo actualizamos
		else if(clienteTemp.getDNI()!=null && !clienteTemp.isActivo()) {
			daoC.actualizarCliente(cliente);
		}
		
		else {
			throw new Exception("Error al dar de alta el cliente con DNI " + cliente.getDNI());
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
			daoC.actualizarCliente(temp);
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
		
		TCliente temp = daoC.leerPorID(cliente.getDNI());
		if(temp != null && cliente.getDNI().equalsIgnoreCase(temp.getDNI())){
			daoC.actualizarCliente(cliente);
		}
		else {
			throw new Exception("Error al intentar modificar el cliente con DNI " + cliente.getDNI());
		}
	}

	@Override
	public TCliente MostrarCliente(String dni) throws Exception {
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		TCliente  cliente = daoC.leerPorID(dni);
		if(cliente == null || !cliente.isActivo()) {
			throw new Exception("El cliente con DNI " +dni+" no se encuentra o no esta activo en la base de datos");
		}
		return cliente;
	}

	@Override
	public Collection<TCliente> MostrarTodos() throws Exception {
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOCliente daoC = factoria.generaDAOClientes();
		Collection<TCliente> clientes = daoC.leerTodos();
		return clientes;
	}

}
