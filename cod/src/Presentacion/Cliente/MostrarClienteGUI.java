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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Presentacion.Controlador.Controlador.Evento;
import Presentacion.Controlador.Imp.ControladorImp;

public class MostrarClienteGUI extends JFrame{
	
	private JPanel mainPanel;
	private JLabel ldni;
	private JTextField fdni;
	private JLabel lnombre;
	private JTextField fnombre;
	private JButton accept;
	private JButton cancel;
	
	public MostrarClienteGUI() {
		setTitle("BUSCAR CLIENTE");
		this.mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createTitledBorder("BUSCAR CLIENTE"));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
		this.ldni = new JLabel("DNI CLIENTE: ");
		this.ldni.setMaximumSize(new Dimension(100,30));
		this.fdni = new JTextField();
		this.fdni.setMaximumSize(new Dimension(100,30));
		topPanel.add(ldni);
		topPanel.add(Box.createHorizontalStrut(30));
		topPanel.add(fdni);
		this.lnombre = new JLabel("NOMBRE CLIENTE: ");
		this.lnombre.setMaximumSize(new Dimension(130,30));
		this.fnombre = new JTextField();
		this.fnombre.setMaximumSize(new Dimension(150,30));
		topPanel.add(Box.createHorizontalStrut(30));
		topPanel.add(lnombre);
		topPanel.add(Box.createHorizontalStrut(15));
		topPanel.add(fnombre);
		
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
				 if(fdni.getText().equals("") && fnombre.getText().equals("")) {
					 JOptionPane.showMessageDialog(null, "DEBE EXISTIR UN CRITERIO DE BUSQUEDA", "CASILLAS VACIAS", JOptionPane.ERROR_MESSAGE);
				 }
				 else {
					 if(fdni.getText().equals("")) {
						 TCliente cli = new TCliente(null,fnombre.getText());
						 setVisible(false);
						 ControladorImp.getInstance().accion(Evento.MOSTRAR_CLIENTE, cli);
					 }
					 else {
						 TCliente cli = new TCliente(fdni.getText(),null);
						 setVisible(false);
						 ControladorImp.getInstance().accion(Evento.MOSTRAR_CLIENTE, cli);
					 }
					 
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

	public void mostrarCliente(TCliente c) {
		// TODO Auto-generated method stub
		this.mainPanel = new JPanel();
		setTitle("CLIENTE: "+c.getNombre());
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createTitledBorder("BUSQUEDA CLIENTE"));
		MostrarClienteTableModel cm = new MostrarClienteTableModel (c);
		JTable tab = new JTable(cm);
		JScrollPane scrollPane = new JScrollPane(tab);
		tab.setFillsViewportHeight(true);
		mainPanel.add(scrollPane);
		this.setContentPane(mainPanel);
		setBounds(0,0,700,100);
		setVisible(true);
		setResizable(false);
	}
}
