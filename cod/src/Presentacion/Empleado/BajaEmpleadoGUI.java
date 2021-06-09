package Presentacion.Empleado;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Presentacion.Controlador.Controlador.Evento;
import Presentacion.Controlador.Imp.ControladorImp;

public class BajaEmpleadoGUI extends JFrame {
	private JPanel mainPanel;
	private JLabel ldni;
	private JTextArea fdni;
	private JButton accept;
	private JButton cancel;
	
	public BajaEmpleadoGUI() {
		setTitle("BAJA EMPLEADO");
		this.mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createTitledBorder("BAJA EMPLEADO"));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
		this.ldni = new JLabel("DNI EMPLEADO: ");
		this.ldni.setMaximumSize(new Dimension(100,30));
		this.fdni = new JTextArea();
		this.fdni.setMaximumSize(new Dimension(100,30));
		topPanel.add(ldni);
		topPanel.add(Box.createHorizontalStrut(30));
		topPanel.add(fdni);
		
		JPanel botPanel = new JPanel();
		botPanel.setLayout(new BoxLayout(botPanel,BoxLayout.X_AXIS));
		this.accept = new JButton("Aceptar");
		accept.setMaximumSize(new Dimension(100, 30));
		this.cancel = new JButton("Cancelar");
		cancel.setMaximumSize(new Dimension(100,30));
		botPanel.add(accept);
		botPanel.add(Box.createHorizontalStrut(30));
		botPanel.add(cancel);
		
		accept.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 if(fdni.getText().equals("")) {
					 JOptionPane.showMessageDialog(null,  "EL DNI NO PUEDE SER VACIO", "CASILLAS VACIAS", JOptionPane.ERROR_MESSAGE);
				 }
				 else {
					 String dni = fdni.getText();
					 setVisible(false);
					 ControladorImp.getInstance().accion(Evento.BAJA_EMPLEADO, dni);
				 }
			 };
		});
		
		cancel.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 setVisible(false);
			 };
		});
		
		mainPanel.add(topPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(botPanel);
		
		this.setContentPane(mainPanel);
		setBounds(0,0,700,300);
		setVisible(true);
		setResizable(false);
	}
}
