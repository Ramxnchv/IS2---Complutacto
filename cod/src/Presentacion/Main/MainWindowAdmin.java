package Presentacion.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Controlador.Evento;
import Presentacion.Factoria.FactoriaVistas;

public class MainWindowAdmin extends JFrame{
	private FactoriaVistas vistas= FactoriaVistas.getInstance();
	 private JComboBox<Object> combo1;
	 private JComboBox<Object> combo2;
	 private String name;
	 
	 public MainWindowAdmin(String name) {
		 this.name = name;
	 }
	 
	 public void initGUI() {
		 setTitle("COMPLUTACTO");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 JPanel topPanel = new JPanel();
		 topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
		 JButton logout = new JButton("Cerrar sesión");
		 JLabel label = new JLabel("Bienvenido: " + this.name);
		 JLabel cargo = new JLabel("Cargo: Admin");
		 topPanel.add(Box.createHorizontalStrut(10));
		 topPanel.add(label);
		 topPanel.add(Box.createHorizontalStrut(50));
		 topPanel.add(cargo);
		 topPanel.add(Box.createHorizontalStrut(50));
		 topPanel.add(logout);
		 
		logout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				LogInWindow l = new LogInWindow();
				l.initGUI();
			};
		});
		 
		 JPanel mainPanel = new JPanel();
		 JPanel midPanel = new JPanel();
		 JPanel botPanel = new JPanel();
		 midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.Y_AXIS));
		 mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		 botPanel.setLayout(new BoxLayout(botPanel,BoxLayout.Y_AXIS));
		 
		 JPanel panelSelector = new JPanel();
		 panelSelector.setLayout(new BoxLayout(panelSelector,BoxLayout.X_AXIS));
	     combo1=new JComboBox<Object>();
	     combo1.addItem("ALTA_CLIENTE");
	     combo1.addItem("BAJA_CLIENTE");
	     combo1.addItem("MODIFICAR_CLIENTE");
	     combo1.addItem("BUSCAR_CLIENTE");
	     combo1.addItem("MOSTRAR_TODOS_CLIENTE");
		 combo1.setMaximumSize(new Dimension(200,50));
		 combo1.setBackground(Color.WHITE);
		 panelSelector.add(combo1);
		 
		 JPanel panelSelectorEmpleado = new JPanel();
		 panelSelectorEmpleado.setLayout(new BoxLayout(panelSelectorEmpleado,BoxLayout.X_AXIS));
		 combo2=new JComboBox<Object>();
		 combo2.addItem("ALTA_EMPLEADO");
		 combo2.addItem("BAJA_EMPLEADO");
		 combo2.addItem("MODIFICAR_EMPLEADO");
		 combo2.addItem("BUSCAR_EMPLEADO");
		 combo2.addItem("MOSTRAR_TODOS_EMPLEADO");
		 combo2.setMaximumSize(new Dimension(200,50));
		 combo2.setBackground(Color.WHITE);
		 panelSelectorEmpleado.add(combo2);
		 
		 JPanel panelInfo = new JPanel();
		 panelInfo.setLayout(new BoxLayout(panelInfo,BoxLayout.X_AXIS));
		 JLabel info = new JLabel("Elige una opción: ");
		 //panelInfo.add(Box.createHorizontalStrut(120));
		 panelInfo.add(info);
		 
		 JPanel panelInfoEmpleado = new JPanel();
		 panelInfoEmpleado.setLayout(new BoxLayout(panelInfoEmpleado,BoxLayout.X_AXIS));
		 JLabel infoEmp = new JLabel("Elige una opción: ");
		 panelInfoEmpleado.add(infoEmp);
		 
		 JPanel panelBotones = new JPanel();
		 panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.X_AXIS));
		 JButton aceptar = new JButton("Aceptar"); 
		 aceptar.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 String cad= (String) combo1.getSelectedItem();
				 switch(cad) {
				 	case "ALTA_CLIENTE" :{
				 		vistas.generaAltaClienteGUI();
				 	}break;
				 	case "BAJA_CLIENTE" :{
				 		vistas.generaBorrarClienteGUI();
				 	}break;
				 	case "MODIFICAR_CLIENTE" :{
				 		vistas.generaModificarClienteGUI();
				 	}break;
				 	case "BUSCAR_CLIENTE" :{
				 		vistas.generaMostrarClienteGUI();
				 	}break;
				 	case "MOSTRAR_TODOS_CLIENTE" :{
				 		Controlador.getInstance().accion(Evento.MOSTRAR_TODOS_CLIENTE, null);
				 	}break;
				 }
			 };
		 });
		 panelBotones.add(aceptar);
		 
		 JPanel panelBotonesEmpleado = new JPanel();
		 panelBotonesEmpleado.setLayout(new BoxLayout(panelBotonesEmpleado,BoxLayout.X_AXIS));
		 JButton aceptarEmp = new JButton("Aceptar");
		 aceptarEmp.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				String cad= (String) combo1.getSelectedItem();
				switch(cad) {
				 case "ALTA_EMPLEADO" :{
					 //vistas.generaAltaEmpleadoGUI();
				 }break;	
				 case "BAJA_EMPLEADO" :{
					 //vistas.generaBorrarEmpleadoGUI();
			 	 }break;
				 case "MODIFICAR_EMPLEADO" :{
					 //vistas.generaModificarEmpleadoGUI();
				 }break;
				 case "MOSTRAR_EMPLEADO" :{
					 //vistas.generaMostrarEmpleadoGUI();
			 	 }break;
				 case "MOSTRAR_TODOS_EMPLEADO" :{
					 //Controlador.getInstance().accion(Evento.MOSTRAR_TODOS_EMPLEADO, null);
				 }break;
				}
				 	
			 };
		 });
		 
		 midPanel.setBorder(BorderFactory.createTitledBorder("MODULO GESTION CLIENTES"));
		 midPanel.add(Box.createVerticalStrut(40));
		 midPanel.add(panelInfo);
		 midPanel.add(Box.createVerticalStrut(40));
		 midPanel.add(panelSelector);
		 midPanel.add(Box.createVerticalStrut(40));
		 midPanel.add(panelBotones);
		 midPanel.add(Box.createVerticalStrut(40));
		 
		 panelBotonesEmpleado.add(aceptarEmp);
		 botPanel.setBorder(BorderFactory.createTitledBorder("MODULO GESTION EMPLEADOS"));
		 botPanel.add(Box.createVerticalStrut(40));
		 botPanel.add(panelInfoEmpleado);
		 botPanel.add(Box.createVerticalStrut(40));
		 botPanel.add(panelSelectorEmpleado);
		 botPanel.add(Box.createVerticalStrut(40));
		 botPanel.add(panelBotonesEmpleado);
		 botPanel.add(Box.createVerticalStrut(40));
		 
	     mainPanel.add(topPanel);
	     mainPanel.add(midPanel);
	     mainPanel.add(Box.createVerticalStrut(20));
	     mainPanel.add(botPanel);
	    
		 this.setContentPane(mainPanel);
		 this.setBounds(0, 0, 560, 700);
		 this.setVisible(true);
	 }
}
