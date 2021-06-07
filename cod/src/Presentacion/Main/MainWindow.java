package Presentacion.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	public MainWindow() {
		super("COMPLUTACTO");
	}
	
	public static void main(String[] args) {
		MainWindow myWindow=new MainWindow();
		myWindow.initGUI();
	}

	private void initGUI() {
		JPanel mainPanel = new MainPanel();
		this.setContentPane(mainPanel);
		this.setBounds(0, 0, 500, 500);
		this.setVisible(true);
		
	}
}
