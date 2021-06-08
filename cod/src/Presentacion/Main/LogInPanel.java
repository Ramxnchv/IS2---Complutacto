package Presentacion.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Negocio.Empleado.TEmpleado;
import Presentacion.Controlador.Controlador.Evento;
import Presentacion.Controlador.Imp.ControladorImp;
import Presentacion.Factoria.FactoriaVistas;

public class LogInPanel extends JPanel {
	
	JFrame loginframe;
	
	public LogInPanel(JFrame loginframe) {
		this.loginframe = loginframe;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("LOG IN"));
		initGUI();
	}
	
	private void initGUI() {
		//subpanelimage
		JPanel subPanelImage = new JPanel();
		subPanelImage.setLayout(new BoxLayout(subPanelImage,BoxLayout.X_AXIS));	
		JLabel imagen = new JLabel(new ImageIcon("fotoIS.jpg"));
		imagen.setPreferredSize(new Dimension(100,100));
		
		//subpanel1
		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new BoxLayout(subPanel1,BoxLayout.Y_AXIS));
		subPanel1.setBorder(BorderFactory.createEmptyBorder(50,100, 50, 100));
		JLabel user = new JLabel("USER (DNI) : ");
		JTextField user1 = new JTextField();
		user1.setMaximumSize(new Dimension(500,30));
		JLabel pw = new JLabel("PASSWORD : ");
		JPasswordField pw1 = new JPasswordField();
		pw1.setMaximumSize(new Dimension(500,30));
		
		
		//subpanel2
		JPanel subPanel2 = new JPanel();
		
		subPanel2.setLayout(new BoxLayout(subPanel2,BoxLayout.X_AXIS));	
		
		JButton logIn = new JButton("Log In");
		JButton close = new JButton("Close");
		
		
		logIn.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 String user = user1.getText();
				 String pass = String.valueOf(pw1.getPassword());
				 if(user.equals("") || pass.equals("")) {
					JOptionPane.showMessageDialog(null,"Error: Los campos no pueden ser vac�os", "Error", JOptionPane.ERROR_MESSAGE) ;
				 }
				 else {
					 TEmpleado empleado = new TEmpleado(user,pass);
					 ControladorImp.getInstance().accion(Evento.LOG_IN_EMPLEADO, empleado);
					 loginframe.setVisible(false);
				 }
				 
			 };
		});
		
		close.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 System.exit(0);
			 };
		});
		
		//anyadir las cosas
		subPanelImage.add(Box.createHorizontalStrut(50));
		subPanelImage.add(imagen);
		subPanelImage.add(Box.createRigidArea(new Dimension(50,50)));
		this.add(subPanelImage,BorderLayout.NORTH);
		subPanel1.add(user);
		subPanel1.add(user1);
		subPanel1.add(Box.createRigidArea(new Dimension(50,50)));
		subPanel1.add(pw);
		subPanel1.add(pw1);
		this.add(subPanel1,BorderLayout.CENTER);
		subPanel2.add(Box.createHorizontalStrut(70));
		subPanel2.add(logIn);
		subPanel2.add(Box.createRigidArea(new Dimension(100,100)));
		subPanel2.add(close);
		this.add(subPanel2,BorderLayout.SOUTH);
		
		repaint();
	}
	
}
