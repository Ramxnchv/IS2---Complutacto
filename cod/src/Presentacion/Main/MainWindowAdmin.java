package Presentacion.Main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentacion.Factoria.FactoriaVistas;

public class MainWindowAdmin extends JFrame{
	private FactoriaVistas vistas= FactoriaVistas.getInstance();
	 private JComboBox<Object> combo1;
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
		 topPanel.add(Box.createHorizontalStrut(120));
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
		 GridLayout g = new GridLayout(6,5,0,9);
		 mainPanel.setLayout(g);
	     combo1=new JComboBox<Object>();
	     mainPanel.add(topPanel);
	     
	     
		 this.setContentPane(mainPanel);
		 this.setBounds(0, 0, 700, 700);
		 this.setVisible(true);
		 
	 }
}
