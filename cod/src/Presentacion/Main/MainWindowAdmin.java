package Presentacion.Main;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Presentacion.Factoria.FactoriaVistas;

public class MainWindowAdmin extends JFrame{
	private FactoriaVistas vistas= FactoriaVistas.getInstance();
	 private JComboBox<Object> combo1;
	 
	 public void initGUI() {
		 setTitle("COMPLUTACTO");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 JPanel mainPanel = new JPanel();
		 GridLayout g = new GridLayout(6,5,0,9);
		 mainPanel.setLayout(g);
	     combo1=new JComboBox<Object>();
	     
	     
		 this.setContentPane(mainPanel);
		 this.setBounds(0, 0, 700, 700);
		 this.setVisible(true);
		 
	 }
}
