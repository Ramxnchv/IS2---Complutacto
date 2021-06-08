package Presentacion.Factoria;

import Presentacion.Cliente.AltaClienteGUI;
import Presentacion.Cliente.BajaClienteGUI;
import Presentacion.Cliente.ModificarClienteGUI;
import Presentacion.Cliente.MostrarClienteGUI;
import Presentacion.Cliente.MostrarTodosClientesGUI;
import Presentacion.Factoria.Imp.FactoriaVistasImp;

public abstract class FactoriaVistas {
	public static FactoriaVistas instancia;
	
	public static FactoriaVistas getInstance(){
		if(instancia == null){
			instancia = new FactoriaVistasImp();
		}
		
		return instancia;
	}
	
	public abstract AltaClienteGUI generaAltaClienteGUI();
	public abstract BajaClienteGUI generaBorrarClienteGUI();
	public abstract ModificarClienteGUI generaModificarClienteGUI();
	public abstract MostrarClienteGUI generaMostrarClienteGUI();
	public abstract MostrarTodosClientesGUI generaMostrarTodosClientesGUI();
	
//	public abstract AltaEmpleadoGUI generaAltaEmpleadoGUI(int opcion);
//	public abstract BajaEmpleadoGUI generaBorrarEmpleadoGUI();
//	public abstract ModificarEmpleadoGUI generaModificarEmpleadoGUI(int opcion);
//	public abstract MostrarEmpleadoGUI generaMostrarEmpleadoGUI();
//	public abstract MostrarTodosEmpleadosGUI generaMostrarTodosEmpleadosGUI();
}
