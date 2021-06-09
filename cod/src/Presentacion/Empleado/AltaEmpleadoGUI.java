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
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Negocio.Empleado.TEmpleado;
import Presentacion.Controlador.Controlador.Evento;
import Presentacion.Controlador.Imp.ControladorImp;

public class AltaEmpleadoGUI extends JFrame{
	private JPanel mainPanel;
	private JLabel lDNI;
	private JTextField fDNI;
	private JLabel lnombre;
	private JTextField fnombre;
	private JLabel lapellidos;
	private JTextField fapellidos;
	private JLabel lpassword;
	private JTextField fpassword;
	private JLabel ltelefono;
	private JTextField ftelefono;
	private JLabel lDNIsupervisor;
	private JTextField fDNIsupervisor;
	private JButton accept;
	private JButton cancel;
	
	public AltaEmpleadoGUI() {
		setTitle("ALTA EMPLEADO");
		this.mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createTitledBorder("ALTA EMPLEADO"));
		
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel botPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
		midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.X_AXIS));
		botPanel.setLayout(new BoxLayout(botPanel,BoxLayout.X_AXIS));
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.X_AXIS));
		
		this.lDNI = new JLabel("DNI: ");
		this.lDNI.setMaximumSize(new Dimension(100,30));
		this.fDNI = new JTextField();
		this.fDNI.setMaximumSize(new Dimension(200,30));
		this.lnombre = new JLabel("Nombre: ");
		this.lnombre.setMaximumSize(new Dimension(100,30));
		this.fnombre = new JTextField();
		this.fnombre.setMaximumSize(new Dimension(200,30));
		
		topPanel.add(Box.createHorizontalStrut(20));
		topPanel.add(lDNI);
		topPanel.add(fDNI);
		topPanel.add(Box.createHorizontalStrut(30));
		topPanel.add(lnombre);
		topPanel.add(fnombre);
		
		this.lapellidos = new JLabel("Apellidos: ");
		this.lapellidos.setMaximumSize(new Dimension(100,30));
		this.fapellidos = new JTextField();
		this.fapellidos.setMaximumSize(new Dimension(200,30));
		this.lpassword = new JLabel("Contraseña: ");
		this.lpassword.setMaximumSize(new Dimension(100,30));
		this.fpassword = new JTextField();
		this.fpassword.setMaximumSize(new Dimension(200,30));
		
		midPanel.add(Box.createHorizontalStrut(20));
		midPanel.add(lapellidos);
		midPanel.add(fapellidos);
		midPanel.add(Box.createHorizontalStrut(30));
		midPanel.add(lpassword);
		midPanel.add(fpassword);
		
		this.lDNIsupervisor = new JLabel("DNI Supervisor (opcional): ");
		this.lDNIsupervisor.setMaximumSize(new Dimension(100,30));
		this.fDNIsupervisor = new JTextField();
		this.fDNIsupervisor.setMaximumSize(new Dimension(200,30));
		this.ltelefono = new JLabel("Telefono: ");
		this.ltelefono.setMaximumSize(new Dimension(100,30));
		this.ftelefono = new JTextField();
		this.ftelefono.setMaximumSize(new Dimension(200,30));
		this.accept = new JButton("Aceptar");
		this.accept.setMaximumSize(new Dimension(150,30));
		this.cancel = new JButton("Cancelar");
		this.cancel.setMaximumSize(new Dimension(150,30));
		
		
		botPanel.add(lDNIsupervisor);
		botPanel.add(fDNIsupervisor);
		botPanel.add(Box.createHorizontalStrut(30));
		botPanel.add(ltelefono);
		botPanel.add(ftelefono);
		
		buttonsPanel.add(accept);
		buttonsPanel.add(Box.createHorizontalStrut(30));
		buttonsPanel.add(cancel);
		
		accept.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 if(fnombre.getText().equals("")||fDNI.getText().equals("")||fapellidos.getText().equals("")||fpassword.getText().equals("")||ftelefono.getText().equals("")) {
					 JOptionPane.showMessageDialog(null,  "EXISTEN CAMPOS VACÍOS", "CASILLAS VACIAS", JOptionPane.ERROR_MESSAGE);
				 }
				 else {
					 TEmpleado emp = null;
					 setVisible(false);
					 if(fDNIsupervisor.getText().equals("")) {
						 emp = new TEmpleado(fDNI.getText(), fnombre.getText(),fapellidos.getText(),Integer.valueOf(ftelefono.getText()),fpassword.getText(),null);
					 }
					 else {
						 emp = new TEmpleado(fDNI.getText(), fnombre.getText(),fapellidos.getText(),Integer.valueOf(ftelefono.getText()),fpassword.getText(),fDNIsupervisor.getText());
					 }
					 
					 ControladorImp.getInstance().accion(Evento.ALTA_EMPLEADO, emp);
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
		mainPanel.add(midPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(botPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(buttonsPanel);
		
		this.setContentPane(mainPanel);
		setBounds(0,0,700,300);
		setVisible(true);
		setResizable(false);
	}
}
