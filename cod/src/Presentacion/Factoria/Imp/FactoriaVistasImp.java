package Presentacion.Factoria.Imp;

import Presentacion.Cliente.AltaClienteGUI;
import Presentacion.Cliente.BajaClienteGUI;
import Presentacion.Cliente.ModificarClienteGUI;
import Presentacion.Cliente.MostrarClienteGUI;
import Presentacion.Cliente.MostrarTodosClientesGUI;
import Presentacion.Factoria.FactoriaVistas;

public class FactoriaVistasImp extends FactoriaVistas {

	@Override
	public AltaClienteGUI generaAltaClienteGUI() {
		// TODO Auto-generated method stub
		return new AltaClienteGUI();
	}

	@Override
	public BajaClienteGUI generaBorrarClienteGUI() {
		// TODO Auto-generated method stub
		return new BajaClienteGUI();
	}

	@Override
	public ModificarClienteGUI generaModificarClienteGUI() {
		// TODO Auto-generated method stub
		return new ModificarClienteGUI();
	}

	@Override
	public MostrarClienteGUI generaMostrarClienteGUI() {
		// TODO Auto-generated method stub
		return new MostrarClienteGUI();
	}

	@Override
	public MostrarTodosClientesGUI generaMostrarTodosClientesGUI() {
		// TODO Auto-generated method stub
		return new MostrarTodosClientesGUI();
	}
	
	
//	@Override
//	public AltaEmpleadoGUI generaAltaEmpleadoGUI(int opcion) {
//		return new AltaEmpleadoGUI( opcion);
//	}
//
//	@Override
//	public BajaEmpleadoGUI generaBorrarEmpleadoGUI() {
//		return new BajaEmpleadoGUI();
//	}
//
//	@Override
//	public ModificarEmpleadoGUI generaModificarEmpleadoGUI(int opcion) {
//		return new ModificarEmpleadoGUI(opcion);
//	}
//
//	@Override
//	public MostrarEmpleadoGUI generaMostrarEmpleadoGUI() {
//		return new MostrarEmpleadoGUI();
//	}
//
//	@Override
//	public MostrarTodosEmpleadosGUI generaMostrarTodosEmpleadosGUI() {
//		return new MostrarTodosEmpleadosGUI();
//	}
}
