package Negocio.Empleado.Imp;

import java.util.Collection;

import Integracion.Cliente.DAOCliente;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Factoria.Imp.FactoriaIntegracionImp;
import Negocio.Cliente.TCliente;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TEmpleado;

public class SAEmpleadoImp implements SAEmpleado {	
	@Override
	public void AltaEmpleado(TEmpleado empleado) throws Exception {
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOEmpleado daoE = factoria.generaDAOEmpleados();
		TEmpleado emp = daoEmpleado.buscarPorID(empleado.getDNI());
		
		TEmpleado sup = daoEmpleado.leerEmpleadoDNI(empleado.getDNISupervisor());
		if(sup == null) {
			throw new Exception("El DNI "+empleado.getDNISupervisor()+" no pertenece a ningún supervisor");
		}
		//Si no existe lo creamos
		if(emp == null) {
			daoE.altaEmpleado(empleado);
		}
		else {
			//Si existe lo actualizamos
			if(emp.getDNI().equals(empleado.getDNI()) && emp.getActivo()==false) {
				daoE.actualizarEmpleado(empleado);
			}
			else {
				throw new Exception("Error al dar de alta al empleado con DNI " + empleado.getDNI());
			}
		}
			
	}

	@Override
	public void BajaEmpleado(String dni) throws Exception {
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOEmpleado daoE = factoria.generaDAOEmpleados();
		
		TEmpleado temp = daoE.leerEmpleadoDNI(dni);
		if(temp != null && temp.getActivo()){
			temp.setActivo(false);
			daoE.bajaEmpleado(temp);
		}
		else {
			throw new Exception("No se ha podido dar de baja el cliente con DNI " + dni);
		}
		
	}
	
	@Override
	public void ModificarEmpleado(TEmpleado empleado) throws Exception {
		// TODO Auto-generated method stub
		FactoriaIntegracion factoria = FactoriaIntegracionImp.getInstance();
		DAOEmpleado daoE = factoria.generaDAOEmpleados();
		TEmpleado temp = daoE.leerEmpleadoDNI(empleado.getDNI());
		if(temp!=null) {
			if(empleado.getDNISupervisor()!=null) {
				TEmpleado supervisor = daoE.leerEmpleadoDNI(empleado.getDNISupervisor());
				if(supervisor == null) {
					throw new Exception("No existe ningun supervisor con DNI: " + empleado.getDNISupervisor());
				}
				else {
					daoE.actualizarEmpleado(empleado);
				}
			}
			else {
				daoE.actualizarEmpleado(empleado);
			}	
		}
		else {
			throw new Exception("Error al intentar modificar el empleado con DNI " + empleado.getDNI());
		}
	}

	@Override
	public TEmpleado mostrarEmpleado(TEmpleado empleado) throws Exception {
		TEmpleado emp = null;
		DAOEmpleado daoE = factoria.generaDAOEmpleados();
		if(empleado.getDNI()==null) {
			emp = daoE.leerEmpleadoNombre(empleado.getNombre());
			if(emp == null || emp.getActivo()==false) {
				throw new Exception("El empleado con nombre: " +empleado.getNombre()+" no se encuentra o no esta activo en la base de datos");
			}
		}
		else {
			emp = daoE.leerEmpleadoDNI(empleado.getDNI());
			if(emp == null || emp.getActivo()==false) {
				throw new Exception("El empleado con DNI: " +empleado.getDNI()+" no se encuentra o no esta activo en la base de datos");
			}
		}
		return emp;
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
