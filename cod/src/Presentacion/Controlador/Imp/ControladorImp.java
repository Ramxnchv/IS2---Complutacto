package Presentacion.Controlador.Imp;

import javax.swing.JOptionPane;

import Negocio.Cliente.SACliente;
import Negocio.Cliente.TCliente;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TEmpleado;
import Negocio.Factoria.FactoriaSA;
import Presentacion.Cliente.MostrarTodosClientesGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Empleado.MostrarTodosEmpleadosGUI;
import Presentacion.Factoria.FactoriaVistas;
import Presentacion.Main.LogInWindow;
import Presentacion.Main.MainWindow;
import Presentacion.Main.MainWindowAdmin;

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
					JOptionPane.showMessageDialog(null,  "Cliente dado de baja", "BAJA CLIENTE", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}break;
			case Evento.MODIFICAR_CLIENTE :{
				TCliente cliente = (TCliente) object;
				factoria = FactoriaSA.getInstance();
				saCliente = factoria.generaSACliente();
				try {
					saCliente.ModificarCliente(cliente);
					JOptionPane.showMessageDialog(null,  "Cliente modificado", "MODIFICAR CLIENTE", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.MOSTRAR_CLIENTE :{
				TCliente cliente = (TCliente) object;
				factoria = FactoriaSA.getInstance();
				saCliente= factoria.generaSACliente();
				try {
					vistas.generaMostrarClienteGUI().mostrarCliente(saCliente.MostrarCliente(cliente));
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.MOSTRAR_TODOS_CLIENTE:{
				factoria = FactoriaSA.getInstance();
				saCliente= factoria.generaSACliente();
				MostrarTodosClientesGUI most= new MostrarTodosClientesGUI();
				try {
					most.MostrarTodosClientes(saCliente.MostrarTodos());
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.ALTA_EMPLEADO:{
				TEmpleado empleado = (TEmpleado) object;
				factoria = FactoriaSA.getInstance();
				saEmpleado = factoria.generaSAEmpleado();
				try {
					saEmpleado.AltaEmpleado(empleado);
					JOptionPane.showMessageDialog(null,  "Empleado dado de alta", "ALTA EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.BAJA_EMPLEADO:{
				String dni = (String) object;
				factoria = FactoriaSA.getInstance();
				saEmpleado= factoria.generaSAEmpleado();
				try {
					saEmpleado.BajaEmpleado(dni);
					JOptionPane.showMessageDialog(null,  "Cliente dado de baja", "BAJA CLIENTE", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}break;
			case Evento.MODIFICAR_EMPLEADO :{
				TEmpleado empleado = (TEmpleado) object;
				factoria = FactoriaSA.getInstance();
				saEmpleado = factoria.generaSAEmpleado();
				try {
					//saEmpleado.ModificarEmpleado(empleado);
					JOptionPane.showMessageDialog(null,  "Empleado modificado", "MODIFICAR EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.MOSTRAR_EMPLEADO :{
				String dni = (String) object;
				factoria = FactoriaSA.getInstance();
				saEmpleado = factoria.generaSAEmpleado();
				try {
					//vistas.generaMostrarEmpleadoGUI().mostrarEmpleado(saEmpleado.MostrarEmpleado(dni));
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.MOSTRAR_TODOS_EMPLEADO:{
				factoria = FactoriaSA.getInstance();
				saEmpleado = factoria.generaSAEmpleado();
				MostrarTodosEmpleadosGUI most= new MostrarTodosEmpleadosGUI();
				try {
					most.MostrarTodosEmpleados(saEmpleado.mostrarTodos());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}break;
			case Evento.LOG_IN_EMPLEADO:{
				TEmpleado empleado = (TEmpleado) object;
				factoria = FactoriaSA.getInstance();
				saEmpleado = factoria.generaSAEmpleado();
				try {
					String[] resultado = saEmpleado.LogInEmpleado(empleado.getDNI(), empleado.getPW());
					
					if(resultado[0].equals("empleado")) {
						MainWindow mw = new MainWindow(resultado[1]);
						mw.initGUI();
					}
					else {
						MainWindowAdmin mwa = new MainWindowAdmin(resultado[1]);
						mwa.initGUI();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					LogInWindow l = new LogInWindow();
					l.initGUI();
				}
			}break;
		}
	}

}
