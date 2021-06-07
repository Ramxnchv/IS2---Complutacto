package Presentacion.Controlador.Imp;

import javax.swing.JOptionPane;

import Negocio.Cliente.SACliente;
import Negocio.Cliente.TCliente;
import Negocio.Empleado.SAEmpleado;
import Negocio.Factoria.FactoriaSA;
import Presentacion.Controlador.Controlador;
import Presentacion.Factoria.FactoriaVistas;

public class ControladorImp extends Controlador{
	
	private FactoriaVistas vistas=FactoriaVistas.getInstance();
	private int id;
	private FactoriaSA factoria;
	private SACliente saCliente;
	private SAEmpleado saEmpleado;

	@Override
	public void accion(int evento, Object object) {
		// TODO Auto-generated method stub
		switch(evento) {
			case Evento.ALTA_CLIENTE:{
				TCliente cliente = (TCliente) object;
				factoria = FactoriaSA.getInstance();
				saCliente = factoria.generaSACliente();
				try {
					saCliente.AltaCliente(cliente);
					JOptionPane.showMessageDialog(null,  "Cliente dado de alta", "ALTA CLIENTE", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.BAJA_CLIENTE:{
				String dni = (String) object;
				factoria = FactoriaSA.getInstance();
				saCliente= factoria.generaSACliente();
				try {
					saCliente.BajaCliente(dni);
					JOptionPane.showMessageDialog(null,  "Cliente dado de alta", "ALTA CLIENTE", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}break;
			case Evento.MODIFICAR_CLIENTE :{
				
			}break;
			case Evento.MOSTRAR_CLIENTE :{
				
			}break;
			case Evento.MOSTRAR_TODOS_CLIENTE:{
				
			}break;
			case Evento.ALTA_EMPLEADO:{
				
			}break;
			case Evento.BAJA_EMPLEADO:{
				
			}break;
			case Evento.MODIFICAR_EMPLEADO :{
				
			}break;
			case Evento.MOSTRAR_EMPLEADO :{
				
			}break;
			case Evento.MOSTRAR_TODOS_EMPLEADO:{
				
			}break;
		}
	}

}
