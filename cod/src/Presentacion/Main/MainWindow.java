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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Negocio.Empleado.TEmpleado;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Controlador.Evento;
import Presentacion.Controlador.Imp.ControladorImp;
import Presentacion.Factoria.FactoriaVistas;

public class MainWindow extends JFrame {
	 private FactoriaVistas vistas= FactoriaVistas.getInstance();
	 private JComboBox<Object> combo1;
	 private String name;
	 
	 public MainWindow(String name) {
		 this.name = name;
	 }
	 
	 public void initGUI() {
		 setTitle("COMPLUTACTO");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 JPanel topPanel = new JPanel();
		 topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
		 JButton logout = new JButton("Cerrar sesión");
		 JLabel label = new JLabel("Bienvenido: " + this.name);
		 JLabel cargo = new JLabel("Cargo: Empleado");
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
		 midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.Y_AXIS));
		 mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		 
		 JPanel panelSelector = new JPanel();
		 panelSelector.setLayout(new BoxLayout(panelSelector,BoxLayout.X_AXIS));
	     combo1=new JComboBox<Object>();
	     combo1.addItem("ALTA_CLIENTE");
	     combo1.addItem("BAJA_CLIENTE");
	     combo1.addItem("MODIFICAR_CLIENTE");
	     combo1.addItem("BUSCAR_CLIENTE");
	     combo1.addItem("MOSTRAR_TODOS_CLIENTE");
//	     combo1.setBounds(120,10,50,30);
		 combo1.setMaximumSize(new Dimension(200,50));
		 combo1.setBackground(Color.WHITE);
		 //panelSelector.add(Box.createHorizontalStrut(120));
		 panelSelector.add(combo1);
		 
		 JPanel panelInfo = new JPanel();
		 panelInfo.setLayout(new BoxLayout(panelInfo,BoxLayout.X_AXIS));
		 JLabel info = new JLabel("Elige una opción: ");
		 //panelInfo.add(Box.createHorizontalStrut(120));
		 panelInfo.add(info);
		 
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
				 	case "MOSTRAR_CLIENTE" :{
				 		vistas.generaMostrarClienteGUI();
				 	}break;
				 	case "MOSTRAR_TODOS_CLIENTE" :{
				 		Controlador.getInstance().accion(Evento.MOSTRAR_TODOS_CLIENTE, null);
				 	}break;
				 }
			 };
		 });
		 
		 panelBotones.add(aceptar);
		 
		 midPanel.setBorder(BorderFactory.createTitledBorder("MODULO GESTION CLIENTES"));
		 midPanel.add(Box.createVerticalStrut(40));
		 midPanel.add(panelInfo);
		 midPanel.add(Box.createVerticalStrut(40));
		 midPanel.add(panelSelector);
		 midPanel.add(Box.createVerticalStrut(40));
		 midPanel.add(panelBotones);
		 midPanel.add(Box.createVerticalStrut(40));
	     mainPanel.add(topPanel);
	     mainPanel.add(midPanel);
	     
	     
	     
	     
		 this.setContentPane(mainPanel);
		 this.setBounds(0, 0, 560, 400);
		 this.setVisible(true);
		 
	 }
}
