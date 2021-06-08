package Presentacion.Controlador;

import Presentacion.Controlador.Imp.ControladorImp;

public abstract class Controlador {
	public static class Evento{
		public static final int ALTA_CLIENTE=101;
		public static final int BAJA_CLIENTE=102;
		public static final int MODIFICAR_CLIENTE=103;
		public static final int ACCION_ALTA_CLIENTE=104;
		public static final int ACCION_BAJA_CLIENTE=105;
		public static final int ACCION_MODIFICAR_CLIENTE=106;
		public static final int MOSTRAR_CLIENTE=107;
		public static final int MOSTRAR_TODOS_CLIENTE=108;
		
		public static final int ALTA_EMPLEADO=201;
		public static final int BAJA_EMPLEADO=202;
		public static final int MODIFICAR_EMPLEADO=203;
		public static final int ACCION_ALTA_EMPLEADOL=204;
		public static final int ACCION_BAJA_EMPLEADO=205;
		public static final int ACCION_MODIFICAR_EMPLEADO=206;
		public static final int MOSTRAR_EMPLEADO=207;
		public static final int MOSTRAR_TODOS_EMPLEADO=208;
		public static final int LOG_IN_EMPLEADO=209;
	}
	
	private static Controlador instancia;
	
	public static Controlador getInstance(){
		if(instancia == null){
			instancia = new ControladorImp();
		}
		
		return instancia;
	}
	public abstract void accion(int evento, Object object);
}
