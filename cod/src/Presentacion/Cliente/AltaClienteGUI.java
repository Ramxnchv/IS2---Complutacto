package Presentacion.Cliente;

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
import Presentacion.Controlador.Controlador.Evento;
import Presentacion.Controlador.Imp.ControladorImp;

public class AltaClienteGUI extends JFrame{
	private JPanel mainPanel;
	private JLabel lDNI;
	private JTextField fDNI;
	private JLabel lnombre;
	private JTextField fnombre;
	private JLabel lapellidos;
	private JTextField fapellidos;
	private JLabel ldireccion;
	private JTextField fdireccion;
	private JLabel lDNIempleado;
	private JTextField fDNIempleado;
	private JButton accept;
	private JButton cancel;
	
	public AltaClienteGUI () {
		setTitle("ALTA CLIENTE");
		this.mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createTitledBorder("ALTA CLIENTE"));
		
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel botPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
		midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.X_AXIS));
		botPanel.setLayout(new BoxLayout(botPanel,BoxLayout.X_AXIS));
		
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
		this.ldireccion = new JLabel("Dirección: ");
		this.ldireccion.setMaximumSize(new Dimension(100,30));
		this.fdireccion = new JTextField();
		this.fdireccion.setMaximumSize(new Dimension(200,30));
		
		midPanel.add(Box.createHorizontalStrut(20));
		midPanel.add(lapellidos);
		midPanel.add(fapellidos);
		midPanel.add(Box.createHorizontalStrut(30));
		midPanel.add(ldireccion);
		midPanel.add(fdireccion);
		
		this.lDNIempleado = new JLabel("DNI Empleado: ");
		this.lDNIempleado.setMaximumSize(new Dimension(100,30));
		this.fDNIempleado = new JTextField();
		this.fDNIempleado.setMaximumSize(new Dimension(200,30));
		this.accept = new JButton("Aceptar");
		this.accept.setMaximumSize(new Dimension(150,30));
		this.cancel = new JButton("Cancelar");
		this.cancel.setMaximumSize(new Dimension(150,30));
		
		botPanel.add(Box.createHorizontalStrut(20));
		botPanel.add(lDNIempleado);
		botPanel.add(fDNIempleado);
		botPanel.add(Box.createHorizontalStrut(30));
		botPanel.add(accept);
		botPanel.add(Box.createHorizontalStrut(30));
		botPanel.add(cancel);
		accept.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 if(fnombre.getText().equals("")||fDNI.getText().equals("")||fapellidos.getText().equals("")||fdireccion.getText().equals("")||fDNIempleado.getText().equals("")) {
					 JOptionPane.showMessageDialog(null,  "EXISTEN CAMPOS VACÍOS", "CASILLAS VACIAS", JOptionPane.ERROR_MESSAGE);
				 }
				 else {
					 setVisible(false);
					 TCliente cliente = new TCliente(fDNI.getText(),fnombre.getText(),fapellidos.getText(),fdireccion.getText(),fDNIempleado.getText(),true);
					 ControladorImp.getInstance().accion(Evento.ALTA_CLIENTE, cliente);
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
		
		this.setContentPane(mainPanel);
		setBounds(0,0,700,300);
		setVisible(true);
		setResizable(false);
	}
	
}
