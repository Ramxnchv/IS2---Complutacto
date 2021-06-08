package Presentacion.Main;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class LogInWindow extends JFrame{
	
	public LogInWindow() {
		super("COMPLUTACTO");
	}
	
	public static void main(String[] args) {
		LogInWindow myWindow=new LogInWindow();
		myWindow.initGUI();
	}

	public void initGUI() {
		JPanel mainPanel = new LogInPanel(this);
		this.setContentPane(mainPanel);
		this.setBounds(500,200, 400, 500);
		this.setResizable(false);
		this.setVisible(true);
	}
}
